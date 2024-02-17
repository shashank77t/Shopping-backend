package com.shopping.database.api.Database.API.Models;

import jakarta.persistence.*;
import lombok.*;

//one user can order many products
//order many orders belong to one user

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class OrderDetails {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    UUID id;
    int quantity;
    double totalPrice;
    boolean isDelivered;
    @ManyToOne
    PortalUser user;


}
