/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.red.InLink.DTO;

import com.red.InLink.Model.Country;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author AlejandroRC
 */
public class LoginDTO {
    
    public LoginDTO(){
    
    
}
   
   @NotNull(message = "email required")
   @Email(message = "The email is not valid")
   @Size(max = 150, message = "Email can't be longer than 150 characters")
   private String email;
   
   @Pattern(
   regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$",
   message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number")
   @Size(min = 8, max = 1000, message = "Password must be between 8 and 1000 characters")
   private String password;
   
public LoginDTO( String email, String password){
       
       this.email = email;
       this.password = password;
       
   } 
  

//---------------------------------------------------------------------------------- Getters -----------------------------------------------------------------------------------------------------//


public String getEmail(){
    
  return this.email;  
    
}   

public String getPassword(){
    
  return this.password;  
    
}  
   

//---------------------------------------------------------------------------------- Setters -----------------------------------------------------------------------------------------------------//
   

public void setEmail( String email){
    
  this.email = email;  
    
}   

public void setPassword( String password ){
    
  this.password = password;  
    
}  
    
}
