package com.banking.controller;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dao.UserDao;
import com.banking.model.User;
import com.banking.model.UserJsonResponse;

@Controller
@RequestMapping("/cbbank")
public class BankController {

	
	//private final UserDao userdao =new UserDao();
   @GetMapping("/")
   public String indexForm() {
      return "index";
   }

   @GetMapping("/register")
   public String registerForm() {
      return "registerForm";
   }

   @PostMapping(value = "/saveUser", produces = { MediaType.APPLICATION_JSON_VALUE })
   @ResponseBody
   public UserJsonResponse saveUser(@ModelAttribute  User user,
         BindingResult result) {
      UserJsonResponse response = new UserJsonResponse();
      
      if(result.hasErrors()){
         
         //Get error message
         Map<String, String> errors = result.getFieldErrors().stream()
               .collect(
                     Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                 );
         
         response.setValidated(false);
         response.setErrorMessages(errors);
      }else{
         // Implement business logic to save employee into database
         //..
         response.setValidated(true);
         response.setUser(user);
      //   userdao.saveUser(user);
         
         
      }
      return response;
   }
}
