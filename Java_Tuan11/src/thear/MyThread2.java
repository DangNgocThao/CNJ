/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thear;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class MyThread2 {

    class Thread1 extends Thread {

        public void run() {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        }
    }

    class Thread2 extends Thread {

        public void run() {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
    }

    public MyThread2() {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
        }
        thread2.start();
    }
}
