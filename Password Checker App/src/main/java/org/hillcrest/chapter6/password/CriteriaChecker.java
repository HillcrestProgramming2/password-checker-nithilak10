package org.hillcrest.chapter6.password;

public class CriteriaChecker {

    public static int evaluateCriteria(String password) {
        int criteriaCounter = 0;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        String specialCharacters = "!@#$%^&*()-+=";

        if(password.length() >= 8){
            criteriaCounter++;
        }
        for(int i = 1; i <= password.length(); i++){
            char ch = password.charAt(i);
            if(Character.isUpperCase(ch)){
                hasUpper = true;
            }
        }
        for(int i = 1; i <= password.length(); i++){
            char ch = password.charAt(i);
            if(Character.isLowerCase(ch)){
                hasLower = true;
            }
        }
    }
}