/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class JFrame2 extends JFrame {

    public JFrame2() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("JPanel Demo");
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GREEN);
        JButton button1 = new JButton("Đây là nút lệnh");
        panel1.add(button1);
        con.add(panel1, BorderLayout.NORTH);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.CYAN);
        JLabel label1 = new JLabel("Đây là label");
        panel2.add(label1);
        con.add(panel2, BorderLayout.CENTER);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame2 gui = new JFrame2();
        gui.setVisible(true);
    }
}
