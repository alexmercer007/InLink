
package com.red.InLink.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author AlejandroRC
 */

@Table( name ="users")
@Entity
public class User {
      
    public User(){
        
    }
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id; 

   @Column(name = "username")
   private String userName;
   
   @Column(name = "lastname")
   private String lastName;
   
   @Column(name = "Birthdate")
   private LocalDate birthdate;
   
   @Column(name = "phone_number")
   private String phoneNumber;
   
   @Column( name = "email", unique = true)
   private String email;

   @Column( name = "passwordhash", length = 1000 )
   private String passwordhash;
   
   @ManyToOne(optional = false) // cada usuario debe tener un país
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
   
   @Column(name = "biography", columnDefinition = "TEXT")
   private String biography;
   
   @Column(name = "user_role")
   private String userRole;
   
   @Column(name = "created_user")
   private LocalDateTime createdUser;
   
   @Column(name = "updated_user")
   private LocalDateTime updatedUser;
   
   @OneToMany(mappedBy = "sender")
   private List<Message> sentMessages;

   @OneToMany(mappedBy = "receiver")
   private List<Message> receivedMessages;

   
   
//--------------------------------------------------------------------------------- Setters ------------------------------------------------------------------------------------------------//   
   
   
public void setUserName(String userName){
    
   this.userName = userName; 
    
}   
   
public void setLastName( String lastName ){
    
    this.lastName = lastName;
    
}   
   
public void setBirthdate( LocalDate birthdate ){
    
   this.birthdate = birthdate; 
    
}   
   
public void setPhoneNumber( String phoneNumber ){
    
  this.phoneNumber = phoneNumber;  
    
}   
   
public void setEmail( String email ){
    
   this.email = email; 
    
}   
   
public void setPasswordRaw( String passwordRaw){
    
    this.passwordhash = BCrypt.hashpw(passwordRaw, BCrypt.gensalt());
    
}   
   
public void setCountry(Country country){
    
    this.country =  country;
        
}   
   
public void setBiography( String biography ) {
    
   this.biography = biography;    
    
} 
   
public void setUserRole( String userRole ){
    
    this.userRole = userRole;
    
}   
   
public void setCreatedUser(LocalDateTime createdUser) {
    
    this.createdUser = createdUser;
    
}  
   
public void setUpdatedUser( LocalDateTime updatedUser ){
    
   this.updatedUser = updatedUser; 
    
} 


//--------------------------------------------------------------------------------- Getters ------------------------------------------------------------------------------------------------// 


public String getUserName(){
    
   return this.userName; 
    
}   
   
public String getLastName( ){
    
    return this.lastName;
    
}   
   
public LocalDate getBirthdate( ){
    
   return this.birthdate; 
    
}   
   
public String getPhoneNumber( ){
    
  return this.phoneNumber;  
    
}   
   
public String getEmail( ){
    
   return this.email; 
    
}   
   
public String getPasswordRaw( ){
    
    return this.passwordhash;
    
}   
   
public Country getCountry(){
    
    return this.country;
        
}   
   
public String getBiography( ) {
    
   return this.biography;    
    
} 
   
public String getUserRole( ){
    
    return this.userRole;
    
}   
   
public LocalDateTime getCreatedUser( ) {
    
    return this.createdUser;
    
}  
   
public LocalDateTime getUpdatedUser( ){
    
   return this.updatedUser; 
    
} 








   
    
    
}
