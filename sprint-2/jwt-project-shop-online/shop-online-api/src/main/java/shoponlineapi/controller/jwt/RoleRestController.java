package shoponlineapi.controller.jwt;

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
import shoponlineapi.enlity.jwt.JwtResponse;
import shoponlineapi.jwt.service.CookieService;
import shoponlineapi.jwt.service.JwtUserDetailsService;
import shoponlineapi.jwt.util.JwtTokenUtil;

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
    public ResponseEntity<?> TestRequestRole(HttpServletRequest request) {
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

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/role/admin", method = RequestMethod.POST)
    public ResponseEntity<Boolean> TestRequestAdmin(HttpServletRequest request) {
        final String requestTokenHeader = this.cookieService.cookie(request).get("Authorization").substring(7);

        UserDetails userDetails = this.jwtUserDetailsService
                .loadUserByUsername(this.jwtTokenUtil.getUsernameFromToken(requestTokenHeader));

        List<String> grantList = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        for (String grant: grantList) {
            if (grant.equals("ROLE_ADMIN")) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
