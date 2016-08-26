package app.users;

import app.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public Object findAll(Long size, Long page, String text) {
        Long count = userDao.count(text);
        Iterable<User> users = userDao.findAll(size, page, text);
        Map<String, Object> map = new HashMap<>();
        map.put("users", users);
        map.put("count", count);
        return map;
    }

    @Transactional
    @Override
    public User save(User entity, CustomUserDetails userDetails) {
        User user = userDao.findByLogin(userDetails.getUsername());
        return userDao.save(user);

    }

    @Transactional(readOnly = true)
    @Override
    public User findByLogin(String login) {
        try {
            return userDao.findByLogin(login);
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public User currentUser(Principal principal) {
        String login = principal.getName();
        return findByLogin(login);
    }

    @Transactional
    @Override
    public User save(User entity) {
        return userDao.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public User findOne(Long id) {
        return userDao.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
