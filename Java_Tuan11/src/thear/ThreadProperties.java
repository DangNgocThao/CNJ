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
public class ThreadProperties extends Thread {

    public ThreadProperties(String theardName) {
        super(theardName);
        this.start();
    }

    public static void showProperties(Thread t) {
        System.out.println("I'm the " + t.getName() + " theard");
        System.out.println("--My ID: " + t.getId());
        System.out.println("--My name: " + t.getName());
        System.out.println("--My priority: " + t.getPriority());
        System.out.println("--My state: " + t.getState());
        System.out.println("--I'm a daemon: " + t.isDaemon());
        System.out.println("--I'm alive: " + t.isAlive());
    }

    @Override
    public void run() {
        showProperties(this);
    }

    public static void main(String[] args) {
        System.out.println("Theard count: " + Thread.activeCount());
        Thread t = Thread.currentThread();
        showProperties(t);
        ThreadProperties t1 = new ThreadProperties("Son1");
        ThreadProperties t2 = new ThreadProperties("Son2");
        System.out.println("Theard count: " + Thread.activeCount());
    }
}
