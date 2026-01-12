package org.hillcrest.chapter6.password;

/**
 * A class that determines the strength of a password based on length,
 * uppercase/lowercase letters, numbers, and special characters.
 */
public class CriteriaChecker {

    /**
     * Evaluates the inputted password and returns which criteria is met.
     * @param password the password to evaluate
     * @return number of criteria met 0-5.
     */
    public static int evaluateCriteria(String password) {
        int criteriaCounter = 0;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        String specialCharacters = "!@#$%^&*()-+=";
        boolean hasSpecial = false;

        //length check
        if (password.length() >= 8) {
            criteriaCounter++;
        }

        //uppercase check
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

        //lowercase check
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

        //number check
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

        //special character check
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

    /**
     * Determines what is printed based on number of criteria met.
     * @param score number of criteria met.
     * @return "Weak", "Moderate", "Strong", or "Invalid score".
     */
    public static String determineStrength(int score){
        return switch (score){
            case 0, 1, 2 -> "Weak";
            case 3 -> "Moderate";
            case 4, 5 -> "Strong";
            default ->  "Invalid score";
        };
    }
}