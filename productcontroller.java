package com.example.project2;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class productcontroller {

    private productService productservice;

    @GetMapping()
    public ResponseEntity getproduct(Errors errors){

        return ResponseEntity.status(200).body(productservice.getProduct());


    }

    @PostMapping()
    public  ResponseEntity addproduct(@RequestBody @Valid product product,Errors errors){
        if(errors.hasErrors())
        {
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));

        }

        productservice.addproduct(product);
        return ResponseEntity.status(201).body(new api("it is succefully added  ",201));


    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteproduct(@PathVariable @Valid int index,Errors errors){
        if(errors.hasErrors()){

            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }

        productservice.deletproduct(index);
        return ResponseEntity.status(201).body(new api("product is deleted ",201));



    }

    @PostMapping("/{index}")
    public ResponseEntity updateuser(@RequestBody @Valid product product, @PathVariable int index, Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }
        productservice.updateproduct(index,product);
        return ResponseEntity.status(201).body(new api("product is deleted",201));

    }







}
