package com.example.userservice.controller;

import com.example.userservice.common.utils.IPUtils;
import com.example.userservice.data.entity.UserInfo;
import com.example.userservice.domain.dto.UserInfoCreateRequest;
import com.example.userservice.domain.dto.UserInfoRequest;
import com.example.userservice.domain.dto.UserUpdateRequest;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping( IPUtils.defaultUrl)
public class UserResource extends  BaseResource {
    private final UserService userService;

    @PostMapping("/")
    public UserInfo getUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        return userService.getUserInfo(userInfoRequest.getEmail());
    }

    @PostMapping("/create")
    public UserInfo createUserInfo(@RequestBody UserInfoCreateRequest userInfoCreateRequest) {
        return userService.createUserInfo(userInfoCreateRequest);
    }

    @PostMapping("/update")
    public UserInfo updateUserInfo(@RequestBody UserUpdateRequest userUpdateRequest) {
        return userService.updateUserInfo(userUpdateRequest);
    }
}
