package com.illud.redalert.web.rest;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.illud.redalert.client.redalertmicroservice.api.CommentResourceApi;
import com.illud.redalert.client.redalertmicroservice.model.CommentDTO;
import com.illud.redalert.web.rest.errors.BadRequestAlertException;

@RestController
@RequestMapping("/apic")
public class CrimeStopperAggrigate {
	
	private final Logger log = LoggerFactory.getLogger(RedAlertAggregateResource.class);
	
	private static final String ENTITY_NAME = "redAlertFriend";
	
	@Autowired
	private CommentResourceApi commentResourceApi;
	
	@PostMapping("comment")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) throws URISyntaxException{
		log.debug(" |||---the client side crimestopper create ---||| ", commentDTO);
		if(commentDTO. getId()!=null) {
			throw new BadRequestAlertException("a new friend cannot have accept", ENTITY_NAME,"idexists");
		}
		ResponseEntity<CommentDTO> commentResult =commentResourceApi.createCommentUsingPOST(commentDTO);
		return commentResult;
	}
	/*
	 * @GetMapping("comment/{complaintId}") public ResponseEntity<List<CommentDTO>>
	 * getAllCommentsOfComplaintId(@PathVariable long complaintId,Pageable
	 * pageable){ log.
	 * debug(" |||---the client side crimestopper getallcommentsofcomplaintid ---||| "
	 * , complaintId); Page<CommentDTO> page =
	 * commentResourceApi.findAllByComplaintId(pageable, complaintId);
	 * 
	 * //ResponseEntity<List<CommentDTO>> rc=commentResourceApi.
	 * getAllCommentsOfComplaintIdUsingGET() return null;
	 * 
	 * }
	 */
}
