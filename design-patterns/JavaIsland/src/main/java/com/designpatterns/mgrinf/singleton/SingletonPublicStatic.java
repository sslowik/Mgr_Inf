package com.designpatterns.mgrinf.singleton;

import java.io.Serializable;

public class SingletonPublicStatic implements Serializable {

    public static final SingletonPublicStatic INSTANCE = new SingletonPublicStatic();
    private int value;

    private SingletonPublicStatic() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /* readResolve() method to ensure deserialization with same instance
    For Serializable and Externalizable classes, the readResolve method allows a class to replace/resolve
    the object read from the stream before it is returned to the caller. By implementing the readResolve method,
    a class can directly control the types and instances of its own instances being deserialized.
    */
    protected Object readResolve() {
        System.out.println("Using readResolve() method.");
        INSTANCE.value = value;
        return INSTANCE;
    }
}
