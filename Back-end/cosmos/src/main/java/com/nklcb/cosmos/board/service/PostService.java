package com.nklcb.cosmos.board.service;

import com.nklcb.cosmos.board.dto.PostDto;

public interface PostService {
    public PostDto.PostResponse createPost(PostDto.PostCreateRequest postCreateRequest);

}
