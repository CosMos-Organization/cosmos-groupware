package com.nklcb.cosmos.board.service;

import com.nklcb.cosmos.board.dto.PostDto;
import com.nklcb.cosmos.board.entity.Board;
import com.nklcb.cosmos.board.entity.Post;
import com.nklcb.cosmos.board.repository.BoardRepository;
import com.nklcb.cosmos.board.repository.PostRepository;
import com.nklcb.cosmos.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    @Override
    public PostDto.PostResponse createPost(PostDto.PostCreateRequest postCreateRequest) {
        Board board = boardRepository.findById(postCreateRequest.getBoardId()).orElseThrow(() -> new IllegalStateException("존재하지 않는 board입니다."));

        // member repo 설정 후 추가
        Member member = new Member();
        member.setId(1L);
        //member

        Post post = Post.builder()
                .title(postCreateRequest.getTitle())
                .content(postCreateRequest.getContent())
                .board(board)
                .member(member)
                .build();
        return PostDto.PostResponse.of(postRepository.save(post));
    }
}
