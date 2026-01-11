package org.hillcrest.chapter6.password;

public class CriteriaChecker {

    public static int evaluateCriteria(String password) {
        int criteriaCounter = 0;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        String specialCharacters = "!@#$%^&*()-+=";
        boolean hasSpecial = false;


        if (password.length() >= 8) {
            criteriaCounter++;
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
                break;
            }
        }
        if (hasUpper) {
            criteriaCounter++;
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLower = true;
                break;
            }
        }
        if(hasLower){
            criteriaCounter++;
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                hasNumber = true;
                break;
            }
        }
        if (hasNumber) {
            criteriaCounter++;
        }
        for (int i = 0; i < password.length(); i++) {
            String ch = String.valueOf(password.charAt(i));
            if(specialCharacters.contains(ch)) {
                hasSpecial = true;
                break;
            }
        }
            if (hasSpecial){
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