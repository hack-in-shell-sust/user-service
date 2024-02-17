package com.example.userservice.service;

import com.example.userservice.data.entity.UserInfo;
import com.example.userservice.data.repository.UserInfoRepository;
import com.example.userservice.domain.dto.UserInfoCreateRequest;
import com.example.userservice.domain.dto.UserInfoRequest;
import com.example.userservice.domain.dto.UserUpdateRequest;
import com.example.userservice.domain.mapper.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService {
    private final UserInfoRepository userInfoRepository;
    private final UserInfoMapper userInfoMapper;
    public UserInfo getUserInfo(String email) {
        Optional<UserInfo> userInfo = userInfoRepository.findByEmail(email);
        if(userInfo.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        return userInfo.get();
    }

    public UserInfo updateUserInfo(UserUpdateRequest userUpdateRequest) {
        UserInfo userInfo = this.getUserInfo(userUpdateRequest.getEmail());

        UserInfo updatedUserInfo = this.updateUserInfo(userInfo, userUpdateRequest);

        UserInfo newUserInfo = userInfoRepository.save(updatedUserInfo);

        return newUserInfo;
    }


    public UserInfo createUserInfo(UserInfoCreateRequest userInfoCreateRequest) {
        Optional<UserInfo> userInfo = userInfoRepository.findByEmail(userInfoCreateRequest.getEmail());
        if(userInfo.isPresent()) {
            throw new RuntimeException("User Info already exists");
        }
        UserInfo newUserInfo = new UserInfo();
        newUserInfo.setEmail(userInfoCreateRequest.getEmail());
        newUserInfo.setUserId(userInfoCreateRequest.getUserId());

        return userInfoRepository.save(newUserInfo);
    }

    private UserInfo updateUserInfo(UserInfo userInfo, UserUpdateRequest request) {
        if(request.getName() != null) {
            userInfo.setName(request.getName());
        }
        if(request.getWeight() != null) {
            userInfo.setWeight(request.getWeight());
        }
        if(request.getHeight() != null) {
            userInfo.setHeight(request.getHeight());
        }
        if(request.getDateOfBirth() != null) {
            userInfo.setDateOfBirth(request.getDateOfBirth());
        }
        if(request.getDescription() != null) {
            userInfo.setDescription(request.getDescription());
        }
        return userInfo;
    }
}
