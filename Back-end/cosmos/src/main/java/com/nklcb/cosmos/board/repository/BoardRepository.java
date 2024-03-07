package com.nklcb.cosmos.board.repository;

import com.nklcb.cosmos.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board , Long> {

}
