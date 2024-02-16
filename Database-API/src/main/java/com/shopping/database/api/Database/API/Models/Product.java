package com.shopping.database.api.Database.API.Models;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

//it is of type nosql database so we use the mongodb database
//in no sql database the place where we store the database is called document
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document
public class Product {
    @Id
    UUID id;
    String productName;
    int price;
    int quantity;

    PortalUser seller;
    double rating;
    String productType;



}
