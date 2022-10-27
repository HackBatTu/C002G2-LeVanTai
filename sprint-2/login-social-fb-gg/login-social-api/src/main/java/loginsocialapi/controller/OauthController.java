package loginsocialapi.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import loginsocialapi.dto.TokenDto;
import loginsocialapi.entity.Rol;
import loginsocialapi.entity.AppUser;
import loginsocialapi.enums.RolNombre;
import loginsocialapi.security.jwt.JwtProvider;
import loginsocialapi.service.RolService;
import loginsocialapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/oauth")
@CrossOrigin
public class OauthController {

    @Value("${google.clientId}")
    String googleClientId;

    @Value("${secretPsw}")
    String secretPsw;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;



    @PostMapping("/google")
    public ResponseEntity<TokenDto> google(@RequestBody TokenDto tokenDto) throws IOException {
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder verifier =
                new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
        AppUser appUser = new AppUser();
        if(usuarioService.existsEmail(payload.getEmail()))
            appUser = usuarioService.getByEmail(payload.getEmail()).get();
        else
            appUser = saveUsuario(payload.getEmail());
        TokenDto tokenRes = login(appUser);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }

    @PostMapping("/facebook")
    public ResponseEntity<TokenDto> facebook(@RequestBody TokenDto tokenDto) throws IOException {
        Facebook facebook = new FacebookTemplate(tokenDto.getValue());
        final String [] fields = {"email", "picture"};
        User user = facebook.fetchObject("me", User.class, fields);
        AppUser appUser = new AppUser();
        if(usuarioService.existsEmail(user.getEmail()))
            appUser = usuarioService.getByEmail(user.getEmail()).get();
        else
            appUser = saveUsuario(user.getEmail());
        TokenDto tokenRes = login(appUser);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }

    private TokenDto login(AppUser usuario){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getEmail(), secretPsw)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setValue(jwt);
        return tokenDto;
    }

    private AppUser saveUsuario(String email){
        AppUser usuario = new AppUser(email, passwordEncoder.encode(secretPsw));
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolUser);
        usuario.setRoles(roles);
        return usuarioService.save(usuario);
    }

}
