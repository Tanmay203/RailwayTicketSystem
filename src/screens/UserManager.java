package screens;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    // The map will store users with their username as the key and password as the value
    private static final Map<String, String> USERS = new HashMap<>();

    static {
        // Adding a default admin user for the system
        USERS.put("admin", "admin123"); // admin username and password
    }

    // Method to register a user
    public static boolean registerUser(String username, String password) {
        // Check if the username already exists
        if (USERS.containsKey(username)) {
            return false; // User already exists
        }
        // Add new user to the map
        USERS.put(username, password);
        return true;
    }

    // Method to authenticate a user
    public static boolean authenticateUser(String username, String password) {
        // Check if the username exists and password matches
        return password.equals(USERS.get(username));
    }
}
