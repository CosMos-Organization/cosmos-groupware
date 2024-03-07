package com.nklcb.cosmos.board.repository;

import com.nklcb.cosmos.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
