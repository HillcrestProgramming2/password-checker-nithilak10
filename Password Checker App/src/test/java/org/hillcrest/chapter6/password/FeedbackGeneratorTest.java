package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FeedbackGeneratorTest {

    @Test
    public void testFeedback_AllCriteriaMet(){
        String password = "Abcdef1!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertEquals("Your password meets all criteria!", feedback);
    }

    @Test
    public void testFeedback_MissingLength(){
        String password = "Ab1!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("Increase the length to at least 8 characters."));
    }

    @Test
    public void testFeedback_MissingUppercase(){
        String password = "abcdef1!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("Add at least one uppercase letter."));
    }

    @Test
    public void testFeedback_MissingLowercase(){
        String password = "ABCDEF1!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("Add at least one lowercase letter."));
    }

    @Test public void testFeedback_MissingNumber() {
        String password = "Abcdefg!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("Add at least one number."));
    }

    @Test public void testFeedback_MissingSpecialCharacter() {
        String password = "Abcdefg1";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("Include at least one special character."));
    }

    @Test
    public void testFeedback_MultipleFailure(){
        String password = "abc";
        String feedback = FeedbackGenerator.generateFeedback(password);

        assertTrue(feedback.contains("Increase the length to at least 8 characters."));
        assertTrue(feedback.contains("Add at least one uppercase letter."));
        assertTrue(feedback.contains("Add at least one number."));
        assertTrue(feedback.contains("Include at least one special character."));
    }
}
