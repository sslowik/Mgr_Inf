package com.designpatterns.mgrinf.singleton;

public class SingletonLazyDoubleCheck {

    private static SingletonLazyDoubleCheck INSTANCE = null;

    private int value;
   
    private SingletonLazyDoubleCheck() {}

    public static SingletonLazyDoubleCheck getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonLazyDoubleCheck.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonLazyDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
}