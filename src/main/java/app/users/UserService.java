package app.users;


import app.core.BaseService;
import app.security.CustomUserDetails;

import java.security.Principal;

public interface UserService extends BaseService<User,Long> {
    Object findAll(Long size, Long page, String text);
    User findByLogin(String value);
    User save(User user, CustomUserDetails userDetails);
    User currentUser(Principal principal);
}
