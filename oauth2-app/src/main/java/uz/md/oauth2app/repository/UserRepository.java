package uz.md.oauth2app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.md.oauth2app.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

}