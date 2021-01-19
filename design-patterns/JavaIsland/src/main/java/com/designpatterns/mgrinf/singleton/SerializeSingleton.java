package com.designpatterns.mgrinf.singleton;

import java.io.*;

public class SerializeSingleton implements Serializable {

    public boolean checkSingletonSerialization() {
        System.out.println("Checking serialization of SingletonPublicStatic");
        SingletonPublicStatic singleton = SingletonPublicStatic.INSTANCE;
        singleton.setValue(1);

        // Serialize
        try {
            FileOutputStream fileOut = new FileOutputStream("singletonOut.srl");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(singleton);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        singleton.setValue(2);

        // Deserialize
        SingletonPublicStatic singleton2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("singletonOut.srl");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            singleton2 = (SingletonPublicStatic) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();
        }

        boolean result = singleton == singleton2;

        System.out.println("Singleton value: " + singleton.getValue());
        System.out.println("Singleton2 value: " + singleton2.getValue());

        System.out.println("Two objects of: SingletonPublicStatic.class are same: " + result);

        return result;
    }
}

