package com.shoppingbackend.user.UerAPI.Service;

import com.shoppingbackend.user.UerAPI.DTO.GeneralUserDTO.UserDTO;
import com.shoppingbackend.user.UerAPI.DTO.SellerProductRegistrationDTO;
import com.shoppingbackend.user.UerAPI.Exception.UnAuthorized;
import com.shoppingbackend.user.UerAPI.Exception.UserDoesNotExistException;
import org.apache.catalina.User;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.UUID;
@Service
public class SellerService {
    public SellerProductRegistrationDTO register(SellerProductRegistrationDTO sellerProductRegistrationDTO) {
        UUID sellerID = sellerProductRegistrationDTO.getSellerId();
        String url = "http://localhost:3022/db/user/getuser?id="+sellerID.toString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>(headers);
        RestTemplate restTemplate=new RestTemplate();
      ResponseEntity<UserDTO> resp =restTemplate.exchange(url, HttpMethod.GET,entity, UserDTO.class);
        UserDTO reee=resp.getBody();
        System.out.println(reee);
     if(resp.getBody()==null){
         throw new UserDoesNotExistException(String.format("User with id %s does not exist in system",sellerID));

     }
     if(!resp.getBody().getType().equals("SELLER")){
          throw new UnAuthorized(String.format("User with id %s does not have access of this operation",sellerID));
     }
     String url2="http://localhost:3022/db/product/add";
     HttpEntity entity2=new HttpEntity(sellerProductRegistrationDTO,headers);

     ResponseEntity<SellerProductRegistrationDTO>resp2=restTemplate.exchange(url2,HttpMethod.POST,entity2,SellerProductRegistrationDTO.class);
     if(resp2.getBody()==null){
         throw new RuntimeException(String.format("Product addition was not successful"));
     }
     return resp2.getBody();
    }
}