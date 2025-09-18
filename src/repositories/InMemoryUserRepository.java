package repositories;

import models.User;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public boolean existsByEmail(String email) {
        return users.containsKey(email.toLowerCase());
    }

    @Override
    public void save(User user) {
        users.put(user.getEmail().toLowerCase(), user);
    }

    @Override
    public User findByEmail(String email) {
        return users.get(email.toLowerCase());
    }

    public void update(User user) {
        users.put(user.getEmail().toLowerCase(), user);
    }
}

