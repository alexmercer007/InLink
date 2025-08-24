
package com.red.InLink.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author AlejandroRC
 */

@Table(name = "countries")
@Entity
public class Country {
    
    public Country(){
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    
 //--------------------------------------------------------------------------------- Getters ------------------------------------------------------------------------------------------------//
    
    
    public Long getId(){
        
        return this.id;
        
    }
    
    public String getName(){
        
        return this.name;
        
    }
    
 
//--------------------------------------------------------------------------------- Setters ------------------------------------------------------------------------------------------------//    
   
 
public void setName( String name){
        
       this.name = name;
        
    }
    
}
