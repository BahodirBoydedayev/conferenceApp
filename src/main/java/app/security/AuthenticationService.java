package app.security;

import app.core.ROLE;
import app.organization.Organization;
import app.organization.OrganizationDao;
import app.users.User;
import app.users.UserItem;
import app.users.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationService {

    private UserRepository userRepository;
    private OrganizationDao organizationDao;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object authenticated(CustomUserDetails userDetails) {
        Map<String, Object> response = new HashMap<>();
        response.put("login", userDetails.getUsername());
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserItem userItem) {
        ROLE role = ROLE.USER;
        Set<ROLE> roles = new HashSet<>();
        if (userItem.getRole() != null) {
            if (userItem.getRole().contains("MASTER")) {
                role = ROLE.MASTER;
            } else if (userItem.getRole().contains("MANAGER")) {
                role = ROLE.MANAGER;
            } else if (userItem.getRole().contains("USER")) {
                role = ROLE.USER;
            }
            roles.add(role);
        }
        Organization organization = organizationDao.findOne(userItem.getOrganization());
        User user = new User(userItem.getLogin(), userItem.getPassword(), userItem.getFullName(), new Date(), true, organization, null, null, roles);
        userRepository.save(user);
    }
}
