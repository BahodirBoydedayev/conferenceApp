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

    private static final String MASTER_USER_USERNAME = "Master";
    private static final String MASTER_LOGIN = "master";
    private static final String MASTER_PASSWORD = "10";
    private static final String MANAGER_USERNAME = "Manager";
    private static final String MANAGER_LOGIN = "manager";
    private static final String MANAGER_PASSWORD = "10";
    private static final String USER_USERNAME = "User";
    private static final String USER_LOGIN = "user";
    private static final String USER_PASSWORD = "10";
    private static final String ORGANIZATION_NAME = "UNICON";

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

            User master = new User();
            User manager = new User();
            User user = new User();
            master.setFullName(MASTER_USER_USERNAME);
            manager.setFullName(MANAGER_USERNAME);
            user.setFullName(USER_USERNAME);
            master.setLogin(MASTER_LOGIN);
            manager.setLogin(MANAGER_LOGIN);
            user.setLogin(USER_LOGIN);
            master.setPassword(MASTER_PASSWORD);
            manager.setPassword(MANAGER_PASSWORD);
            user.setPassword(USER_PASSWORD);
            master.setRegDate(new Date());
            manager.setRegDate(new Date());
            user.setRegDate(new Date());
            master.setOrganization(organization);
            manager.setOrganization(organization);
            user.setOrganization(organization);

            Set<ROLE> masterRoles = new HashSet<>();
            Set<ROLE> managerRoles = new HashSet<>();
            Set<ROLE> userRoles = new HashSet<>();

            masterRoles.add(ROLE.MASTER);
            managerRoles.add(ROLE.MANAGER);
            userRoles.add(ROLE.USER);
            master.setRoles(masterRoles);
            manager.setRoles(managerRoles);
            user.setRoles(userRoles);

            organizationDao.save(organization);
            userRepository.save(master);
            userRepository.save(manager);
            userRepository.save(user);
        }
    }
}
