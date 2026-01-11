package org.hillcrest.chapter6.password;

import java.util.Scanner;

public class PasswordApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int score = CriteriaChecker.evaluateCriteria(password);

        String strength = CriteriaChecker.determineStrength(score);

        String feedback = FeedbackGenerator.generateFeedback(password);

        System.out.println("\nPassword Strength: " + strength);
        System.out.println("Feedback: ");
        System.out.println(feedback);
    }
}

