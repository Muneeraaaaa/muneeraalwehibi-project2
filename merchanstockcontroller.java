package com.example.project2;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchanstock")

public class merchanstockcontroller {

    private final merchanstuckservice merchanstuckservice;

    @GetMapping()
    public ResponseEntity getmerchanstuck(Errors errors) {

        return ResponseEntity.status(200).body(merchanstuckservice.getmerchanstock());
    }


    @PostMapping()
    public ResponseEntity addmerchanstuck(@RequestBody @Valid Merchantstock merchantstock, Errors errors){
        if(errors.hasErrors()){

            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }

        merchanstuckservice.addmerchanstuck(merchantstock);
        return ResponseEntity.status(201).body(new api("new merchanstuckse is added ",201));

    }
    @DeleteMapping("/{index}")
    public ResponseEntity deletemerchanstuck(@PathVariable @Valid int index,Errors errors){
        if(errors.hasErrors()){

            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }

        merchanstuckservice.deletmerchanstock(index);
        return ResponseEntity.status(201).body(new api("merchanstuc is deleted ",201));



    }

    @PostMapping("/{index}")
    public ResponseEntity updateuser(@RequestBody @Valid Merchantstock merchantstock,@PathVariable int index,Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }
        merchanstuckservice.updatemerchanstuck(index,merchantstock);
        return ResponseEntity.status(201).body(new api("merchanstuckservice is deleted ",201));

    }

    @PostMapping()
    public ResponseEntity addproducttomerchanstock(@RequestBody @Valid Integer productid,@RequestBody @Valid Integer merchanid,@RequestBody @Valid Integer stock,Errors errors ){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }

        if (merchanstuckservice.addproducttomerchan(productid,merchanid,stock)){

            return ResponseEntity.status(200).body(new api("the product is added ",200));
        }

        return ResponseEntity.status(400).body(new api("you can not add",400));

    }



}
