package app.users;


import app.core.BaseRepository;

public interface UserRepository extends BaseRepository<User>{
    User findByLogin(String name);
}
