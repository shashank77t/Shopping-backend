package com.shopping.database.api.Database.API.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductReqBody {
    String productName;
    int price;
    int quantity;
    String productType;
    UUID sellerId;
}
