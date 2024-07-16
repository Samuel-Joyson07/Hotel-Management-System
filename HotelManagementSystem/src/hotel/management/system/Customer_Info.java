// Using net.proteanit.sql of rs2xml Library to copy the DB values into the current window.



package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Customer_Info extends JFrame implements ActionListener {
    JButton back;
    JTable table;
    Customer_Info() {
        setLayout(null);
        setBounds(350,120,900,600);

        // Labels

        JLabel l1 = new JLabel("Document");
        l1.setBounds(55,50,100,15);
        add(l1);

        JLabel l2 = new JLabel("Number");
        l2.setBounds(160,50,100,15);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(275,50,100,15);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(365,50,100,15);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(465,50,100,15);
        add(l5);

        JLabel l6 = new JLabel("Room");
        l6.setBounds(575,50,100,15);
        add(l6);

        JLabel l7 = new JLabel("Check_in_Time");
        l7.setBounds(655,50,100,15);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(770,50,100,15);
        add(l8);


        table = new JTable();
        table.setBounds(30,70,820,300);
        add(table);

        try {
            Conn c = new Conn();
            String query = "select * from customer";
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
        back.setBounds(345,400,150,40);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Customer_Info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            new Reception();
            setVisible(false);
        }
    }
}
