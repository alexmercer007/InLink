/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.red.InLink.Security;

import com.red.InLink.Model.User;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author AlejandroRC
 */
public class MyUserDetails implements UserDetails {
    
    public MyUserDetails(){
        
        User user = new User();
        
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired(); 
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked(); 
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired(); 
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
    
}
