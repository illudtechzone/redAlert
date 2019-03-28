package com.illud.redalert.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.illud.redalert.service.UserService;

import com.illud.redalert.web.rest.errors.BadRequestAlertException;
import com.illud.redalert.web.rest.util.HeaderUtil;
import com.illud.redalert.web.rest.util.PaginationUtil;
import com.illud.redalert.client.redalertmicroservice.api.CommentResourceApi;
import com.illud.redalert.client.redalertmicroservice.api.FriendResourceApi;
import com.illud.redalert.client.redalertmicroservice.api.PostResourceApi;
import com.illud.redalert.client.redalertmicroservice.model.*;
@RestController
@RequestMapping("/apig")
public class RedAlertAggregateResource {
	
	private final Logger log = LoggerFactory.getLogger(RedAlertAggregateResource.class);
	
	private static final String ENTITY_NAME = "redAlertFriend";
	
	@Autowired
	private FriendResourceApi friendResourceApi;
	
	@Autowired
	private PostResourceApi postResourceApi;
	
	@Autowired
	private CommentResourceApi commentResourceApi;
	
	@PostMapping("friends")
	public ResponseEntity<FriendDTO> createFriend(@RequestBody FriendDTO friendDTO) throws URISyntaxException {
		log.debug(" |||---client request to save Friend :---||| ", friendDTO);
		if (friendDTO.getId() != null) {
            throw new BadRequestAlertException("A new friend cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ResponseEntity<FriendDTO> result = friendResourceApi.createFriendUsingPOST(friendDTO);
        return result;
	
	}
	@GetMapping("friends/{userId}")
	public ResponseEntity<List<FriendDTO>> findByUserName(@PathVariable String userId,Pageable pageable){
		log.debug(" |||---client request to get user name  :---||| ", userId);
		
		  ArrayList<Order> list=new ArrayList<Order>();
		  pageable.getSort().stream().forEach(list::add);
		 
		  
		  List<String> sortList=new ArrayList<String>();
		 
		  
		 /* list.stream().map(x->x.toString()).forEach(sortList::add);
		 */
		
		for(Order order:list)
		{
			sortList.add(order.toString());
		}
		
		
		/*
		 * log.debug("sortList size ::::::::::::::::::::::::::::::::::::::::::::::::::"
		 * +sortList.size()); ResponseEntity<List<FriendDTO>> page =
		 * friendResourceApi.findByUserNameUsingGET(userId,pageable.getPageNumber(),
		 * pageable.getPageSize(),pageable.getSort());
		 */
		
		
		return friendResourceApi.findByUserNameUsingGET(userId,pageable.getPageNumber(),
				 pageable.getPageSize(),sortList);
	}
	@GetMapping("post/{userId}")
	public ResponseEntity<List<PostDTO>> findPostsByUserId(@PathVariable String userId, Pageable pageable){
		log.debug(" |||---client request to get postbyuserid  :---||| ", userId);
		
		ArrayList<Order> list=new ArrayList<Order>();
		pageable.getSort().stream().forEach(list::add);
		List<String> sortlist=new ArrayList<String>();
		
		list.stream().map(x->x.toString()).forEach(sortlist::add);
		
		return postResourceApi.findPostsByUserIdUsingGET(userId,pageable.getPageNumber(),pageable.getPageSize(),sortlist);
		
	}
	@PostMapping("post")
	public ResponseEntity<PostDTO> CreatePost(@RequestBody PostDTO postDTO) throws URISyntaxException{
		log.debug(" |||---client create post  :---||| ", postDTO);
		if (postDTO.getId() != null) {
            throw new BadRequestAlertException("A new friend cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ResponseEntity<PostDTO> result = postResourceApi.createPostUsingPOST(postDTO);
        return result;
		
	}
	@PostMapping("comment")
	public ResponseEntity<CommentDTO> CraeteComment(@RequestBody CommentDTO commentDTO) throws URISyntaxException{
		log.debug(" |||---client create comment  :---||| ", commentDTO);
		if(commentDTO.getId()!=null) {
			throw new BadRequestAlertException("A new Friend is not allowed already have an ID :", ENTITY_NAME,"idexists);");
		}
		ResponseEntity<CommentDTO> result = commentResourceApi.createCommentUsingPOST(commentDTO);
        return result;
		
	}
	@GetMapping("comment/{postId}")
	public ResponseEntity<List<CommentDTO>> findCommentByPostId(@PathVariable long postId,Pageable pageable){
		log.debug(" |||---client findcommentbypostid comment  :---||| ", postId);
		
		ArrayList<Order> list=new ArrayList<Order>();
		pageable.getSort().stream().forEach(list::add);
		List<String> sortlist=new ArrayList<String>();
		
		list.stream().map(x->x.toString()).forEach(sortlist::add);
		
		return commentResourceApi.findCommentsByPostIdUsingGET(postId,pageable.getPageNumber(),pageable.getPageSize(),sortlist);
			
	}
}