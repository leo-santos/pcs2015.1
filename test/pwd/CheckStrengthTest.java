/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwd;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wilian
 */
public class CheckStrengthTest {
    
    public CheckStrengthTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


     @Test(expected=Exception.class)
    public void testCheckPasswordStrengthWithException() {
        System.out.println("checkPasswordStrength");
        String passwd = "";
        CheckStrength.checkPasswordStrength(passwd);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
     @Test
    public void testCheckPasswordStrengthWith2Small2Num() {
        System.out.println("checkPasswordStrength");
        String passwd = "rt16";
        int expResult = 0;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith2Num1Small2Capital() {
        System.out.println("checkPasswordStrength");
        String passwd = "13sAG";
        int expResult = 3;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith3Characters() {
        System.out.println("checkPasswordStrength");
        String passwd = "1sA";
        int expResult = 0;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith3Num3SmallOther() {
        System.out.println("checkPasswordStrength");
        String passwd = "135#aet";
        int expResult = 6;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith3Num3Other1Small() {
        System.out.println("checkPasswordStrength");
        String passwd = "147#!@m";
        int expResult = 7;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith3Num2Other2Small2Capital() {
        System.out.println("checkPasswordStrength");
        String passwd = "193#!maAC";
        int expResult = 9;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith3Num3Other2Small3Capital() {
        System.out.println("checkPasswordStrength");
        String passwd = "193#!@maACZ";
        int expResult = 11;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }

    @Test
    public void testCheckPasswordStrengthWith3Num6Other3Small3Capital() {
        System.out.println("checkPasswordStrength");
        String passwd = "179#!@&-!mayACZO";
        int expResult = 14;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWithAlphabeticalSequence() {
        System.out.println("checkPasswordStrength");
        String passwd = "efghijk";
        int expResult = 0;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWithKeyboardSequence() {
        System.out.println("checkPasswordStrength");
        String passwd = "ertyui";
        int expResult = 0;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }

    @Test
    public void testCheckPasswordStrengthWithOnlyNum() {
        System.out.println("checkPasswordStrength");
        String passwd = "3456789";
        int expResult = 0;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    
    @Test
    public void testCheckPasswordStrengthWith2EqualParts() {
        System.out.println("checkPasswordStrength");
        String passwd = "abbbabbb";
        int expResult = 0;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith1PartSmall1PartCapital() {
        System.out.println("checkPasswordStrength");
        String passwd = "abbbABBB";
        int expResult = 4;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
     @Test
    public void testCheckPasswordStrengthWith2PartsSameLetter() {
        System.out.println("checkPasswordStrength");
        String passwd = "aaaBBB";
        int expResult = 2;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith2PartsSameLetter2() {
        System.out.println("checkPasswordStrength");
        String passwd = "aaaBbb";
        int expResult = 2;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith3EqualsNumParts() {
        System.out.println("checkPasswordStrength");
        String passwd = "123123123";
        int expResult = 0;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWithDate() {
        System.out.println("checkPasswordStrength");
        String passwd = "19501010";
        int expResult = 0;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }

    @Test
    public void testCheckPasswordStrengthFromDictionary() {
        System.out.println("checkPasswordStrength");
        String passwd = "adobe12";
        int expResult = 2;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWithSameCapitalLetter() {
        System.out.println("checkPasswordStrength");
        String passwd = "VVVVVVVV";
        int expResult = 0;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testCheckPasswordStrengthWith1PartCapital1PartSmall() {
        System.out.println("checkPasswordStrength");
        String passwd = "VVVVvvvv";
        int expResult = 3;
        int result = CheckStrength.checkPasswordStrength(passwd);
        assertEquals(expResult, result);

    }
   

    /**
     * Test of getPasswordLevel method, of class CheckStrength.
     */
    @Test
    public void testGetPasswordLevel() {
        System.out.println("getPasswordLevel");
        String passwd = "179#!@&-!mayACZO";
        CheckStrength.LEVEL expResult = CheckStrength.LEVEL.EXTREMELY_STRONG;
        CheckStrength.LEVEL result = CheckStrength.getPasswordLevel(passwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
