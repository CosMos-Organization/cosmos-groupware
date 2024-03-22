package com.nklcb.cosmos.commute.service;

import com.nklcb.cosmos.commute.dto.CommuteDTO;

public interface CommuteService {
    public CommuteDTO.CommuteResponse createCommute(CommuteDTO.CommuteCreateRequest commuteCreateRequest);
}
