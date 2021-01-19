package com.designpatterns.mgrinf.singleton;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SingletonDesignPattern {
    /*
     * zastanowic sie nad wspolbieznoscia - double checki? czy oplaca sie blokowac
     * watki?
     *
     * temat serializacji / deserializacji: ->
     *  metoda protected Object readResolve() { return getInstance();}
     * pytanie jak to działa?
     */

    private static Long startTime;
    private static SingletonEnum singleton;
    private static SingletonLazy singletonLazy;
    private static SingletonLazyDoubleCheck singletonLazy2;

    private static final int CYCLES = 100000000;

    private static boolean rerun = false;

    @BeforeClass
    private void welcome() {
        System.out.println("Hello world of Singletons!");
    }

    @BeforeMethod
    private void setUp() {
        resetTime();
        splitOutput(50, '=');
    }

    //TODO do testów wydajności użyć zewnętrznego profilera !

    @Test(priority = 1)
    public void testSingletonSerialization() {
        //Serialization
        System.out.println("Checking singleton serialization.");
        SerializeSingleton serial = new SerializeSingleton();
        boolean resultSerialization = serial.checkSingletonSerialization();
        splitOutput(50, '.');
        System.out.println("Serialization validated with result: " + String.valueOf(resultSerialization).toUpperCase());
        splitOutput(50, '.');
        rerun = false;
    }

    @Test(priority = 1)
    public void testSingletonReflection() {
//        while (rerun) {
        System.out.println("Checking singleton by reflection.");
        ReflectSingleton reflect = new ReflectSingleton();
        boolean resultReflection = false;
        try {
            resultReflection = reflect.testSingletonWithReflection();
        } catch (Exception e) {
            System.out.println("Exception during Reflection testing. E: " + e.getMessage());
            e.printStackTrace();
        }
        splitOutput(50, '.');
        System.out.println("Reflection validated with result: " + String.valueOf(resultReflection).toUpperCase());
        splitOutput(50, '.');
//            rerun = false;
//        }
    }

    @Test(priority = 2)
    public void testSingletonEnum() {
        System.out.println("Testing SingletonEnum performance");
        singleton = SingletonEnum.INSTANCE;
        int hc = singleton.hashCode();
        for (int i = 1; i <= CYCLES - 1; i++) {
            singleton = SingletonEnum.INSTANCE;
            singleton.setValue(i);
        }
        splitOutput(50, '.');
        System.out.println("SingletonEnum time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singleton.getValue());
        splitOutput(50, '.');

        assertTrue(singleton.hashCode() == hc, "FAIL -> Instance not equals!");
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
        splitOutput(50, '.');
        System.out.println("SingletonLazy time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singletonLazy.getValue());
        splitOutput(50, '.');
        assertTrue(singletonLazy.hashCode() == hc1, "FAIL -> Instance not equals!");

    }

    @Test(priority = 4)
    public void testSingletonLazyDoubleCheck() {
        System.out.println("Testing SingletonLazyDoubleCheck performance");
        singletonLazy2 = SingletonLazyDoubleCheck.getInstance();
        int hc2 = singletonLazy2.hashCode();

        for (int i = 1; i <= CYCLES - 1; i++) {
            singletonLazy2 = SingletonLazyDoubleCheck.getInstance();
            singletonLazy2.setValue(i);
        }
        splitOutput(50, '.');
        System.out.println("SingletonLazyDoubleCheck time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singletonLazy2.getValue());
        splitOutput(50, '.');
        assertTrue(singletonLazy2.hashCode() == hc2, "FAIL -> Instance not equals!");
    }

    @Test(priority = 5)
    public void testSingletonPublicStatic() {
        System.out.println("Testing SingletonPublicStatic performance");
        SingletonPublicStatic singleton = SingletonPublicStatic.INSTANCE;
        int hc2 = singleton.hashCode();

        for (int i = 1; i <= CYCLES - 1; i++) {
            singleton = SingletonPublicStatic.INSTANCE;
            singleton.setValue(i);
        }
        splitOutput(50, '.');
        System.out.println("SingletonPublicStatic time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singleton.getValue());
        splitOutput(50, '.');

        assertTrue(singleton.hashCode() == hc2, "FAIL -> Instance not equals!");
    }

    private void resetTime() {
        startTime = System.currentTimeMillis();
    }


    public static void setRerun(boolean rerun) {
        if (rerun) SingletonDesignPattern.rerun = true;
        else SingletonDesignPattern.rerun = false;
    }

    public void splitOutput(int width, char ch) {
        for (int i = 0; i < width; i++) {
            System.out.print(ch);
        }
        System.out.print("\n");
    }
}
