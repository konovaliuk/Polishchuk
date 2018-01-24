package ua.com.delivery.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidationTest {

    @Test
    public void validPasswordTest(){
        boolean validPass1 = Validation.getInstance().validPassword("Rjksofer6^");
        boolean validPass2 = Validation.getInstance().validPassword("juols^");
        boolean validPass3 = Validation.getInstance().validPassword("Rjksofer6");
        boolean validPass4 = Validation.getInstance().validPassword("Ameba12^");
        boolean validPass5 = Validation.getInstance().validPassword("figifigi");
        boolean validPass6 = Validation.getInstance().validPassword("aesyBka2^");
        assertEquals(true, validPass1);
        assertEquals(false, validPass2);
        assertEquals(false, validPass3);
        assertEquals(true, validPass4);
        assertEquals(false, validPass5);
        assertEquals(true, validPass6);
    }

    @Test
    public void validUsernameTest(){
        boolean validUName1 = Validation.getInstance().validUsername("Polik");
        boolean validUName2 = Validation.getInstance().validUsername("Marshal");
        boolean validUName3 = Validation.getInstance().validUsername("klon");
        boolean validUName4 = Validation.getInstance().validUsername("m");
        boolean validUName5 = Validation.getInstance().validUsername("virys%");
        boolean validUName6 = Validation.getInstance().validUsername("Apple");
        assertEquals(true, validUName1);
        assertEquals(true, validUName2);
        assertEquals(true, validUName3);
        assertEquals(false, validUName4);
        assertEquals(false, validUName5);
        assertEquals(true, validUName6);
    }

    @Test
    public void validEmailTest(){
        boolean validEmail1 = Validation.getInstance().validEmail("olexandr@gmail.com");
        boolean validEmail2 = Validation.getInstance().validEmail("@olexandr@gmail.com");
        boolean validEmail3 = Validation.getInstance().validEmail("2142`3@gmail.com");
        boolean validEmail4 = Validation.getInstance().validEmail("-kukushka@ukr.net");
        boolean validEmail5 = Validation.getInstance().validEmail("victor.pavlik@gmail.com");
        boolean validEmail6 = Validation.getInstance().validEmail("``sa`1+`@gmail.com");
        assertEquals(true, validEmail1);
        assertEquals(false, validEmail2);
        assertEquals(true, validEmail3);
        assertEquals(true, validEmail4);
        assertEquals(true, validEmail5);
        assertEquals(true, validEmail6);
    }

}
