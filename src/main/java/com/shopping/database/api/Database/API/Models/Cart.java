package com.shopping.database.api.Database.API.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cart {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    int quantity;
    int totalPrice;
    @OneToOne
    PortalUser user;


}
