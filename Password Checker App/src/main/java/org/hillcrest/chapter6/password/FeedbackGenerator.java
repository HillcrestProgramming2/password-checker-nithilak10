package org.hillcrest.chapter6.password;

public class FeedbackGenerator {
    //utility class for generating feedback based on password

    public static String generateFeedback (String password){
        String feedback = "";

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        String specialCharacters = "!@#$%^&*()-+=";

        if (password.length() < 8){
            feedback += "Increase the length to at least 8 characters. \n";
        }

        for(int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)){
                hasUpper = true;
            }

            if(Character.isLowerCase(ch)){
                hasLower = true;
            }

            if(Character.isDigit(ch)){
                hasNumber = true;
            }

            if(specialCharacters.indexOf(ch) != -1){
                hasSpecial = true;
            }
        }

        if(!hasUpper){
            feedback += "Add at least one uppercase letter. \n";
        }

        if(!hasLower){
            feedback += "Add at least one lowercase letter. \n";
        }

        if(!hasNumber){
            feedback += "Add at least one number. \n";
        }

        if(!hasSpecial){
            feedback += "Include at least one special character. \n";
        }

        if(feedback.equals("")){
            return "Your password meets all criteria!";
        }

        return feedback;
    }
}
