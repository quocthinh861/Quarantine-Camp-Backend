package com.assignment.hospital.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class AuthCreateReqDto {
    public String username;
    public String password;
    public String fullName;
    public String gender;
    @JsonFormat(pattern = "dd/MM/yyyy")
    public String birthday;
    public String phoneNumber;
    public String address;
    public List<Long> role = List.of(1L);
}
