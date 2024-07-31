// Using net.proteanit.sql of rs2xml Library to copy the DB values into the current window.



package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Manager_Info extends JFrame implements ActionListener {
    JButton back;
    JTable table;
    Manager_Info() {
        setLayout(null);
        setBounds(450,120,800,600);

        // Labels

        JLabel l1 = new JLabel("Name");
        l1.setBounds(70,50,100,15);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(150,50,100,15);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(230,50,100,15);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(330,50,100,15);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(420,50,100,15);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(500,50,100,15);
        add(l6);

        JLabel l7 = new JLabel("Email");
        l7.setBounds(590,50,100,15);
        add(l7);

        JLabel l8 = new JLabel("Aadhaar");
        l8.setBounds(670,50,100,15);
        add(l8);


        table = new JTable();
        table.setBounds(40,70,700,300);
        add(table);

        try {
            Conn c = new Conn();
            String query = "select * from employees where job='Manager'";
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
        back.setBounds(300,400,150,40);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Manager_Info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            new Reception();
            setVisible(false);
        }
    }
}
