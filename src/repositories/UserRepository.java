package repositories;

import models.User;

public interface UserRepository {
    boolean existsByEmail(String email);
    void save(User user);
    User findByEmail(String email);
    void update(User user);
}

