package com.example.userservice.domain.mapper;

import com.example.userservice.data.entity.UserInfo;
import com.example.userservice.domain.dto.UserInfoRequest;
import com.example.userservice.domain.dto.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserInfoMapper {

    UserInfo mapToUserInfoFromRequest(UserInfo userInfo, UserUpdateRequest request);
}

