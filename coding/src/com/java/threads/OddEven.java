package com.java.threads;

public class OddEven {

    public static void main(String[] args) {
        OddEven st = new OddEven();
        try{st.test();} catch(Exception e){}
    }

    private void test() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    synchronized (this) {
                        System.out.println("t1: " + i);
                        notify();
                        try { wait(); } catch (Exception e) {}
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    synchronized (this) {
                        System.out.println("t2: " + i);
                        notify();
                        try { wait(); } catch (Exception e) {}
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
