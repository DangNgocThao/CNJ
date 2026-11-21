/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class JFrame1 extends JFrame {

    public JFrame1() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Ví dụ tạo của số 2...");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Container con = getContentPane();
        JButton btnThoat = new JButton("Thoát");
        btnThoat.setIcon(new ImageIcon("img\\thoat.png"));
        con.add(btnThoat);
    }

    public static void main(String[] args) {
        JFrame1 gui = new JFrame1();
        gui.setVisible(true);
    }
}
