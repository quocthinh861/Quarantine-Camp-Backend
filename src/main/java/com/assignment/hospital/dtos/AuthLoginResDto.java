package com.assignment.hospital.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AuthLoginResDto {
    public String token;
    public Object user;
}
