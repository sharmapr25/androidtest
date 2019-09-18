package com.example.testspike;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    @Test
    public void isValidEmail_expectReturnTrue_whenGivenEmailIsCorrect(){
        boolean isValid = EmailValidator.isValidEmail("name@email.com");
        assertTrue(isValid);
    }


    @Test
    public void isValidEmail_expectReturnTrue_whenGivenEmailHasCorrectSubdomain(){
        boolean isValid = EmailValidator.isValidEmail("name@email.co.uk");
        assertTrue(isValid);
    }

    @Test
    public void isValidEmail_expectReturnFalse_whenGivenEmailHasNoUserName(){
        boolean isValid = EmailValidator.isValidEmail("@email.com");
        assertFalse(isValid);
    }

    @Test
    public void isValidEmail_expectReturnFalse_whenGivenEmailHasExtraDotCharacter(){
        boolean isValid = EmailValidator.isValidEmail("name@email..com");
        assertFalse(isValid);
    }

    @Test
    public void isValidEmail_expectReturnFalse_whenGivenEmailIsWithoutDotCom(){
        boolean isValid = EmailValidator.isValidEmail("name@email");
        assertFalse(isValid);
    }

    @Test
    public void isValidEmail_expectReturnFalse_whenGivenEmailIsEmpty(){
        boolean isValid = EmailValidator.isValidEmail("");
        assertFalse(isValid);
    }

    @Test
    public void isValidEmail_expectReturnFalse_whenGivenEmailIsNull(){
        boolean isValid = EmailValidator.isValidEmail(null);
        assertFalse(isValid);
    }
}