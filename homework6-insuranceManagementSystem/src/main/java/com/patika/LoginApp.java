package com.patika;

import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();

        // Example data
        User user1 = new User("John", "Doe", "john.doe@example.com", "password123", "Engineer", 30);
        Account account1 = new Individual(user1);
        accountManager.addAccount(account1);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Account account = accountManager.login(email, password);

        if (account != null && account.getAuthStatus() == AuthenticationStatus.SUCCESS) {
            System.out.println("Login successful!");
            account.showUserInfo();
        } else {
            System.out.println("Invalid email or password.");
        }

        scanner.close();
    }
}

