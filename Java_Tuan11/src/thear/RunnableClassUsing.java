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
public class RunnableClassUsing {

    public static void main(String[] args) {
        RunnableThead obj = new RunnableThead();
        Thread t = new Thread(obj);
        t.start();
        System.out.println("I'm the main theard.");
        System.out.println("Hello");
    }
}
