

package com.red.InLink.DTO;

import com.red.InLink.Model.Country;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author AlejandroRC
 */
public class RegisterDTO { 
    
    public RegisterDTO(){
        
        
    }
    
   @NotNull(message = "UserName required")
   private String userName;
   
   @NotNull(message = "LastName required")
   private String lastName;
   
   private LocalDate birthdate;
      
   private String phoneNumber;
   
   @NotNull(message = "email required")
   @Email(message = "The email is not valid")
   @Size(max = 150, message = "Email can't be longer than 150 characters")
   private String email;
   
   @Pattern(
   regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$",
   message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number")
   @Size(min = 8, max = 1000, message = "Password must be between 8 and 1000 characters")
   private String password;
   
   @ManyToOne(optional = false) // cada usuario debe tener un país
   private Country country;
   
   private String biography;
   
   private LocalDateTime createdUser;
   
   private LocalDateTime updatedUser;
   
   
  public RegisterDTO( 
          
          String userName, 
          String lastName,
          LocalDate birthdate, 
          String phoneNumber, 
          String email, 
          String password, 
          Country country, 
          String biography,
          LocalDateTime createdUser,
          LocalDateTime updatedUser ){
       
    this.userName = userName;
   
    this.lastName = lastName;
   
    this.birthdate = birthdate;
      
    this.phoneNumber =  phoneNumber;
   
    this.email = email;
   
    this.password = password;
   
    this.country = country;
   
    this.biography = biography;
   
    this.createdUser = createdUser;
   
    this.updatedUser = updatedUser;
 
      
  } 
  
  
//---------------------------------------------------------------------------------- Getters -----------------------------------------------------------------------------------------------------//  
  
  
public String getUserName(){
    
    return this.userName;
    
}  
  
public String getLastName(){
    
    return this.lastName;
    
} 

public LocalDate getBirthDate(){
    
    if( LocalDate.now() != null ){
        
       throw new IllegalStateException("Date not assigned");
        
    } 
    
    return this.birthdate;
    
}

public String getPhoneNumber(){
    
    return this.phoneNumber;
    
}

public String getEmail(){
    
    return this.email;
    
}

public String getPassword(){
    
    return this.password;
    
}

public Country getCountry(){
    
    if( country.getName() != null ){
        
        throw new IllegalStateException("Country not assigned");
        
    }
    
    return this.country;
    
}

public String getBiography(){
    
    return this.biography;
    
}

public LocalDateTime getCreatedUser(){
    
    if( LocalDateTime.now() != null ){
        
       throw new IllegalStateException("Date not assigned");
        
    } 
    
    return this.createdUser;
    
}

public LocalDateTime getUpdatedUser(){
    
    if( LocalDateTime.now() != null ){
        
       throw new IllegalStateException("Date not assigned");
        
    } 
    
    return this.updatedUser;
    
}
  
  
//---------------------------------------------------------------------------------- Setters -----------------------------------------------------------------------------------------------------//  
  

public void setName( String userName){
    
    this.userName = userName;
    
}  
  
public void setLastName( String lastName){
    
    this.lastName = lastName;
    
} 

public void setBirthDate( LocalDate birthdate){
    
    this.birthdate = birthdate;
    
}

public void setPhoneNumber( String phoneNumber ){
    
    this.phoneNumber = phoneNumber;
    
}

public void setEmail( String email ){
    
    this.email = email;
    
}

public void setPassword( String password ){
    
    this.password = password;
    
}

public void setCountry( String name){
      
    this.country.setName(name);
    
}

public void setBiography( String biography ){
    
    this.biography = biography;
    
}

public void setCreatedUser( LocalDateTime createdUser ){
    
    this.createdUser = createdUser;
    
}

public void getUpdatedUser( LocalDateTime updatedUser ){
    
    this.updatedUser = updatedUser;
    
}
 
   
}
