package com.example.project2;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class product{

@NotEmpty(message = "the id should not be empty ")
@Size(min=3,max = 3,message = "the id should be 3 numbers long ")
    private String id ;
@NotEmpty
@Size(min = 3,max = 3,message = "the name have to be 3 length long")
    private String name;
@NotNull
@Range(min = 1,message = "the price must be positive number ")
    private Integer price;
@NotEmpty
@Size(min = 3,max = 3,message = "category id must be 3 character log ")
    private String categoryid;

}
