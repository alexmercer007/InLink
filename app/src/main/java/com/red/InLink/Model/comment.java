
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
@Table(name = "comments")
public class comment {
    
    public comment(){
             
    }
    
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
private Long Id;
 
@ManyToOne(optional = false)
@JoinColumn( name = "user_id", referencedColumnName = "id")
private User user;    

@ManyToOne(optional = false)
@JoinColumn( name = "publication_id", referencedColumnName = "id")
private Publication publication;   
    
@Column( name = "content", columnDefinition = "TEXT")    
private String content;

@Column( name = "image_url", length = 500 )    
private String imageUrl;

@Column( name = "video_url", length = 500)    
private String videoUrl;

@Column( name = "gif_url", length = 500)    
private String gifUrl;

@Column( name = "created_at")    
private LocalDateTime createdAt;

@Column( name = "update_at")    
private LocalDateTime updateAt;

@Column( name = "is_hidden")    
private boolean isHidden = false;

    
//--------------------------------------------------------------------------------- Getters ------------------------------------------------------------------------------------------------//    
    
    
public Long getId(){
     
     return this.Id;
     
 }   
    
public User getUser(){
     
     return this.user;
     
 }   
    
public Publication getPublicationId(){
    
    return this.publication;
    
}    

public String getContent(){
    
    return this.content;
    
}  
    
public String getImageUrl(){
    
    return this.imageUrl;
    
}      
    
public String getVideoUrl(){
    
    return this.videoUrl;
    
}  

public String getGifUrl(){
    
    return this.gifUrl;
    
}  

public LocalDateTime getCreatedAt(){
    
    if( this.createdAt == null ){
        
        return null;
        
    } else {
        
     return this.createdAt;   
     
    }
       
}  

public LocalDateTime getUpdateAt(){
    
    if( this.updateAt == null ){
        
     return null;   
        
    } else {
    
    return this.updateAt;
    
    }
    
}  

public boolean getIsHidden(){
    
    return this.isHidden;
    
}  
        
    
//--------------------------------------------------------------------------------- Setters ------------------------------------------------------------------------------------------------//    
    
    
public void setUser( User user){
     
      this.user = user;
     
 }   
    
public void setPublicationId( Publication publication){
    
     this.publication = publication;
    
}    

public void setContent( String content){
    
     this.content = content;
    
}  
    
public void setImageUrl( String imageUrl){
    
     this.imageUrl = imageUrl;
    
}      
    
public void setVideoUrl( String videoUrl){
    
     this.videoUrl = videoUrl;
    
}  

public void setGifUrl( String gifUrl){
    
     this.gifUrl = gifUrl;
    
}  

public void setCreatedAt( LocalDateTime createdAt ){
    
     this.createdAt = createdAt;
    
}  

public void setUpdateAt( LocalDateTime updateAt){
    
     this.updateAt = updateAt;
    
}  

public void setIsHidden( boolean isHidden){
    
     this.isHidden = isHidden;
    
}     
    
    
    
    
    
}
