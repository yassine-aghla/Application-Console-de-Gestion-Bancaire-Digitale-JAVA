import java.util.Scanner;

public class Main {

    // Déclaration d'un scanner global
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        System.out.println(" Banque Digital");
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
                System.out.println("Au revoir");
                System.exit(0);
            }
            default -> System.out.println("Choix invalide");
        }
    }

    public static void showUserMenu() {
        System.out.println("Menu Utilisateur");
        System.out.println("1. Créer un compte");
        System.out.println("2. Lister mes comptes");
        System.out.println("3. Dépôt");
        System.out.println("4. Retrait");
        System.out.println("5. Virement");
        System.out.println("6. Historique");
        System.out.println("7. Déconnexion");
        System.out.print("Votre choix: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> createAccount();
            case 2 -> listAccounts();
            case 3 -> deposit();
            case 4 -> withdraw();
            case 5 -> transfer();
            case 6 -> showHistory();
            default -> System.out.println("Choix invalide!");
        }
    }

    public static void register() {}
    public static void login() {
    }
    public static void createAccount() {}
    public static void listAccounts() {}
    public static void deposit() {}
    public static void withdraw() {}
    public static void transfer() {}
    public static void showHistory() {}
}
