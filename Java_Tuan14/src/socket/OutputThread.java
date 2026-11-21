/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class OutputThread extends Thread {

    Socket socket;
    JTextArea txt;
    BufferedReader bf;
    String sender;
    String receiver;

    public OutputThread(Socket s, JTextArea txt, String sender, String receiver) {
        super();
        this.socket = s;
        this.txt = txt;
        this.sender = sender;
        this.receiver = receiver;
        try {
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Network Error!");
            System.exit(0);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (socket != null) {
                    String msg = "";
                    if ((msg = bf.readLine()) != null && msg.length() > 0) {
                        txt.append("\n" + receiver + ": " + msg);
                    }
                }
                sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
