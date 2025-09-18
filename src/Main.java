import Services.AuthService;
import repositories.InMemoryUserRepository;
import repositories.UserRepository;
import models.User;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    static UserRepository userRepository = new InMemoryUserRepository();
    static AuthService authService = new AuthService(userRepository);

    public static void main(String[] args) {
        while (true) {
            if (authService.isAuthenticated()) {
                showUserMenu();
            } else {
                showMainMenu();
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("\n=== Banque Digitale ===");
        System.out.println("1. S'inscrire");
        System.out.println("2. Se connecter");
        System.out.println("3. Quitter");
        System.out.print("Votre choix: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> register();
            case 2 -> login();
            case 3 -> {
                System.out.println("Au revoir !");
                System.exit(0);
            }
            default -> System.out.println("Choix invalide.");
        }
    }

    public static void showUserMenu() {
        System.out.println("\n=== Menu Utilisateur (" + authService.getCurrentUser().getFullName() + ") ===");
        System.out.println("1. Créer un compte ");
        System.out.println("2. Lister mes comptes ");
        System.out.println("3. Dépôt ");
        System.out.println("4. Retrait ");
        System.out.println("5. Virement ");
        System.out.println("6. Historique ");
        System.out.println("7. Modifier le profil");
        System.out.println("8. Déconnexion");
        System.out.print("Votre choix: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> System.out.println(" créer un compte");
            case 2 -> System.out.println(" lister les comptes");
            case 3 -> System.out.println(" dépôt");
            case 4 -> System.out.println(" retrait");
            case 5 -> System.out.println(" virement");
            case 6 -> System.out.println(" historique");
            case 7 -> updateProfile();
            case 8-> authService.logout();
            default -> System.out.println("Choix invalide !");
        }
    }


    public static void register() {
        System.out.print("Nom complet: ");
        String fullName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Adresse: ");
        String address = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        authService.register(fullName, email, address, password);
    }


    public static void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        if (authService.login(email, password)) {
            System.out.println("Connexion réussie !");
        }
    }

    public static void updateProfile() {
        if (!authService.isAuthenticated()) {
            System.out.println("Vous devez être connecté pour modifier votre profil.");
            return;
        }

        User currentUser = authService.getCurrentUser();

        System.out.println("\n=== Modification du profil ===");
        System.out.print("Nouveau nom complet (" + currentUser.getFullName() + "): ");
        String fullName = scanner.nextLine();
        if (fullName.isEmpty()) {
            fullName = currentUser.getFullName();
        }

        System.out.print("Nouvelle adresse (" + currentUser.getAddress() + "): ");
        String address = scanner.nextLine();
        if (address.isEmpty()) {
            address = currentUser.getAddress();
        }

        System.out.print("Nouveau mot de passe (laisser vide pour ne pas changer): ");
        String password = scanner.nextLine();
        if (password.isEmpty()) {
            password = currentUser.getPassword();
        } else if (password.length() < 6) {
            System.out.println("Mot de passe trop court (min 6 caractères). Modification annulée.");
            return;
        }

        if (authService.updateProfile(fullName, address, password)) {
            System.out.println("Profil mis à jour avec succès !");
        } else {
            System.out.println("Erreur lors de la mise à jour du profil.");
        }
    }
}
