package com.phuong.controller.jwt;

import com.phuong.model.jwt.JwtRequest;
import com.phuong.model.jwt.JwtResponse;
import com.phuong.service.jwt.JwtUserDetailsService;
import com.phuong.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest,
                                                       HttpServletResponse response) throws Exception {
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        // Authentication
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // Get roles list
        List<String> grantList = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        // Create token
        final String token = jwtTokenUtil.generateToken(userDetails);

        createAuthorizationCookie(response, token);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void createAuthorizationCookie(HttpServletResponse response, String token) {
        Cookie refreshTokenCookie = new Cookie("Authorization", token);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setSecure(false); //only allows HTTPS
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge(3600);
//        refreshTokenCookie.setDomain("google.com"); //restrict domain
        response.addCookie(refreshTokenCookie);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
