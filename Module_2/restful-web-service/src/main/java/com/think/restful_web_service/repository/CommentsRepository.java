package com.think.restful_web_service.repository;

import com.think.restful_web_service.dao.Comments;
import com.think.restful_web_service.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {
    List<Comments> findByPost(Post post);
}
