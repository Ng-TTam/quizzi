package com.quizzi.api_gateway.service;

import com.quizzi.api_gateway.dto.ApiResponse;
import com.quizzi.api_gateway.dto.request.VerifyTokenRequest;
import com.quizzi.api_gateway.dto.response.VerifyTokenResponse;
import com.quizzi.api_gateway.repository.IdentityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class IdentityService {
    @Autowired
    IdentityClient identityClient;

    public Mono<ApiResponse<VerifyTokenResponse>> verify(String token){
        return identityClient.verify(VerifyTokenRequest.builder()
                .token(token)
                .build());
    }
}