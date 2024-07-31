// If you want to update your name, roomNo, checkin time, deposit amount, etc.


package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Status extends JFrame implements ActionListener {
    Choice ch_cust;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JButton check,back,update;
    Update_Status() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setBounds(140,20,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        text.setForeground(Color.BLUE);
        add(text);

        // LABELS

        JLabel id = new JLabel("Customer ID : ");
        id.setBounds(40,80,100,40);
        id.setFont(new Font("ariel", Font.PLAIN,15));
        add(id);

        JLabel number = new JLabel("Room Number : ");
        number.setBounds(40,120,180,40);
        number.setFont(new Font("ariel", Font.PLAIN,15));
        add(number);

        JLabel name = new JLabel("Name : ");
        name.setBounds(40,160,240,40);
        name.setFont(new Font("ariel", Font.PLAIN,15));
        add(name);

        JLabel checkin = new JLabel("Check-in Time : ");
        checkin.setBounds(40,200,180,40);
        checkin.setFont(new Font("ariel", Font.PLAIN,15));
        add(checkin);

        JLabel paid = new JLabel("Amount Paid : ");
        paid.setBounds(40,240,180,40);
        paid.setFont(new Font("ariel", Font.PLAIN,15));
        add(paid);

        JLabel pending = new JLabel("Pending Amount : ");
        pending.setBounds(40,280,240,40);
        pending.setFont(new Font("ariel", Font.PLAIN,15));
        add(pending);

        // Text Fields, Choice, etc

        ch_cust = new Choice();
        ch_cust.setBounds(180,88,190,20);
        ch_cust.setFont(new Font("ariel", Font.PLAIN,20));
        add(ch_cust);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * FROM customer");
            while (rs.next()) {
                ch_cust.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        tf2 = new JTextField();
        tf2.setBounds(180,130,190,25);
        tf2.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf2);


        tf3 = new JTextField();
        tf3.setBounds(180,170,190,25);
        tf3.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf3);

        tf4 = new JTextField();
        tf4.setBounds(180,210,190,25);
        tf4.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf4);

        tf5 = new JTextField();
        tf5.setBounds(180,250,190,25);
        tf5.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf5);

        tf6 = new JTextField();
        tf6.setBounds(180,290,190,25);
        tf6.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf6);

        // IMAGE
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i1 = img.getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(410,70,350,250);
        add(image);

        // BUTTONS
        // Button - Check
        check  = new JButton("Check");
        check.setBounds(40,345,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("ariel", Font.PLAIN,15));
        check.addActionListener(this);
        add(check);

        // Button - Update
        update  = new JButton("Update");
        update.setBounds(170,345,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("ariel", Font.PLAIN,15));
        update.addActionListener(this);
        add(update);

        // Button - Back
        back  = new JButton("Back");
        back.setBounds(300,345,120,30);
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

        if(ae.getSource() == check) {
            String id = ch_cust.getSelectedItem();
            String query = "Select * FROM customer where number = '"+id+"'";
            try {
                Conn c = new Conn();
                ResultSet rs1 = c.s.executeQuery(query);
                while (rs1.next()) {
                    tf2.setText(rs1.getString("room"));  // Using "setText method"
                    tf3.setText(rs1.getString("name"));
                    tf4.setText(rs1.getString("check_in_time"));
                    tf5.setText(rs1.getString("deposit"));
                }

                ResultSet rs2 = c.s.executeQuery("Select * FROM rooms where roomNumber = '"+tf2.getText()+"'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int remAmt = Integer.parseInt(price) - Integer.parseInt(tf5.getText());
                    tf6.setText("" + remAmt);       // REMEMBER this trick
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            String id = ch_cust.getSelectedItem();
            Conn c = new Conn();
            try {
                c.s.executeUpdate("update customer set room = '"+tf2.getText()+"',name = '"+tf3.getText()+"',check_in_time = '"+tf4.getText()+"',deposit = '"+tf5.getText()+"' where number = '"+id+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully!!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if(ae.getSource() == back) {
            new Reception();
            setVisible(false);
        }
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Update_Status();
    }
}
