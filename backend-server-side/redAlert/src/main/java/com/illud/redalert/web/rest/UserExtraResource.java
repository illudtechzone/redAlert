package com.illud.redalert.web.rest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.illud.redalert.domain.FriendsList;
import com.illud.redalert.domain.UserExtra;
import com.illud.redalert.repository.FriendsListRepository;
import com.illud.redalert.service.UserExtraService;
import com.illud.redalert.web.rest.errors.BadRequestAlertException;
import com.illud.redalert.web.rest.util.HeaderUtil;
import com.illud.redalert.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing UserExtra.
 */
@RestController
@RequestMapping("/api")
public class UserExtraResource {

    private final Logger log = LoggerFactory.getLogger(UserExtraResource.class);

    private static final String ENTITY_NAME = "redAlertUserExtra";

    private final UserExtraService userExtraService;
    private final FriendsListRepository friendsListRepository;

    public UserExtraResource(UserExtraService userExtraService, FriendsListRepository friendsListRepository) {
        this.userExtraService = userExtraService;
        this.friendsListRepository=friendsListRepository;
    }

    /**
     * POST  /user-extras : Create a new userExtra.
     *
     * @param userExtra the userExtra to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userExtra, or with status 400 (Bad Request) if the userExtra has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/user-extras")
    public ResponseEntity<UserExtra> createUserExtra(@RequestBody UserExtra userExtra) throws URISyntaxException {
        log.debug("REST request to save UserExtra : {}", userExtra);
        if (userExtra.getId() != null) {
            throw new BadRequestAlertException("A new userExtra cannot already have an ID", ENTITY_NAME, "idexists");
        }
        saveOrGetFriends(userExtra, friendsListRepository);
        UserExtra result = userExtraService.save(userExtra);
        return ResponseEntity.created(new URI("/api/user-extras/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    private static void saveOrGetFriends(UserExtra userExtra, FriendsListRepository friendsListRepository) {
    	Set<String> emails=new HashSet<String>();
        userExtra.getFriends().forEach(u->emails.add(u.getUserEmail()));
        userExtra.setFriends(new HashSet<>());
        emails.forEach(email->{
        	Optional<FriendsList> friendList;
        	if((friendList=friendsListRepository.findByUserEmail(email)).isPresent()) {
        		userExtra.addFriends(friendList.get());
        	}
        	else {
        		FriendsList friend= new FriendsList();
        		friend.setUserEmail(email);
        		userExtra.addFriends(friendsListRepository.save(friend));
        	}
        		});
    }

    /**
     * PUT  /user-extras : Updates an existing userExtra.
     *
     * @param userExtra the userExtra to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userExtra,
     * or with status 400 (Bad Request) if the userExtra is not valid,
     * or with status 500 (Internal Server Error) if the userExtra couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/user-extras")
    public ResponseEntity<UserExtra> updateUserExtra(@RequestBody UserExtra userExtra) throws URISyntaxException {
        log.debug("REST request to update UserExtra : {}", userExtra);
        if (userExtra.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        saveOrGetFriends(userExtra, friendsListRepository);
        UserExtra result = userExtraService.save(userExtra);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userExtra.getId().toString()))
            .body(result);
    }

    /**
     * GET  /user-extras : get all the userExtras.
     *
     * @param pageable the pagination information
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many)
     * @return the ResponseEntity with status 200 (OK) and the list of userExtras in body
     */
    @GetMapping("/user-extras")
    public ResponseEntity<List<UserExtra>> getAllUserExtras(Pageable pageable, @RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get a page of UserExtras");
        Page<UserExtra> page;
        if (eagerload) {
            page = userExtraService.findAllWithEagerRelationships(pageable);
        } else {
            page = userExtraService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, String.format("/api/user-extras?eagerload=%b", eagerload));
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /user-extras/:id : get the "id" userExtra.
     *
     * @param id the id of the userExtra to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the userExtra, or with status 404 (Not Found)
     */
    @GetMapping("/user-extras/{userEmail}")
    public ResponseEntity<UserExtra> getUserExtra(@PathVariable String userEmail) {
        log.debug("REST request to get UserExtra : {}", userEmail);
        Optional<UserExtra> userExtra = userExtraService.findOne(userEmail);
        return ResponseUtil.wrapOrNotFound(userExtra);
    }

    /**
     * DELETE  /user-extras/:id : delete the "id" userExtra.
     *
     * @param id the id of the userExtra to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/user-extras/{userEmail}")
    public ResponseEntity<Void> deleteUserExtra(@PathVariable String userEmail) {
        log.debug("REST request to delete UserExtra : {}", userEmail);
        Long id;
        try {
        	id= userExtraService.findOne(userEmail).orElseGet(null).getId();
        }catch (NullPointerException e) {
			return ResponseEntity.notFound().build();
		}
        userExtraService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, userEmail)).build();
    }
}
