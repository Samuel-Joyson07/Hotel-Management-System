// If you want to update your name, roomNo, checkin time, deposit amount, etc.


package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Room_Status extends JFrame implements ActionListener {
    Choice room;
    JTextField tf2,tf3,tf4,tf5;
    JButton check,back,update;
    Update_Room_Status() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setBounds(100,20,230,30);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        text.setForeground(Color.BLUE);
        add(text);

        // LABELS

        JLabel id = new JLabel("Room Number : ");
        id.setBounds(40,80,120,40);
        id.setFont(new Font("ariel", Font.PLAIN,15));
        add(id);

        JLabel number = new JLabel("Availability : ");
        number.setBounds(40,130,180,40);
        number.setFont(new Font("ariel", Font.PLAIN,15));
        add(number);

        JLabel availability = new JLabel("Cleaning Status : ");
        availability.setBounds(40,180,240,40);
        availability.setFont(new Font("ariel", Font.PLAIN,15));
        add(availability);

        JLabel cleanst = new JLabel("Price : ");
        cleanst.setBounds(40,230,180,40);
        cleanst.setFont(new Font("ariel", Font.PLAIN,15));
        add(cleanst);

        JLabel bed = new JLabel("Bed Type : ");
        bed.setBounds(40,280,180,40);
        bed.setFont(new Font("ariel", Font.PLAIN,15));
        add(bed);

        // Text Fields, Choice, etc

        room = new Choice();
        room.setBounds(180,88,190,20);
        room.setFont(new Font("ariel", Font.PLAIN,20));
        add(room);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * FROM rooms");
            while (rs.next()) {
                room.add(rs.getString("roomNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        tf2 = new JTextField();
        tf2.setBounds(180,140,190,25);
        tf2.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf2);


        tf3 = new JTextField();
        tf3.setBounds(180,190,190,25);
        tf3.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf3);

        tf4 = new JTextField();
        tf4.setBounds(180,240,190,25);
        tf4.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf4);

        tf5 = new JTextField();
        tf5.setBounds(180,290,190,25);
        tf5.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf5);

        // IMAGE
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i1 = img.getImage().getScaledInstance(500,250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(410,70,350,250);
        add(image);

        // BUTTONS
        // Button - Check
        check  = new JButton("Check");
        check.setBounds(40,340,110,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("ariel", Font.PLAIN,15));
        check.addActionListener(this);
        add(check);

        // Button - Update
        update  = new JButton("Update");
        update.setBounds(160,340,110,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("ariel", Font.PLAIN,15));
        update.addActionListener(this);
        add(update);

        // Button - Back
        back  = new JButton("Back");
        back.setBounds(280,340,110,30);
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
            try {
                Conn c = new Conn();
                ResultSet rs2 = c.s.executeQuery("Select * FROM rooms where roomNumber = '"+room.getSelectedItem()+"'");
                while (rs2.next()) {
                    tf2.setText(rs2.getString("availability"));
                    tf3.setText(rs2.getString("cleaningStatus"));
                    tf4.setText(rs2.getString("price"));
                    tf5.setText(rs2.getString("BedType"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            String roomNo = room.getSelectedItem();
            Conn c = new Conn();
            try {
                c.s.executeUpdate("update rooms set availability = '"+tf2.getText()+"',cleaningStatus = '"+tf3.getText()+"',price = '"+tf4.getText()+"',bedType = '"+tf5.getText()+"' where roomNumber = '"+roomNo+"'");
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
        new Update_Room_Status();
    }
}
