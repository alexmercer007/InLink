
package com.red.InLink.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "publication")
public class Publication {
    
    public Publication(){
        
        
    }

@Id    
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private Long Id;    

@NotNull
@ManyToOne( optional = false )
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User userId;    
 
@Column(name = "content", columnDefinition = "TEXT")
private String content;    
    
@Column(name = "image_url", length = 500)
private String imageUrl;    
    
@Column(name = "video_url", length = 500)
private String videoUrl;     

@NotNull
@Column(name = "created", nullable = false)
private LocalDateTime created;

@Column(name = "update_at")
private LocalDateTime update;

@Column(name = "is_hide")
private boolean isHide = false;


//------------------------------------------------------------------------------------------ Setters ----------------------------------------------------------------------------------------------//


public void setContent( String content ){
    
    this.content = content;
    
}
 
public void setImageUrl( String imageUrl ){
    
    this.imageUrl = imageUrl;
    
}

public void setVideoUrl( String videoUrl ){
    
    this.videoUrl = videoUrl;
    
}

public void setCreated( LocalDateTime created ){
    
    this.created = created;
    
}
 
public void setUpdate( LocalDateTime update ){
    
    this.update= update;
    
}

public void setIsHide( boolean isHide ){
    
    this.isHide = isHide;
    
}


//------------------------------------------------------------------------------------------ Getters -----------------------------------------------------------------------------------------------//
 

public Long getId(){
    
    return this.Id;
    
}

public String getContent( ){
    
    return this.content;
    
}
 
public String getImageUrl( ){
    
    return this.imageUrl;
    
}

public String getVideoUrl( ){
    
    return this.videoUrl;
    
}

public LocalDateTime setCreated( ){
    
    return this.created;
    
}
 
public LocalDateTime setUpdate( ){
    
    return this.update;
    
}

public boolean setIsHide( ){
    
    return this.isHide;
    
}


}
