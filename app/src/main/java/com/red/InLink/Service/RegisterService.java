

package com.red.InLink.Service;

import com.red.InLink.DTO.RegisterDTO;
import com.red.InLink.JpaRepository.UserRepository;
import com.red.InLink.Model.User;
import static com.red.InLink.Utils.RoleConstants.USER;
import org.springframework.stereotype.Service;

/**
 *
 * @author AlejandroRC
 */

@Service
public class RegisterService {
    
    private final UserRepository userRepository;
    
    public RegisterService( UserRepository userRepository ){
        
       this.userRepository = userRepository; 
        
    }
    
    public User userRegistration( RegisterDTO dto  ){
        
        User user = new User();     
        
     if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
        throw new RuntimeException("Email already registered");
    }
         
       user.setUserName(dto.getUserName());
       user.setLastName(dto.getLastName());
       user.setEmail(dto.getEmail());
       user.setPasswordRaw(dto.getPassword());
       user.setBirthdate(dto.getBirthDate());
       user.setPhoneNumber(dto.getPhoneNumber());
       user.setCountry(dto.getCountry());
       user.setBiography(dto.getBiography());
       user.setCreatedUser(dto.getCreatedUser());
       user.setUserRole(USER);
     
     return userRepository.save(user);
            
    }
    
}
