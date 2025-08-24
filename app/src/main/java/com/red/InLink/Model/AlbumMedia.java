

package com.red.InLink.Model;

import com.red.InLink.Service.FileStorageService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author AlejandroRC
 */

@Entity
@Table( name = "album_media")
public class AlbumMedia {
    
    public AlbumMedia(){
          
    }
    
 public enum MediaType {
    
    IMAGE,
    VIDEO  
        
}   
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "album_id", nullable = false, referencedColumnName = "id")
private Album album;
   
@Column(name = "content", columnDefinition = "TEXT")
private String content; 
    
@Column(name = "media_type", nullable = false)
@Enumerated(EnumType.STRING)
private MediaType mediaType;   

@Column( name = "media_url", nullable = false, length = 500)
private String mediaUrl;    

@Column(name = "created_at", updatable = false)
private LocalDateTime createdAt;

@Column( name = "is_hidden")
private boolean isHidden = false;
    
    
//-------------------------------------------------------------------------------------- Getters ------------------------------------------------------------------------------------------------//  
    
   
public Long getId(){
    
    return this.id;
    
}    
    
public Album getAlbum(){
    
    return this.album;
    
}    
    
public String getContent(){
    
    return this.content;
    
}    
    
public MediaType getMediaType(){
    
    return this.mediaType;
    
}   

public String getMediaUrl(){
    
    return this.mediaUrl;
    
}
    
public LocalDateTime getCreatedAt(){
    
    if( this.createdAt == null){

        // mensaje cualquiera

        return null;
        
    } else {
    
    return this.createdAt;
    
    }
    
}    

public boolean getIsHidden(){
    
    return this.isHidden;
    
}
    
    
//-------------------------------------------------------------------------------------- Setters ---------------------------------------------------------------------------------------------------// 


public void setAlbum( Album album ){
    
    this.album = album;
    
}    
    
public void setContent( String content ){
    
    this.content = content;
    
}    
    
public void setMediaType( MediaType mediaType){
    
    this.mediaType = mediaType;
    
}   

public void setMediaUrl( String mediaUrl ){
    
    this.mediaUrl = mediaUrl;
    
}
    
public void setCreatedAt( LocalDateTime createdAt ){
    
    this.createdAt = createdAt;
    
}    

public void setIsHidden( boolean isHidden ){
    
    this.isHidden = isHidden;
    
}


//----------------------------------------------------------------------- Se ejecuta al crear el álbum -------------------------------------------------------------------------------// 


@PrePersist
protected void onCreate() {
    this.createdAt = LocalDateTime.now();
}

       
}
