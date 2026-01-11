package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriteriaCheckerTest {

    @Test
    public void testCriteria_AllCriteriaMet(){
        String password = "Abcdef1!";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(5, score);
    }

    @Test
    public void testCriteria_NoCriteriaMet(){
        String password = "";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(0, score);
    }

    @Test
    public void testCriteria_OnlyLength(){
        String password = "abcdefg";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(1, score);
    }

    @Test
    public void testCriteria_UppercaseOnly(){
        String password = "AAAAAAA";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(1, score);
    }

    @Test
    public void testCriteria_LowercaseOnly(){
        String password = "aaaaaaa";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(1, score);
    }

    @Test
    public void testCriteria_NumberOnly(){
        String password = "1234567";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(1, score);
    }

    @Test
    public void testCriteria_SpecialOnly(){
        String password = "!@#$%";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(1, score);
    }

    @Test
    public void testDetermineStrength_Weak(){
        assertEquals("Weak", CriteriaChecker.determineStrength(0));
        assertEquals("Weak", CriteriaChecker.determineStrength(1));
        assertEquals("Weak", CriteriaChecker.determineStrength(2));
    }

    @Test
    public void testDetermineStrength_Moderate(){
        assertEquals("Moderate", CriteriaChecker.determineStrength(3));
    }

    @Test
    public void testDetermineStrength_Strong(){
        assertEquals("Strong", CriteriaChecker.determineStrength(4));
        assertEquals("Strong", CriteriaChecker.determineStrength(5));
    }

    @Test
    public void testDetermineStrength_Invalid(){
        assertEquals("Invalid score", CriteriaChecker.determineStrength(10));
    }
}
