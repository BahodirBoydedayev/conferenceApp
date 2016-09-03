package app.users;

import app.core.BaseDao;

public interface UserDao extends BaseDao<User, Long> {
    Iterable<User> findAll(Long size, Long page, String text);
    User findByLogin(String login);
    Long count(String text);
}
