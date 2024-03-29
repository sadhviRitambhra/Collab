package com.niit.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.ForumCommentsDao;
import com.niit.model.Forum;
import com.niit.model.ForumComments;

@RestController
@RequestMapping("api/")
public class ForumCommentsController {
@Autowired
ForumComments forumComments;

@Autowired
ForumCommentsDao forumCommentsDao;

@GetMapping(value = "allForumComments/{id}")
public ResponseEntity<List<ForumComments>> getallForumComments(@PathVariable ("id") int id) {
	List<ForumComments> allForumComments = forumCommentsDao.getAllComments(id);
	return new ResponseEntity<List<ForumComments>>(allForumComments, HttpStatus.OK);
}


@PostMapping("/newForumComments")
public ResponseEntity<List<ForumComments>> newForumComments(@RequestBody ForumComments forumComments) {
	forumCommentsDao.addForumComment(forumComments);
		return new ResponseEntity<List<ForumComments>>(forumCommentsDao.getAllComments(forumComments.getForumId()),HttpStatus.OK);
	}

@PutMapping(value="deleteForumComments/{id}")
@ResponseBody
public ResponseEntity<ForumComments> deleteForumComments(@PathVariable("id") int id){
	
	forumCommentsDao.deleteForumComment(id);
	return new ResponseEntity<ForumComments>(HttpStatus.OK);
	
}

}

