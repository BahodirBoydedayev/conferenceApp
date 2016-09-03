package app.security;

import app.users.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class UserSecurityService implements UserDetailsService {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUserDetails(entityManager.createQuery(
                "select u from User as u where u.login = :username", User.class)
                .setParameter("username", username)
                .getSingleResult());
    }
}
