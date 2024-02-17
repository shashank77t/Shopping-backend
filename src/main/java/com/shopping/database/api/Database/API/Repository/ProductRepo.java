package com.shopping.database.api.Database.API.Repository;

import com.shopping.database.api.Database.API.Models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepo extends MongoRepository<Product, UUID> {
}
