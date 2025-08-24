

package com.red.InLink.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 *
 * @author AlejandroRC
 */

@Entity
@Table(name = "friendship")
public class Friendship {
    
    public Friendship(){
        
        
    }
    
    public enum FriendshipLevel {
    
    KNOWN, 
    FRIEND, 
    BEST_FRIEND
    
}
   
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)      
private Long Id;
 
@ManyToOne(optional = false)
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;
        
@ManyToOne(optional = false)
@JoinColumn(name = "target_id", referencedColumnName = "id")
private User target;        
 
@NotNull
@Enumerated(EnumType.STRING) // Guarda "LIKE" o "DISLIKE"
@Column(name = "friendship_level", nullable = false)
private FriendshipLevel friendshipLevel;        
  
@Column(name = "requested_at", nullable = false)
private LocalDateTime requestedAt;        
 
@Column(name = "accepted_at", nullable = false)
private LocalDateTime acceptedAt;       

@ManyToOne(optional = false)
@JoinColumn(name = "blocked_by", referencedColumnName = "id")
private User userBlockedBy;

@Column(name = "blocked_at")
private LocalDateTime userBlockedAt;
        
        
//--------------------------------------------------------------------------------- Getters ------------------------------------------------------------------------------------------------//


public Long getId(){
    
    return this.Id;
    
}

public User getUser(){
    
    return this.user;
    
}

public User getTarget(){
    
    return this.target;
    
}

public FriendshipLevel getFriendshipLevel(){
    
   return this.friendshipLevel; 
    
}

public LocalDateTime getRequestedAt(){
    
    return this.requestedAt;
    
}

public LocalDateTime getAcceptedAt(){
    
    return this.acceptedAt;
    
}

public User getUserBlockedBy(){
    
    return this.userBlockedBy;
    
}

public LocalDateTime getUserBlockedAt(){
    
    return this.userBlockedAt;
    
}


//--------------------------------------------------------------------------------- Setters ------------------------------------------------------------------------------------------------// 
        
    
public void setUser(User user) {
    
    this.user = user;
    
}   
    
public void setTarget(User user) {
    
    this.target = user;
    
}    
    
public void setFriendshipLevel(FriendshipLevel friendshipLevel ) {
    
    this.friendshipLevel = friendshipLevel; 
    
}    
    
public void setRequestedAt( LocalDateTime requestedAt){
    
    this.requestedAt = requestedAt;
    
}
    
public void setAcceptedAt( LocalDateTime acceptedAt){
    
    this.acceptedAt = acceptedAt;
    
}    

public void setUserBlockedBy(User userBlockedBy){
    
    this.userBlockedBy = userBlockedBy;
    
}

public void setUserBlockedAt( LocalDateTime userBlockedAt){
    
    this.userBlockedAt = userBlockedAt;
    
}
    
    
}
