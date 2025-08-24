

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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 *
 * @author AlejandroRC
 */

@Entity
@Table(name = "reactions",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "publication_id"})})
public class Reaction {
    
    public Reaction(){
        
        
    }
   
public enum ReactionType {
    
    LIKE,
    DISLIKE
    
}    
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;    

@NotNull
@ManyToOne( optional = false )
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

@NotNull
@ManyToOne( optional = false )
@JoinColumn(name = "publication_id", referencedColumnName = "id")
private Publication publication;

@NotNull
@Enumerated(EnumType.STRING) // Guarda "LIKE" o "DISLIKE"
@Column(name = "reaction_type", nullable = false)
private ReactionType reactionType;
  
@Column(name = "reacted_at")
private LocalDateTime reactedAt;   
    

//-------------------------------------------------------------------------- Setters ------------------------------------------------------------------------------------------------------//


public void setUser(User user){
    
    this.user = user;
    
}

public void setPublication( Publication publication ){
    
   this.publication = publication; 
    
}

public void setReactionType(ReactionType type) {
        
    this.reactionType = type;
    
    }

public void setReactedAt( LocalDateTime reactedAt ){
    
    this.reactedAt = reactedAt;
    
}

 
//-------------------------------------------------------------------------- Getters ------------------------------------------------------------------------------------------------------//


public User getUser(){
    
    return this.user;
    
}

public Publication getPublication(){
    
    return this.publication;
    
}

public ReactionType getReactionType() {
    
        return this.reactionType;
        
    }

public LocalDateTime getReactedAt( ){
    
    return this.reactedAt;
    
}


}
