package com.think.restful_web_service.repository;

import com.think.restful_web_service.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
//List<Post> findByUserId(int id);
}
