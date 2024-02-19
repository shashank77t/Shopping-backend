package com.shoppingbackend.user.UerAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SellerProductRegistrationDTO {


        String productName;
        int price;
        int quantity;
        UUID sellerId;
        String productType;


}


