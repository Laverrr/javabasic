package com.laver.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //Declared可以获取所有的方法和属性，无视私有
        //不加Declared只能获取public的方法和属性

//        Class<Robot> robotClass = Robot.class;
//        robotClass.getDeclaredMethod("sayHi", String.class);
//        robotClass.getDeclaredField("name");
        Class rc = Class.forName("com.laver.javabasic.reflect.Robot");
        Robot robot = (Robot)rc.newInstance();
        System.out.println("Class name is "+rc.getName());
        Method getHello = rc.getDeclaredMethod("throwHello",String.class);
        getHello.setAccessible(true);
        Object str = getHello.invoke(robot,"Bob");
        System.out.println("getHello result is "+str);
        Method sayHi = rc.getMethod("sayHi", String.class);
        Object result = sayHi.invoke(robot, "welcome");
        System.out.println("sayHi result is "+result);
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot,"welcome");
        Object laver = sayHi.invoke(robot, "laver");
        System.out.println("sayHi result is " + laver);


    }
}
