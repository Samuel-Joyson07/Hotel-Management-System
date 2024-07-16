// Using net.proteanit.sql of rs2xml Library to copy the DB values into the current window.



package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {
    Choice ch;
    JButton back,submit;
    JTable table;
    JComboBox bedType;
    JCheckBox available;
    Pickup() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,100,800,700);

        // Labels

        JLabel txt = new JLabel("Pickup Service");
        txt.setBounds(300,20,200,30);
        txt.setFont(new Font("Tahoma", Font.BOLD,25));
        txt.setForeground(Color.BLUE);
        add(txt);

        JLabel lb0 = new JLabel("Car Type : ");
        lb0.setFont(new Font("Tahoma", Font.BOLD,15));
        lb0.setBounds(100,80,90,25);
        add(lb0);

        ch = new Choice();
        ch.setBounds(200,83,150,25);
        ch.setFont(new Font("Tahoma", Font.BOLD,13));
        add(ch);

        try {
            Conn c = new Conn();
            String query = "Select * from driver";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                ch.add(rs.getString("car_model"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("Name");
        l1.setBounds(45,150,100,15);
        add(l1);

        JLabel l2 = new JLabel("Age ");
        l2.setBounds(140,150,100,15);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(230,150,100,15);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(320,150,100,15);
        add(l4);

        JLabel l5 = new JLabel("Available");
        l5.setBounds(410,150,100,15);
        add(l5);

        JLabel l6 = new JLabel("Location");
        l6.setBounds(510,150,100,15);
        add(l6);

        JLabel l7 = new JLabel("Phone");
        l7.setBounds(600,150,100,15);
        add(l7);

        JLabel l8 = new JLabel("Car_model");
        l8.setBounds(690,150,100,15);
        add(l8);

        table = new JTable();
        table.setBounds(20,170,750,400);
        add(table);

        try {
            Conn c = new Conn();
            String query = "select * from driver";
            ResultSet rs = c.s.executeQuery(query);

            // to copy the values from the DB to the window, we use a library
            // in that library,we import net.proteanit.sql
            // we use 'resultSettoTableModel method and pass rs object.

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        submit = new JButton("Find");
        submit.setFont(new Font("ariel", Font.BOLD,18));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(200,600,150,40);
        add(submit);

        back = new JButton("Back");
        back.setFont(new Font("ariel", Font.BOLD,18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(400,600,150,40);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Pickup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                String query1 = "select * from driver where car_model = '"+ch.getSelectedItem()+"'";
                Conn c = new Conn();
                ResultSet rs;

                    rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(e.getSource() == back) {
            setVisible(false);
            new Reception();

        }
    }
}
