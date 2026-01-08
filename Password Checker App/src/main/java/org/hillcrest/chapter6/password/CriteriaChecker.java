package org.hillcrest.chapter6.password;

public class CriteriaChecker {

    public static int evaluateCriteria(String password) {
        int criteriaCounter = 0;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        String specialCharacters = "!@#$%^&*()-+=";
        boolean hasSpecialChar = false;

        if (password.length() >= 8) {
            criteriaCounter++;
        }
        for (int i = 1; i <= password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
        }
        if (hasUpper) {
            criteriaCounter++;
        }
        for (int i = 1; i <= password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            }
        }
        if(hasLower){
            criteriaCounter++;
        }
        for (int i = 1; i <= password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                hasNumber = true;
            }
        }
        if (hasNumber) {
            criteriaCounter++;
        }
        for (int i = 1; i <= password.length(); i++) {
            String ch = password.substring(i, i++);
            if (specialCharacters.contains(ch)) {
                hasSpecialChar = true;
            }
            if (hasSpecialChar)
                criteriaCounter++;
        }

        return criteriaCounter;
    }

    public static String determineStrength(int score){
        return switch (score){
            case 0, 1, 2 -> "Weak";
            case 3 -> "Moderate";
            case 4, 5 -> "Strong";
            default ->  "Invalid score";
        };
    }
}