package com.codetesting.codetesting.code1.lifecyclemethod;


import java.util.Arrays;
import java.util.List;

public class DemoUtils {


    private String academy = "Luv2Code Academy";
    private String academyDuplicate = academy;
    public String getAcademy() {
        return academy;
    }
    public String getAcademyDuplicate() {
        return academyDuplicate;
    }

    public Boolean isGreater(int n1, int n2) {
        return n1 > n2;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public Object checkNull(Object obj) {
        if (obj != null) {
            return obj;
        }
        return null;
    }

    //assertArrayEquals

    private String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};
    public String[] getFirstThreeLettersOfAlphabet() {
        return firstThreeLettersOfAlphabet;
    }

    private List<String> academyInList =  Arrays.asList("luv", "2", "code");  //java 8
                                         //List.of  java 9 +

    public List<String> getAcademyInList() {
        return academyInList;
    }



    public String throwException(int a) throws Exception {
        if (a < 0) {
            throw new Exception("Value should be greater than or equal to 0");
        }
        return "Value is greater than or equal to 0";
    }

    public void checkTimeout() throws InterruptedException {
        System.out.println("I am going to sleep");
        Thread.sleep(2000);
        System.out.println("Sleeping over");
    }


}


