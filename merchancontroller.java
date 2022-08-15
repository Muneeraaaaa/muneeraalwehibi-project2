package com.example.project2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchan")
public class merchancontroller {

    private final merchanservice merchanservice;



    @GetMapping()
    public ResponseEntity getmerchan(Errors errors) {

        return ResponseEntity.status(200).body(merchanservice.getmerchan());
    }


    @PostMapping()
    public ResponseEntity addmerchan(@RequestBody @Valid merchan merchans, Errors errors){
        if(errors.hasErrors()){

            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }
        merchanservice.addmerchan(merchans);
        return ResponseEntity.status(201).body(new api("new merchan is added ",201));

    }
    @DeleteMapping("/{index}")
    public ResponseEntity deletemerchan(@PathVariable @Valid int index,Errors errors){
        if(errors.hasErrors()){

            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }
        merchanservice.deletemerchan(index);
        return ResponseEntity.status(201).body(new api("merchanstuc is deleted ",201));

//
//
    }

    @PostMapping("/{index}")
    public ResponseEntity updateuser(@RequestBody @Valid merchan merchan,@PathVariable int index,Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }
        merchanservice.updatemerchan(index,merchan);
        return ResponseEntity.status(201).body(new api("merchan is deleted ",201));

    }




}
