

package com.red.InLink.Controller.PostMapping;

/**
 *
 * @author AlejandroRC
 */
import com.red.InLink.Security.MyUserDetailsService;
import com.red.InLink.Service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController { 

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService; 
    private final MyUserDetailsService userDetailsService;  

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JwtService jwtService,
                                    MyUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login") 
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email(),
                            request.password()
                    )
            );

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String jwt = jwtService.generateToken(userDetails.getUsername());

            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}

record AuthenticationResponse(String token) {}
