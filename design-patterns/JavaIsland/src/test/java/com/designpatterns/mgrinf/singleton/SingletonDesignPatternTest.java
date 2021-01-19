package com.designpatterns.mgrinf.singleton;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SingletonDesignPatternTest {
    private static Long startTime;
    private static SingletonEnum singleton;
    private static SingletonLazy singletonLazy;
    private static SingletonLazyDoubleCheck singletonLazy2;

    private static final int CYCLES = 100000000;

    @BeforeMethod
    private void setUp() {
        resetTime();
    }

    //TODO do testów wydajności użyć zewnętrznego profilera !

    @Test(priority = 1)
    public void testSingletonReflectionAndSerialization() {

        System.out.println("Hello world of Singletons!");

        //Serialization
        System.out.println("Checking singleton serialization.");
        SerializeSingleton serial = new SerializeSingleton();
        boolean resultSerialization = serial.checkSingletonSerialization();
        System.out.println("Serialization validated with result: " + String.valueOf(resultSerialization).toUpperCase());

        //Reflection
        System.out.println("Checking singleton by reflection.");
        ReflectSingleton reflect = new ReflectSingleton();
        boolean resultReflection = false;
        try {
            resultReflection = reflect.testSingletonWithReflection();
        } catch (Exception e) {
            System.out.println("Exception during Reflection testing. E: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Reflection validated with result: " + String.valueOf(resultReflection).toUpperCase());
    }

    @Test(priority = 2)
    public void testSingletonPublicStatic() {
        System.out.println("Testing SingletonPublicStatic performance");
        SingletonPublicStatic singleton = SingletonPublicStatic.INSTANCE;
        int hc2 = singleton.hashCode();

        for (int i = 1; i <= CYCLES - 1; i++) {
            singleton = SingletonPublicStatic.INSTANCE;
            singleton.setValue(i);
        }
        System.out.println("SingletonPublicStatic time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singleton.getValue());
        assertTrue(singleton.hashCode() == hc2, "FAIL -> Instance not equals!");
    }

    @Test(priority = 3)
    public void testSingletonEnum() {
        System.out.println("Testing SingletonEnum performance");
        singleton = SingletonEnum.INSTANCE;
        int hc = singleton.hashCode();
        for (int i = 1; i <= CYCLES - 1; i++) {
            singleton = SingletonEnum.INSTANCE;
            singleton.setValue(i);
        }
        System.out.println("SingletonEnum time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singleton.getValue());

        assertTrue(singleton.hashCode() == hc, "FAIL -> Instance not equals!");
    }

    @Test(priority = 2)
    public void testSingletonLazyDoubleCheck() {
        System.out.println("Testing SingletonLazyDoubleCheck performance");
        singletonLazy2 = SingletonLazyDoubleCheck.getInstance();
        int hc2 = singletonLazy2.hashCode();

        for (int i = 1; i <= CYCLES - 1; i++) {
            singletonLazy2 = SingletonLazyDoubleCheck.getInstance();
            singletonLazy2.setValue(i);
        }
        System.out.println("SingletonLazyDoubleCheck time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singletonLazy2.getValue());
        assertTrue(singletonLazy2.hashCode() == hc2, "FAIL -> Instance not equals!");
    }

    @Test(priority = 3)
    public void testSingletonLazy() {
        System.out.println("Testing SingletonLazy performance");
        singletonLazy = SingletonLazy.getInstance();
        int hc1 = singletonLazy.hashCode();
        for (int i = 1; i <= CYCLES - 1; i++) {
            singletonLazy = SingletonLazy.getInstance();
            singletonLazy.setValue(i);
        }
        System.out.println("SingletonLazy time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singletonLazy.getValue());
        assertTrue(singletonLazy.hashCode() == hc1, "FAIL -> Instance not equals!");
    }

    private static void resetTime() {
        startTime = System.currentTimeMillis();
    }
}
