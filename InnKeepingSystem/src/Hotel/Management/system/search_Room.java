// Using net.proteanit.sql of rs2xml Library to copy the DB values into the current window.



package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class search_Room extends JFrame implements ActionListener {
    JButton back,submit;
    JTable table;
    JComboBox bedType;
    JCheckBox available;
    search_Room() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,100,800,700);

        // Labels

        JLabel txt = new JLabel("Search Room");
        txt.setBounds(300,20,200,20);
        txt.setFont(new Font("Tahoma", Font.BOLD,20));
        add(txt);

        JLabel lb0 = new JLabel("Bed Type : ");
        lb0.setFont(new Font("Tahoma", Font.BOLD,15));
        lb0.setBounds(115,80,100,20);
        add(lb0);

        bedType = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(200,80,150,25);
        bedType.setFont(new Font("Tahoma", Font.BOLD,13));
        add(bedType);

        available = new JCheckBox("Available");
        available.setBounds(500,80,150,25);
        available.setFont(new Font("Tahoma", Font.BOLD,17));
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(85,150,100,15);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(220,150,100,15);
        add(l2);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(350,150,100,15);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(500,150,100,15);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(620,150,100,15);
        add(l5);

        table = new JTable();
        table.setBounds(65,170,650,400);
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
        new search_Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                String query1 = "select * from rooms where bedType = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from rooms where bedType = '"+bedType.getSelectedItem()+"' AND availability = 'Available'";

                Conn c = new Conn();
                ResultSet rs;

                if(available.isSelected()) {
                    rs = c.s.executeQuery(query2);
                } else {
                    rs = c.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(e.getSource() == back) {
            new Reception();
            setVisible(false);
        }
    }
}
