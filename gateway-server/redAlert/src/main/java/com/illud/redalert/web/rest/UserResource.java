package com.illud.redalert.web.rest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.illud.redalert.client.redalertmicroservice.api.UserExtraResourceApi;
import com.illud.redalert.client.redalertmicroservice.api.UserResourceApi;
import com.illud.redalert.client.redalertmicroservice.model.FriendsList;
import com.illud.redalert.client.redalertmicroservice.model.UserExtra;
import com.illud.redalert.config.Constants;
import com.illud.redalert.security.AuthoritiesConstants;
import com.illud.redalert.service.UserService;
import com.illud.redalert.service.dto.UserDTO;
import com.illud.redalert.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing users.
 * <p>
 * This class accesses the User entity, and needs to fetch its collection of authorities.
 * <p>
 * For a normal use-case, it would be better to have an eager relationship between User and Authority,
 * and send everything to the client side: there would be no View Model and DTO, a lot less code, and an outer-join
 * which would be good for performance.
 * <p>
 * We use a View Model and a DTO for 3 reasons:
 * <ul>
 * <li>We want to keep a lazy association between the user and the authorities, because people will
 * quite often do relationships with the user, and we don't want them to get the authorities all
 * the time for nothing (for performance reasons). This is the #1 goal: we should not impact our users'
 * application because of this use-case.</li>
 * <li> Not having an outer join causes n+1 requests to the database. This is not a real issue as
 * we have by default a second-level cache. This means on the first HTTP call we do the n+1 requests,
 * but then all authorities come from the cache, so in fact it's much better than doing an outer join
 * (which will get lots of data from the database, for each HTTP call).</li>
 * <li> As this manages users, for security reasons, we'd rather have a DTO layer.</li>
 * </ul>
 * <p>
 * Another option would be to have a specific JPA entity graph to handle this case.
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private final UserService userService;
    
    @Autowired
    UserExtraResourceApi userExtraResourceApi;
    
    @Autowired
    AccountResource accountResource;
    public UserResource(UserService userService) {

        this.userService = userService;
    }

    /**
     * GET /users : get all users.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all users
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(Pageable pageable) {
        final Page<UserDTO> page = userService.getAllManagedUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/users");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * @return a string list of the all of the roles
     */
    @GetMapping("/users/authorities")
    @PreAuthorize("hasRole(\"" + AuthoritiesConstants.ADMIN + "\")")
    public List<String> getAuthorities() {
        return userService.getAuthorities();
    }

    /**
     * GET /users/:login : get the "login" user.
     *
     * @param login the login of the user to find
     * @return the ResponseEntity with status 200 (OK) and with body the "login" user, or with status 404 (Not Found)
     */
    @GetMapping("/users/{login:" + Constants.LOGIN_REGEX + "}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String login) {
        log.debug("REST request to get User : {}", login);
        return ResponseUtil.wrapOrNotFound(
            userService.getUserWithAuthoritiesByLogin(login)
                .map(UserDTO::new));
    }
    
    @GetMapping("/users/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
    	return ResponseUtil.wrapOrNotFound(Optional.of(userService.getUserByEmail(email)));
    }
    
    @GetMapping("/users/friends-of/{email}")
    public ResponseEntity<List<UserDTO>> getFriends(@PathVariable String email) {
    	Set<String> emails = new HashSet<>();
    	userExtraResourceApi.getUserExtraUsingGET(email).getBody().getFriends().forEach(friend->{emails.add(friend.getUserEmail());});
    	List<UserDTO> users= new ArrayList<>();
    	emails.forEach((userEmail)->{
    		users.add(userService.getUserByEmail(userEmail));
    	});
    	return ResponseEntity.ok().body(users);
    }
    
    @GetMapping("/users/add-friend/{email}")
    public ResponseEntity<List<UserDTO>> addFriend(@PathVariable String email,Principal principal) {
    	UserDTO dto=accountResource.getAccount(principal);
    	UserExtra extra= userExtraResourceApi.getUserExtraUsingGET(dto.getEmail()).getBody();
    	FriendsList friend = new FriendsList();
    	friend.setUserEmail(email);
    	extra.addFriendsItem(friend);
    	userExtraResourceApi.updateUserExtraUsingPUT(extra);
    	return getFriends(extra.getUserEmail());
    }
    
    @GetMapping("/users/un-friend/{email}")
    public ResponseEntity<List<UserDTO>> unFriend(@PathVariable String email,Principal principal) {
    	UserDTO dto=accountResource.getAccount(principal);
    	UserExtra extra= userExtraResourceApi.getUserExtraUsingGET(dto.getEmail()).getBody();
    	FriendsList friend = new FriendsList();
    	friend.setUserEmail(email);
    	for(FriendsList frnd: extra.getFriends()) {
    		if(frnd.getUserEmail().equals(email)) {
    			extra.getFriends().remove(extra.getFriends().indexOf(frnd));
    			break;
    		}
    	}
    	userExtraResourceApi.updateUserExtraUsingPUT(extra);
    	return getFriends(extra.getUserEmail());
    }
    
    @GetMapping("/users/friend-suggestions")
    public ResponseEntity<List<UserDTO>> getSuggestions(Principal principal,Pageable pageable) {
    	UserDTO dto=accountResource.getAccount(principal);
    	List<UserDTO> friends = getFriends(dto.getEmail()).getBody();
    	List<UserDTO> allUsers= new LinkedList<>(getAllUsers(pageable).getBody());
    	for(UserDTO frnd:friends) {
    		for(int i=0;i<allUsers.size();i++) {
    			if(allUsers.get(i).getEmail().equals(frnd.getEmail())) {
    				allUsers.remove(i);
    			}
    		}
    	}
    	for(int i=0;i<allUsers.size();i++) {
			if(allUsers.get(i).getEmail().equals(dto.getEmail())) {
				allUsers.remove(i);
			}
		}
    	return ResponseEntity.ok().body(allUsers);
    }
}
