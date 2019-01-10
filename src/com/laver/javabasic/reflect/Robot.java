package com.laver.javabasic.reflect;

public class Robot {
    private String name;
    public void sayHi(String helloSemtemce){
        System.out.println(helloSemtemce+" "+name);

    }

    private String throwHello(String tag){
        return "Hello " + tag;
    }
}
