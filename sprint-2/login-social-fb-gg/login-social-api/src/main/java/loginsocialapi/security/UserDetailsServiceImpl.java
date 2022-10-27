package loginsocialapi.security;


import loginsocialapi.entity.AppUser;
import loginsocialapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = usuarioService.getByEmail(email).orElseThrow(()-> new UsernameNotFoundException("email no encontrado"));
        return UsuarioPrincipalFactory.build(appUser);
    }
}
