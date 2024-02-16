package com.shopping.database.api.Database.API.Controller;

import com.shopping.database.api.Database.API.Dto.ProductReqBody;
import com.shopping.database.api.Database.API.Models.PortalUser;
import com.shopping.database.api.Database.API.Models.Product;
import com.shopping.database.api.Database.API.Repository.PortalUserRepo;
import com.shopping.database.api.Database.API.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/db/product")
public class ProductController {
    @Autowired
    PortalUserRepo portalUserRepo;
    @Autowired
    ProductRepo productRepo;
    @PostMapping("/add")
    public Product addProduct(@RequestBody ProductReqBody product){
        Product p=new Product();
        UUID id=UUID.randomUUID();
        p.setId(id);
        p.setProductName(product.getProductName());
        p.setProductType(product.getProductType());
       p.setQuantity(product.getQuantity());
       p.setPrice(product.getPrice());
       p.setRating(0);
        PortalUser seller=portalUserRepo.findById(product.getSellerId()).orElse(null);
      p.setSeller(seller);
      productRepo.save(p);
        return p;

    }

}
