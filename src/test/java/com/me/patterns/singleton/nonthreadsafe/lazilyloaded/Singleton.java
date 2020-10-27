package com.me.patterns.singleton.nonthreadsafe.lazilyloaded;

public final class Singleton {

    private static Singleton instance;

    private Singleton() {
        // some initialization code
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Demo {
    public static void main(String[] args) {
//        Singleton singleton = new Singleton(); not allowed as the constructor has private access
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        if (singleton1 == singleton2) {
            System.out.println("Its equal!, both objects are same");
        }
    }
}
