package com.me.patterns.singleton.billpughapproach;

public class Singleton {

    private Singleton() {
    }

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

class DemoSingleThread {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if (s1 == s2) {
            System.out.println("Both objects are same!");
        }
    }
}

class DemoMultiThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());

        t1.start();
        t2.start();
    }

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            Singleton s1 = Singleton.getInstance();
            System.out.println("Hello this is from Thread1: " + s1);
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            Singleton s2 = Singleton.getInstance();
            System.out.println("Hello this is from Thread2: " + s2);
        }
    }
}
