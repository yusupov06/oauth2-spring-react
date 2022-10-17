package uz.md.oauth2app.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import uz.md.oauth2app.entity.User;
import uz.md.oauth2app.exceptions.ResourceNotFoundException;
import uz.md.oauth2app.payload.UserPrincipal;
import uz.md.oauth2app.repository.UserRepository;

/**
 * Me: muhammadqodir
 * Project: oaut2-spring-react/IntelliJ IDEA
 * Date:Mon 17/10/22 22:18
 */

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + username)
                );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }

}
