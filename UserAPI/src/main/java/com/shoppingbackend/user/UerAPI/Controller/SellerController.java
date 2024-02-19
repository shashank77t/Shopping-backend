package com.shoppingbackend.user.UerAPI.Controller;

import com.shoppingbackend.user.UerAPI.DTO.GeneralUserDTO.GeneralMessageDTO;
import com.shoppingbackend.user.UerAPI.DTO.SellerProductRegistrationDTO;
import com.shoppingbackend.user.UerAPI.Exception.UnAuthorized;
import com.shoppingbackend.user.UerAPI.Exception.UserDoesNotExistException;
import com.shoppingbackend.user.UerAPI.Service.SellerService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody SellerProductRegistrationDTO sellerProductRegistrationDTO){
           try{
               SellerProductRegistrationDTO resp=sellerService.register(sellerProductRegistrationDTO);
               return new ResponseEntity(resp, HttpStatus.CREATED);
           }catch(UnAuthorized unAuthorized){
               return  new ResponseEntity(new GeneralMessageDTO(unAuthorized.getMessage()),HttpStatus.UNAUTHORIZED);
           }catch (UserDoesNotExistException userDoesNotExistException){
               return new ResponseEntity(new GeneralMessageDTO(userDoesNotExistException.getMessage()),HttpStatus.NOT_FOUND);
           }catch (RuntimeException runtimeException){
               return new ResponseEntity(new GeneralMessageDTO(runtimeException.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
           }

    }
}
