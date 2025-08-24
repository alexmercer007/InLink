

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


@Table(name = "message")
public class Message {
    
    public Message(){
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    // Clave foránea hacia users(id)
    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;

    // Clave foránea hacia users(id)
    @ManyToOne(optional = false)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private User receiver;
    
    @Column( name = "content", columnDefinition = "TEXT")
    private String content;
    
    @Column( name = "image_url", length = 500)
    private String imageUrl;
    
    @Column( name = "video_url", length = 500)
    private String videoUrl;
    
    @Column( name = "send_date")
    private LocalDateTime sendDate;
    
    @Column( name = "hide_for_sender")
    private boolean hideForSender;
    
    @Column( name = "hide_for_receiver")
    private boolean hideForReceiver;
    
    
    //-------------------------------------------------------------------------------- Setters ------------------------------------------------------------------------------------------// 
    
    
    public void setContent( String content ){
        
      this.content = content;
        
    }
    
    public void setImageUrl ( String imageUrl ){
        
      this.imageUrl = imageUrl;
        
    }
    
    public void setVideoUrl( String videoUrl ){
        
        this.videoUrl = videoUrl;
        
    }
    
    public void setSendDate ( LocalDateTime sendDate ){
        
        this.sendDate = sendDate;
        
    }
    
    public void setHideForSender( boolean hideForSender ){
        
        this.hideForSender = hideForSender;
        
    }
    
      public void setHideForReceiver( boolean hideForReceiver ){
        
        this.hideForReceiver = hideForReceiver;
        
    }
    
    
//---------------------------------------------------------------------------- Getters ------------------------------------------------------------------------------------------------------//    
    
 
public Long getId(){
    
    return this.Id;
    
}      
      
public User getSenderId( ){
       
        return this.sender;
        
    }
    
public User getReceiverId( ){
        
       return this.receiver; 
        
    }
    
public String getContent( ){
        
      return this.content;
        
    }
    
public String getImageUrl ( ){
        
      return this.imageUrl;
        
    }
    
public String setVideoUrl( ){
        
       return this.videoUrl;
        
    }
    
public LocalDateTime getSendDate ( ){
        
        return this.sendDate;
        
    }
    
public boolean getHideForSender( ){
        
        return this.hideForSender;
        
    }
    
public boolean getHideForReceiver( ){
        
        return this.hideForReceiver;
        
    }      
    
    
    
}
