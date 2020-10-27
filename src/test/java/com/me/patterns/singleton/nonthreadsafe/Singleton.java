package com.me.patterns.singleton.nonthreadsafe;

public class Singleton {

    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (null == instance) {
            instance = new Singleton(value);
        }
        return instance;
    }
}

class DemoSingleThread {
    public static void main(String[] args) {
        Singleton st1 = Singleton.getInstance("Hello");
        Singleton st2 = Singleton.getInstance("World");

        System.out.println(st1.value);
        System.out.println(st2.value);
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
            Singleton instance = Singleton.getInstance("Hello");
            System.out.println(instance.value);
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.getInstance("World");
            System.out.println(instance.value);
        }
    }
}
