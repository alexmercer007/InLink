
package com.red.InLink.JpaRepository;

import com.red.InLink.Model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AlejandroRC
 */


public interface UserRepository extends JpaRepository< User, Long > {
    
  Optional<User> findByUserName( String userName); 
  Optional<User> findByLastName(String lastName);
  Optional<User> findByEmail( String email );
  
    
    
}
