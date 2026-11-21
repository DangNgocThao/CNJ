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
public class RunnableThead implements Runnable{

    public RunnableThead() {
    }

    @Override
    public void run() {
        System.out.println("I'm a child theard.");
    }
}
