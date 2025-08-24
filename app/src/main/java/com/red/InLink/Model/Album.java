

package com.red.InLink.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlejandroRC
 */

@Entity
@Table( name = "album")
public class Album {
    
    public Album(){
        
        
    }
    
@Id    
@GeneratedValue(strategy = GenerationType.IDENTITY)  
private Long id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")   
private User user;

@Column(name = "title")
private String title;

@Column( name = "description")
private String description;

@Column( name = "created_at")
private LocalDateTime createdAt;

@Column( name = "updated_at")
private LocalDateTime updatedAt;

@Column( name = "is_hidden")
private boolean isHidden;

@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
private List<AlbumMedia> medias = new ArrayList<>();

    

//-------------------------------------------------------------------------------- Getters -------------------------------------------------------------------------------------//       
    
    
public Long getId(){
    
    return this.id;
    
}    
    
public User getUserId(){
    
    return this.user;
    
}    
    
public String getTitle(){
    
    return this.title;
    
}
    
public String getDescription(){
    
    return this.description;
    
}    
    
public LocalDateTime getCreatedAt(){
    
    return this.createdAt;
    
}    

public LocalDateTime getUpdatedAt() {
    
    if (this.updatedAt == null) {
        
        System.out.println("El usuario nunca ha actualizado el álbum.");
        
        return null;
        
    } else {
        
        return this.updatedAt;
        
    }
     
}


public boolean getIsHidden(){
    
   return this.isHidden;
    
}
    
    
//-------------------------------------------------------------------------------- Setters -------------------------------------------------------------------------------------//  
    
    
public void setUserId( User user){
    
    this.user = user;
    
}    
    
public void setTitle( String title){
    
    this.title = title;
    
}
    
public void setDescription( String description){
    
    this.description = description;
    
}    
    
public void setCreatedAt( LocalDateTime createdAt ){
    
    this.createdAt = createdAt;
    
}    

public void setUpdateAt( LocalDateTime updatedAt){
    
    this.updatedAt = updatedAt;
    
}

public void setIsHidden( boolean isHidden){
    
    this.isHidden = isHidden;
    
}  

public void addMedia(AlbumMedia media) {
    media.setAlbum(this);
    this.medias.add(media);
}



//----------------------------------------------------------------------- Se ejecuta al crear el álbum -------------------------------------------------------------------------------// 


@PrePersist
protected void onCreate() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
}


//----------------------------------------------------------------------- Se ejecuta al actualizar el álbum --------------------------------------------------------------------------//


@PreUpdate
protected void onUpdate() {
    this.updatedAt = LocalDateTime.now();
}

    
}
