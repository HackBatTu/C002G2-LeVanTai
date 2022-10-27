package loginsocialapi.repository;


import loginsocialapi.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByEmail(String email);
    boolean existsByEmail(String email);
}
