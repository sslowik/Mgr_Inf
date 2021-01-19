package com.designpatterns.mgrinf.singleton;

public class SingletonLazy {

	private static SingletonLazy INSTANCE = null;
	private int value;

	private SingletonLazy() {
	}

	public static SingletonLazy getInstance() {
		synchronized (SingletonLazy.class) {
			if (INSTANCE == null) {
				INSTANCE = new SingletonLazy();
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
