package Services;

import models.User;
import repositories.UserRepository;

public class AuthService {
    private UserRepository userRepository;
    private User currentUser;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean register(String fullName, String email, String address, String password) {
        if (password.length() < 6) {
            System.out.println("Mot de passe trop court (min 6 caractères).");
            return false;
        }
        if (userRepository.existsByEmail(email)) {
            System.out.println("Un compte existe déjà avec cet email.");
            return false;
        }

        User user = new User(fullName, email, address, password);
        userRepository.save(user);
        System.out.println("Inscription réussie !");
        return true;
    }


    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("Email ou mot de passe incorrect.");
            return false;
        }
        currentUser = user;
        System.out.println("Bienvenue " + user.getFullName() + " !");
        return true;
    }


    public void logout() {
        currentUser = null;
        System.out.println("Déconnecté.");
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isAuthenticated() {
        return currentUser != null;
    }

    public boolean updateProfile(String fullName, String address, String password) {
        if (currentUser == null) return false;

        currentUser.setFullName(fullName);
        currentUser.setAddress(address);
        currentUser.setPassword(password);

        userRepository.update(currentUser);
        return true;
    }
}
