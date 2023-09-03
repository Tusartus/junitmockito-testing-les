package com.codetesting.codetesting.code1;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



//https://www.jetbrains.com/help/idea/junit.html

class DemoUtilsTest {

    @Test
    void testEqualsAndNotEquals() {

        //set up
        DemoUtils utilDemo = new DemoUtils();

        int expected = 6;
        int unexpected = 8;

        //execute   of the methode
        int actual = utilDemo.add(2,4);


        //assert
       // Assertions.assertEquals(expected, actual, "2 + 4 mut be 6");
        //Assertions.assertNotEquals(unexpected, actual, "2+4 must not be 8");
        assertEquals(expected, actual, "2 + 4 mut be 6");
        assertNotEquals(unexpected, actual, "2+4 must not be 8");

    }

    @Test
    void testNullAndNotNull() {
        DemoUtils demoUtils = new DemoUtils();
        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }


    /*
     to know
    https://junit.org/junit5/docs/current/user-guide/#writing-tests
     */
}