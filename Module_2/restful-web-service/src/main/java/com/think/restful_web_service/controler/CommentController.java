package com.think.restful_web_service.controler;


import com.think.restful_web_service.dao.Comments;
import com.think.restful_web_service.dao.Post;
import com.think.restful_web_service.repository.CommentsRepository;
import com.think.restful_web_service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa-user/post/comment/{id}")
    public List<Comments> getcommentbyPostId(@PathVariable int id) {
        Post post = postRepository.findById(id).get();
        return commentsRepository.findByPost(post);
    }

    @PostMapping("/jpa-user/post/comment/{id}")
    public Comments saveComment(@RequestBody Comments comments, @PathVariable int id) {
        Post post = postRepository.findById(id).get();
        comments.setPost(post);
        comments.setCommentTime(LocalTime.now());
        return commentsRepository.save(comments);
    }

}
