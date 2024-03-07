package com.nklcb.cosmos.board.entity;

import com.nklcb.cosmos.global.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {
    Long parentBoard;

    String boardName;

    @OneToMany(mappedBy = "board")
    List<Post> posts = new ArrayList<>();
}
