package com.illud.redalert.web.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.illud.redalert.client.redalertmicroservice.api.CommentResourceApi;
import com.illud.redalert.client.redalertmicroservice.api.PostResourceApi;
import com.illud.redalert.client.redalertmicroservice.model.CommentDTO;
import com.illud.redalert.client.redalertmicroservice.model.PostDTO;
import com.illud.redalert.web.rest.errors.BadRequestAlertException;
@RestController
@RequestMapping("/api")
public class RedAlertAggregateResource {
	
	private final Logger log = LoggerFactory.getLogger(RedAlertAggregateResource.class);
	
	private static final String ENTITY_NAME = "redAlertFriend";
	
	
	
	@Autowired
	private PostResourceApi postResourceApi;
	
	@Autowired
	private CommentResourceApi commentResourceApi;
	
	
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
