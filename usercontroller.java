package com.example.project2;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class usercontroller {

    private final userService userService;


    @GetMapping("/users")
    public ResponseEntity getusers(Errors errors) {

        return ResponseEntity.status(200).body(userService.getusers());
    }


   @PostMapping("/users")
    public ResponseEntity adduser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){

            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new api(message,400));
        }
        userService.addusers(user);

        return ResponseEntity.status(201).body(new api("new user is added ",201));

   }
@DeleteMapping("/users/{index}")
   public ResponseEntity delete(@PathVariable @Valid int index,Errors errors){
       if(errors.hasErrors()){

           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(new api(message,400));
       }

        userService.deletuser(index);

       return ResponseEntity.status(201).body(new api("it is deleted ",201));



   }

   @PostMapping("/users/{index}")
    public ResponseEntity updateuser(@RequestBody @Valid User user,@PathVariable int index,Errors errors){

       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(new api(message,400));
       }
       userService.updateuser(index,user);
       return ResponseEntity.status(201).body(new api("it is deleted ",201));

   }


}
