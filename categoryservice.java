package com.example.project2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class categoryservice {

    public ArrayList<category> categories=new ArrayList<>();

//
 public ArrayList<category> getcategory(){

        return categories;
 }
//
    public void addcategory(category category){

        categories.add(category);

    }
//
    public void  deletcategory(int index){

 categories.remove(index);
 }

    public void updatecategory(int index,category category){

     categories.set(index,category);
    }


}
