/**
 * This class reads the stats from a txt file and then implements a simple user login validation system using HashMaps
 *
 * @author Kisha Kalra - B00911426
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class Exercise1 {
        // Main method where the program execution begins
        public static void main(String[] args) {
            // Create hashmaps to store username-password and username-fullname pairs
            Map<String, String> passwordMap = new HashMap<>();
            Map<String, String> nameMap = new HashMap<>();

            // Read user data from the file
            readingData("input.txt", passwordMap, nameMap);

            // Prompt user for login
            validation(passwordMap, nameMap);
        }
        // Method to read user data from a file and populate the passwordMap and nameMap
        private static void readingData(String filename, Map<String, String> passwordMap, Map<String, String> nameMap) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                // Iterate through each line in the file
                while ((line = reader.readLine()) != null) {
                    // Split the line into words based on space
                    String[] words = line.split(" ");
                    // Check if the line contains the expected number of words
                    if (words.length == 4) {
                        // Extract full name, username, and password
                        String name = words[0] + " " + words[1];
                        String username = words[2];
                        String password = words[3];
                        // Populate the passwordMap and nameMap
                        passwordMap.put(username, password);
                        nameMap.put(username, name);
                    }
                }
            } catch (IOException e) {
                // Print the stack trace in case of an exception
                e.printStackTrace();
            }
        }
        // Method to validate user login by checking the entered username and password
        private static void validation(Map<String, String> passwordMap, Map<String, String> fullNameMap) {
            Scanner scanner = new Scanner(System.in);

            int attempt = 0;
            // Allow up to 3 login attempts
            while (attempt < 3) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // Check if the entered password matches the stored password for the username
                if (password.equals(passwordMap.get(username))) {
                    // Print a welcome message upon successful login
                    System.out.println("Login Successful!");
                    System.out.println("Welcome, " + fullNameMap.get(username) + "!");
                    break;
                } else {
                    // Increment the attempts counter
                    attempt ++;
                    }
                // Provide feedback on incorrect login attempts
                if (attempt == 1) {
                    System.out.println("Either the username or password is incorrect. You have 2 more attempts.");
                }
                if (attempt == 2) {
                    System.out.println("Either the username or password is incorrect. You have 1 more attempts.");
                }
            }
            // Display a message if the maximum login attempts are reached
            if (attempt == 3) {
                System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
            }

            scanner.close();
        }
    }
