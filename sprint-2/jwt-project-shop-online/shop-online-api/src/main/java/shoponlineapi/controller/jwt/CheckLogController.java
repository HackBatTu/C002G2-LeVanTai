package shoponlineapi.controller.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import shoponlineapi.jwt.service.CookieService;
import shoponlineapi.jwt.service.JwtUserDetailsService;
import shoponlineapi.jwt.util.JwtTokenUtil;
import shoponlineapi.jwt.util.LoginUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CheckLogController {

    @Autowired
    private CookieService cookieService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private LoginUtil loginUtil;


    @RequestMapping(value = "/check/login", method = RequestMethod.POST)
    public ResponseEntity<Boolean> TestRequest(HttpServletRequest request) {
        final String requestTokenHeader = this.cookieService.cookie(request).get("Authorization");
        if (requestTokenHeader == null) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/log/out", method = RequestMethod.POST)
    public ResponseEntity<?> onLogout(HttpServletResponse response) {
        Cookie deleteServletCookie = new Cookie("Authorization", null);
        deleteServletCookie.setMaxAge(0);
        deleteServletCookie.setPath("/");
        deleteServletCookie.setHttpOnly(true);
        deleteServletCookie.setSecure(false);
        response.addCookie(deleteServletCookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/logoutSecurity/{token}")
    public ResponseEntity<?> logoutSecurity(@PathVariable String token) {
        if (token.equals("")) {
            return new ResponseEntity<>("isLogout", HttpStatus.UNAUTHORIZED);
        }
        if (this.loginUtil.getTokenMap().isEmpty()) {
            return new ResponseEntity<>("LoginExpired", HttpStatus.UNAUTHORIZED);
        }
        if (this.loginUtil.getTokenMap()
                .get(this.jwtTokenUtil.getUsernameFromToken(token)).equals(token)) {
            this.loginUtil.getTokenMap().remove(this.jwtTokenUtil.getUsernameFromToken(token));
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("Logout Success",HttpStatus.OK);
    }

}
