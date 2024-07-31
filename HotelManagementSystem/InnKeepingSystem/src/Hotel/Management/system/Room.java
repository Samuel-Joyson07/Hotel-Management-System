// Using net.proteanit.sql of rs2xml Library to copy the DB values into the current window.



package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    JButton back;
    JTable table;
    Room() {
        setLayout(null);
        setBounds(200,120,1100,680);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500,70,550,500);
        add(img);

        // Labels

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(20,50,100,15);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120,50,100,15);
        add(l2);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(200,50,100,15);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(320,50,100,15);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(398,50,100,15);
        add(l5);

        table = new JTable();
        table.setBounds(20,70,450,400);
        add(table);

        try {
            Conn c = new Conn();
            String query = "select * from rooms";
            ResultSet rs = c.s.executeQuery(query);

            // to copy the values from the DB to the window, we use a library
            // in that library,we import net.proteanit.sql
            // we use 'resultSettoTableModel method and pass rs object.

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setFont(new Font("ariel", Font.BOLD,18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(180,500,150,40);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            new Reception();
            setVisible(false);
        }
    }
}
