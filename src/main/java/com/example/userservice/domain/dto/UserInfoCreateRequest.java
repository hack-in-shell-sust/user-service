package com.example.userservice.domain.dto;

import lombok.Data;

@Data
public class UserInfoCreateRequest {
    private String email;
    private Long userId;
}
