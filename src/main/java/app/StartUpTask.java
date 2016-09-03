package app;


import app.core.ROLE;
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

    private static final String MASTER_USER_USERNAME = "master";
    private static final String MASTER_LOGIN = "master";
    private static final String MASTER_PASSWORD = "10";
    private static final String MANAGER_USERNAME = "manager";
    private static final String MANAGER_LOGIN = "manager";
    private static final String MANAGER_PASSWORD = "10";
    private static final String USER_USERNAME = "user";
    private static final String USER_LOGIN = "user";
    private static final String USER_PASSWORD = "10";

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        initUsers();
    }

    public void initUsers() {
        if (userRepository.count() == 0) {
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

            Set<ROLE> masterRoles = new HashSet<>();
            Set<ROLE> managerRoles = new HashSet<>();
            Set<ROLE> userRoles = new HashSet<>();

            masterRoles.add(ROLE.MASTER);
            managerRoles.add(ROLE.MANAGER);
            userRoles.add(ROLE.USER);
            master.setRoles(masterRoles);
            manager.setRoles(managerRoles);
            user.setRoles(userRoles);

            userRepository.save(master);
            userRepository.save(manager);
            userRepository.save(user);
        }
    }
}
