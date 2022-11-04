package com.phuong.controller.jwt;

import com.phuong.model.jwt.JwtResponse;
import com.phuong.service.CookieService;
import com.phuong.service.jwt.JwtUserDetailsService;
import com.phuong.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class RoleRestController {

    @Autowired
    private CookieService cookieService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;



    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/get/role", method = RequestMethod.POST)
    public ResponseEntity<?> TestRequest(HttpServletRequest request) {
        final String requestTokenHeader = this.cookieService.cookie(request).get("Authorization");
        String username = null;
        String jwtToken = null;
        if (requestTokenHeader == null) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        jwtToken = requestTokenHeader.substring(7);

        username = this.jwtTokenUtil.getUsernameFromToken(jwtToken);

        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(username);

        List<String> grantList = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(grantList, userDetails.getUsername()));
    }
}
