package com.example.project2;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
@Service
//@RequiredArgsConstructor
public class userService {

    public ArrayList<User> userlist=new ArrayList<>();

public ArrayList<User> getusers(){

    return userlist;
}

public void addusers(User user){

    userlist.add(user);
}

public void  deletuser(int index){

    userlist.remove(index);
}

public void updateuser(int index,User user){

    userlist.set(index,user);

}
//    Create endpoint where user can buy a product directly
//this endpoint should accept userid , product id , merchantid.
//            check if all the given id is valid or not
//    check if the merchant have the product in stock or return bad request.
//    reduce the stock from the MerchantStock.
//    deducted the price of the product from the user balance.
//            if balance is less than the product price return bad request.


//  public boolean buyproduct(Integer productid,Integer userid,Integer merchanid){
//
//ArrayList<merchanstuckservice> merchanstuckservices=new ArrayList<>();
//      for (int i = 0; i < userlist.size(); i++) {
//
//
//          if (userlist.get(i).ge)
//
//      }
//
//  }



}
