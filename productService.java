package com.example.project2;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class productService {

    ArrayList<product> product=new ArrayList<>();

    public ArrayList<product> getProduct(){

        return product;
    }

    public void addproduct(product products ){

        product.add(products);


    }

    public void  deletproduct(int index){
        product.remove(index);
    }

    public void updateproduct(int index,product products){

        product.set(index,products);

    }



}
