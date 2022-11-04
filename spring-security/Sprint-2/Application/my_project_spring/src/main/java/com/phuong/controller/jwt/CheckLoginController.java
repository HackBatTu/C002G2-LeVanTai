package com.phuong.controller.jwt;

import com.phuong.service.CookieService;
import com.phuong.service.jwt.JwtUserDetailsService;
import com.phuong.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CheckLoginController {

    @Autowired
    private CookieService cookieService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @RequestMapping(value = "/check/login", method = RequestMethod.POST)
    public ResponseEntity<Boolean> TestRequest(HttpServletRequest request) {
        final String requestTokenHeader = this.cookieService.cookie(request).get("Authorization");
        if (requestTokenHeader == null) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
