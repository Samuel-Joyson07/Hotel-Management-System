// Using net.proteanit.sql of rs2xml Library to copy the DB values into the current window.



package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
    JButton back;
    JTable table;
    Department() {
        setLayout(null);
        setBounds(450,120,600,500);

        // Labels

        JLabel l1 = new JLabel("Name");
        l1.setBounds(140,50,100,15);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(370,50,100,15);
        add(l2);


        table = new JTable();
        table.setBounds(65,70,450,200);
        add(table);

        try {
            Conn c = new Conn();
            String query = "select * from department";
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
        back.setBounds(200,300,150,40);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            new Reception();
            setVisible(false);
        }
    }
}
