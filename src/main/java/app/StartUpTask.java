package app;


import app.core.ROLE;
import app.organization.Organization;
import app.organization.OrganizationDao;
import app.users.User;
import app.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class StartUpTask {


    private static final String USER_USERNAME = "User";
    private static final String USER_LOGIN = "user";
    private static final String USER_PASSWORD = "10";
    private static final String ORGANIZATION_NAME = "UCELL";

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

    @PostConstruct
    public void init() {
        initUsers();
    }

    public void initUsers() {
        if (userRepository.count() == 0) {
            Organization organization = new Organization();
            organization.setName(ORGANIZATION_NAME);

            User user = new User();
            user.setFullName(USER_USERNAME);
            user.setLogin(USER_LOGIN);
            user.setPassword(USER_PASSWORD);
            user.setRegDate(new Date());

            Set<ROLE> userRoles = new HashSet<>();
            userRoles.add(ROLE.USER);
            user.setRoles(userRoles);

            organizationDao.save(organization);
            userRepository.save(user);
        }
    }
}
