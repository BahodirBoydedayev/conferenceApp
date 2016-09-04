package app.users;

import app.core.BaseJpaDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseJpaDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public Iterable<User> findAll(Long size, Long page, String text) {
        return entityManager.createQuery("select e from User as e where e.fullName like :text order by e.id desc ", User.class).setParameter("text", "%" + text + "%")
                .setFirstResult((page.intValue() - 1) * size.intValue()).setMaxResults(size.intValue()).getResultList();

    }

    @Override
    public User findByLogin(String login) {
        return entityManager.createQuery("select u from User as u where u.login = :login", User.class).setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public Long count(String text) {
        return entityManager.createQuery("select count (e.id) from User as e where e.login like :text", Long.class)
                .setParameter("text", "%" + text + "%").getSingleResult();
    }
}
