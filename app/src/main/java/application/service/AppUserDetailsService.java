package application.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.model.User;
import application.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        throw UsernameNotFoundException {

            User user = userRepo.findAllById(username);
            if (user == null) {
                throw new UsernameNotFoundException("Usuário não encontrado");
            }
            UserDetails userDetails = 
                org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();

            return userDetails;
        }
    }
}
