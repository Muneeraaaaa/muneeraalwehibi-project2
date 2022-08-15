package com.example.project2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class category {
@NonNull
@Size(min = 3,max = 3,message = "the id have to be 3 charcter long ")
    private String id;
@NonNull
@Size(min = 3,max = 3,message = "the name have to be 3 charcter long ")
    private String name;

}
