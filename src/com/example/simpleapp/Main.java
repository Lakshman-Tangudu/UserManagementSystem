package com.example.simpleapp;

import com.example.simpleapp.model.User;
import com.example.simpleapp.service.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        System.out.println("Welcome to SimpleJavaApp - User Registry\n");
        seedSampleData();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            try {
                int option = Integer.parseInt(input.trim());
                switch (option) {
                    case 1 -> handleAddUser(scanner);
                    case 2 -> handleListUsers();
                    case 3 -> handleSearchByName(scanner);
                    case 4 -> handleDeleteById(scanner);
                    case 5 -> {
                        System.out.println("Exiting. Thank you!");
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please choose 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Add user");
        System.out.println("2. List users");
        System.out.println("3. Search users by name");
        System.out.println("4. Delete user by id");
        System.out.println("5. Exit");
    }

    private static void handleAddUser(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();

        if (name.isEmpty() || email.isEmpty()) {
            System.out.println("Name and email cannot be empty.");
            return;
        }

        User user = userService.addUser(name, email);
        System.out.println("User added: " + user);
    }

    private static void handleListUsers() {
        List<User> users = userService.listUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        users.forEach(System.out::println);
    }

    private static void handleSearchByName(Scanner scanner) {
        System.out.print("Enter search term: ");
        String q = scanner.nextLine().trim();
        List<User> matches = userService.searchByName(q);

        if (matches.isEmpty()) System.out.println("No matching users.");
        else matches.forEach(System.out::println);
    }

    private static void handleDeleteById(Scanner scanner) {
        System.out.print("Enter user id to delete: ");
        String t = scanner.nextLine().trim();

        try {
            int id = Integer.parseInt(t);
            boolean removed = userService.deleteById(id);

            if (removed) System.out.println("User deleted.");
            else System.out.println("No user found with id: " + id);

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numeric id.");
        }
    }

    private static void seedSampleData() {
        userService.addUser("Alice", "alice@example.com");
        userService.addUser("Bob", "bob@example.com");
        userService.addUser("Charlie", "charlie@example.com");
    }
}
