package com.example.project2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class categorycontroller {


    public categoryservice categoryservice;

    @GetMapping()
    public ResponseEntity getcategory(Errors errors){

        return ResponseEntity.status(200).body(categoryservice.getcategory());


    }

    @PostMapping()
    public  ResponseEntity addcatgory(@RequestBody @Valid category category, Errors errors){
        if(errors.hasErrors())
        {
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));

        }

        categoryservice.addcategory(category);
//
        return ResponseEntity.status(201).body(new api("the category is succefully added  ",201));


    }
//
    @DeleteMapping("/{index}")
    public ResponseEntity deletcatgory(@PathVariable @Valid int index,Errors errors){
        if(errors.hasErrors()){

            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }

        categoryservice.deletcategory(index);

        return ResponseEntity.status(201).body(new api("catgory is deleted ",201));



    }

    @PostMapping("/{index}")
    public ResponseEntity updatecatgory(@RequestBody @Valid category category, @PathVariable int index, Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }

        categoryservice.updatecategory(index,category);
        return ResponseEntity.status(201).body(new api("catgory is deleted",201));

    }

//




}
