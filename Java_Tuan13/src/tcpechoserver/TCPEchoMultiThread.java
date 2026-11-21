/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpechoserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Administrator
 */
public class TCPEchoMultiThread {

    public static final int DEFAULT_PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket servSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("Server waiting for port: " + DEFAULT_PORT);
            while (true) {
                Runnable t = new TCPEchoThread(servSocket.accept());
                new Thread(t).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
