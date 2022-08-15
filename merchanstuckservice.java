package com.example.project2;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class merchanstuckservice {
    ArrayList<Merchantstock> merchantstocks=new ArrayList<>();



    public ArrayList<Merchantstock> getmerchanstock(){

        return merchantstocks;
    }

    public void addmerchanstuck(Merchantstock merchantstock){

        merchantstocks.add(merchantstock);
    }

    public void  deletmerchanstock(int index){

        merchantstocks.remove(index);
    }

    public void updatemerchanstuck(int index,Merchantstock merchantstock){

        merchantstocks.set(index,merchantstock);
    }

//
//
//create endpoint where user can add product to a merchantStock
//this endpoint should accept a productid and merchantid and stock
public boolean addproducttomerchan(Integer productid,Integer merchanid,Integer stock){

    for (int i = 0; i < merchantstocks.size(); i++) {

        if (merchantstocks.get(i).getProductid().equals(productid) && merchantstocks.get(i).getMerchanitd().equals(merchanid)) {


            merchantstocks.get(i).setStock(merchantstocks.get(i).getStock() + stock);

            System.out.println("the product is added to merchan stock ");
            return true;
        }
    }
        return false;



}

//    public boolean buyproduct(Integer productid,Integer userid,Integer merchanid){
//
//        ArrayList<merchanstuckservice> merchanstuckservices=new ArrayList<>();
//        for (int i = 0; i < userlist.size(); i++) {
//
//
//            if (userlist.get(i).ge)
//
//        }
//
//    }


}
