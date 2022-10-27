package loginsocialapi.security;

import loginsocialapi.entity.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipalFactory {

    public static UsuarioPrincipal build(AppUser appUser){
        List<GrantedAuthority> authorities =
                appUser.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(appUser.getEmail(), appUser.getPassword(), authorities);
    }
}
