package com.assignment.hospital.dtos;

import com.assignment.hospital.entites.UserEntity;
import com.assignment.hospital.utils.TimeUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class UserCreateResDto {
    public long id;
    public String email;
    public String fullName;
    public String gender;
    @JsonFormat(pattern = "dd/MM/yyyy")
    public String birthday;
    public String phoneNumber;
    public String address;
    public Double height;
    public Double weight;
    public String thumbnail;
    public String username;


    public static UserCreateResDto fromEntity(UserEntity user) {
        UserCreateResDto dto = new UserCreateResDto();
        dto.id = user.getId();
        dto.email = user.getEmail();
        dto.address = user.getAddress();
        dto.birthday = TimeUtil.formatDateToString(user.getBirthday());
        dto.gender = user.getGender();
        dto.fullName = user.getFullName();
        dto.phoneNumber = user.getPhoneNumber();
        dto.height = user.getHeight();
        dto.weight = user.getWeight();
        dto.thumbnail = user.getThumbnail();
        dto.username = user.getUsername();
        return dto;
    }

    public static List<UserCreateResDto> fromEntities(List<UserEntity> entities) {
        if(entities == null) return null;
        return entities.stream().map(UserCreateResDto::fromEntity).toList();
    }
}
