package com.cniback.cniback.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
 
import javax.validation.Valid;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.cniback.cniback.configuration.JwtProvider;
import com.cniback.cniback.dao.RoleRepository;
import com.cniback.cniback.dao.UserRepository;
import com.cniback.cniback.message.JwtResponse;
import com.cniback.cniback.message.LoginForm;
import com.cniback.cniback.message.SignUpForm;
import com.cniback.cniback.modele.Role;
import com.cniback.cniback.modele.RoleName;
import com.cniback.cniback.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository UserRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()

                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);

        Optional<User> user = UserRepository.findByUsername(loginRequest.getUsername());
        User userdetails = user.get();

        if(!userdetails.getEtat()){
            return ResponseEntity.ok("Not activated");
        }

        return ResponseEntity.ok(new JwtResponse(jwt));
    }
 
    @PostMapping(value = "/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
       if(UserRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
        if(UserRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
          switch(role) {
          case "ADMIN":
            Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
            roles.add(adminRole);
            break;
          case "superviseur":
              Role pmRole = roleRepository.findByName(RoleName.ROLE_superviseur)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
              roles.add(pmRole);
            break;
          default:
              Role userRole = roleRepository.findByName(RoleName.ROLE_user)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
              roles.add(userRole);              
          }
        });
        user.setRoles(roles);
        UserRepository.save(user);

        return ResponseEntity.ok("User Registred !");
    }
}
