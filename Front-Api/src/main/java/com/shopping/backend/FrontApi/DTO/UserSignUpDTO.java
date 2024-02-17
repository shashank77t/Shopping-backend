package com.shopping.backend.FrontApi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSignUpDTO {
    String name;
    String email;
    String password;
    long contactNumber;
    String address;
    String type;
}
