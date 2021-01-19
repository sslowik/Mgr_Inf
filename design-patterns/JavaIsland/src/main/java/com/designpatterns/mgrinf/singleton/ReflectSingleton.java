package com.designpatterns.mgrinf.singleton;

import java.lang.reflect.Constructor;

public class ReflectSingleton {
    public boolean testSingletonWithReflection() throws Exception {

        SingletonPublicStatic singleton = SingletonPublicStatic.INSTANCE;
        Constructor constructor = singleton.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);

        SingletonPublicStatic singleton2 = (SingletonPublicStatic) constructor.newInstance();

        boolean result = singleton == singleton2;

        System.out.println("Two objects of  SingletonPublicStatic.class are the same: " + result);

        singleton.setValue(1);
        singleton2.setValue(2);

        System.out.println("value of singleton: " + singleton.getValue());
        System.out.println("value of singleton2: " + singleton2.getValue());

        return result;
    }
}
