package hotel.management.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    // for the first welcome page to open as we call the constructor
    // we have to write things inside the constructor
    HotelManagementSystem() {   // constructor
        setBounds(100,100,1380,600);
        //setLayout(null);   default layout is 'Border'

        // setting background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel label1 = new JLabel(i1);
        add(label1);


        // header
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");

        text.setBounds(340,10,1000,90);
        text.setForeground(Color.ORANGE);
        text.setFont(new Font("serif",Font.BOLD,40));
        label1.add(text);

        // Button
        JButton next = new JButton("Next");
        next.setBounds(1200,500,100,30);
        next.setFont(new Font("serif",Font.BOLD,20));
        next.addActionListener(this);
        label1.add(next);

        setVisible(true);

        // Blinking header
        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }


    public static void main(String[] args) {
        // creating class object
        new HotelManagementSystem();
    }


}
