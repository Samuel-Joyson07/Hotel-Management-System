package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class Checkout extends JFrame implements ActionListener {
    Date dt;
    JTextField tf1,tf2;
    Choice ch_cust;
    JButton checkout,back,find;
    Checkout() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Check-Out");
        text.setBounds(100,20,230,30);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        text.setForeground(Color.BLUE);
        add(text);

        JLabel id = new JLabel("Customer ID : ");
        id.setBounds(40,80,120,40);
        id.setFont(new Font("ariel", Font.BOLD,15));
        add(id);

        tf1 = new JTextField();
        tf1.setBounds(180,140,190,25);
        tf1.setFont(new Font("ariel", Font.BOLD,15));
        add(tf1);


        tf2 = new JTextField();
        tf2.setBounds(180,190,190,25);
        tf2.setFont(new Font("ariel", Font.BOLD,15));
        add(tf2);

        ch_cust = new Choice();
        ch_cust.setBounds(175,88,190,20);
        ch_cust.setFont(new Font("ariel", Font.PLAIN,20));
        add(ch_cust);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * FROM customer");
            while (rs.next()) {
                ch_cust.add(rs.getString("number"));
                tf1.setText(rs.getString("room"));
                tf2.setText(rs.getString("check_in_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i3 = image1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel image2 = new JLabel(i4);
        image2.setBounds(380,90,25,25);
        add(image2);

        JLabel number = new JLabel("Room Number : ");
        number.setBounds(40,130,180,40);
        number.setFont(new Font("ariel", Font.BOLD,15));
        add(number);

        JLabel check_in_time = new JLabel("Check-in Time : ");
        check_in_time.setBounds(40,180,240,40);
        check_in_time.setFont(new Font("ariel", Font.BOLD,15));
        add(check_in_time);


        JLabel check_out_time = new JLabel("Check-out Time : ");
        check_out_time.setBounds(40,230,180,40);
        check_out_time.setFont(new Font("ariel", Font.BOLD,15));
        add(check_out_time);

        dt = new Date();
        JLabel check_out_timeVal = new JLabel("" + dt);
        check_out_timeVal.setBounds(175,230,180,40);
        check_out_timeVal.setFont(new Font("ariel", Font.BOLD,15));
        add(check_out_timeVal);


        // IMAGE
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i1 = img.getImage().getScaledInstance(500,250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(430,70,350,250);
        add(image);




        // BUTTONS

        find  = new JButton("Find");
        find.setBounds(40,300,110,30);
        find.setBackground(Color.BLACK);
        find.setForeground(Color.WHITE);
        find.setFont(new Font("ariel", Font.PLAIN,15));
        find.addActionListener(this);
        add(find);

        // Button - Update
        checkout  = new JButton("Checkout");
        checkout.setBounds(160,300,110,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("ariel", Font.PLAIN,15));
        checkout.addActionListener(this);
        add(checkout);

        // Button - Back
        back  = new JButton("Back");
        back.setBounds(280,300,110,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("ariel", Font.PLAIN,15));
        back.addActionListener(this);
        add(back);


        setBounds(300,200,800,470);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {

            String query1 = "delete from customer where number = '"+ch_cust.getSelectedItem()+"'";
            String query2 = "update rooms set availability = 'Available' where roomNumber = '"+tf1.getText()+"'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Checkout Successful!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == back) {
            new Reception();
            setVisible(false);
        } else if(ae.getSource() == find) {
            String id = ch_cust.getSelectedItem();
            String query = "Select * FROM customer where number = '"+id+"'";
            try {
                Conn c = new Conn();
                ResultSet rs1 = c.s.executeQuery(query);
                while (rs1.next()) {
                    tf1.setText(rs1.getString("room"));  // Using "setText method"
                    tf2.setText(rs1.getString("check_in_time"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new Checkout();
    }

}
