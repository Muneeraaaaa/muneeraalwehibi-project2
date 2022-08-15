package com.example.project2;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class merchanservice {

    public ArrayList<merchan> merchans=new ArrayList<>();


    public ArrayList<merchan> getmerchan(){

        return merchans;
    }

    public void addmerchan(merchan merchan){

        merchans.add(merchan);

    }
//
    public void  deletemerchan(int index){

        merchans.remove(index);
    }

    public void updatemerchan(int index,merchan merchan){

        merchans.set(index,merchan);

    }




}
