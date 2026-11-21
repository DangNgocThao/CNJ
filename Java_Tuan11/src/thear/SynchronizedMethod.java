/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thear;

/**
 *
 * @author Administrator
 */
public class SynchronizedMethod implements Runnable {

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println();
            }
        }
        System.out.println("Finished " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        SynchronizedMethod m1 = new SynchronizedMethod();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        Thread t3 = new Thread(m1);
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }
}
