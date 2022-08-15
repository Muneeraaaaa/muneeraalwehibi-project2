package com.example.project2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class user {
    @NonNull
    @Size(min = 3,message = "the id have to be 3 charcter long ")
    private String id;
    @NonNull
    @Size(min = 5,message = "the username have to be 5 charcter long ")
    private String username;
    @NotEmpty
    @Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.*[A-Z]).{6,}$",message = "Password must have at least 8 characters with at least one Capital letter, at least one lower case letter and at least one number or special character.")
    private String password;
    @NotEmpty
    @Email(message = "this is invalid email")
    private String email;
    @NotEmpty
    @Pattern(regexp = "(Admin|Customer)")
    //either admin or customer
    private String role;
    @NotEmpty
    @Size(min = 1,message = "your balance must be positive ")
    private Integer balance;


}
