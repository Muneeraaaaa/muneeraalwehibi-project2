package com.example.project2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Merchantstock {
    @NonNull
    @Size(min = 3,max = 3,message = "the id have to be 3 charcter long ")
    private String id;
    @NonNull
    @Size(min = 3,max = 3,message = "the productcid have to be 3 charcter long ")
    private String productid;
    @NonNull
    @Size(min = 3,max = 3,message = "the merchanitd have to be 3 charcter long ")
    private String merchanitd;
    @NonNull
    @Size(min = 10,message = "the stock have to be 3 charcter long ")
    private String stock;

}
