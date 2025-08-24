

package com.red.InLink.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author AlejandroRC
 */

@Entity
@Table(name="follow")
public class Follow {
    
   public Follow(){
       
       
   } 
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    
   @ManyToOne(optional = false)
   @JoinColumn( name = "follower_id", nullable = false, referencedColumnName = "id")
   private User follower;
   
   @ManyToOne(optional = false)
   @JoinColumn( name = "followed_id", nullable = false,  referencedColumnName = "id")
   private User followed;
   
   @Column(name = "followed_at", nullable = false)
   private LocalDateTime followedAt;
    
   @Column( name = "unfollowed_at" )
   private LocalDateTime unfollowedAt; 
    
    
//------------------------------------------------------------------------------------ Setters ------------------------------------------------------------------------------------------------------//    
    
  
public void setFollower( User follower ){
     
     this.follower = follower;
     
 }   
    
public void setUnFollowedAt( User followed ){
     
     this.followed = followed;
     
 }     
   
public void setFollowedAt( LocalDateTime followedAt ){
     
     this.followedAt = followedAt;
     
 }   
    
public void setUnFollowedAt( LocalDateTime followedAt ){
     
     this.followedAt = followedAt;
     
 }      
    
    
//------------------------------------------------------------------------------------ Getters -----------------------------------------------------------------------------------------------------//     
    

public Long getId(){
    
    return this.id;
    
}

public LocalDateTime getFollowedAt( ){
     
    if(this.followedAt == null){
        
        return null;
        
    } else {
    
     return this.followedAt;
     
    }
     
 }    

public LocalDateTime getUnFollowedAt( ){
     
    if(this.unfollowedAt == null){
        
        return null;
        
    } else {
    
     return this.unfollowedAt;
     
    }
     
 }  
    
    
    
}
