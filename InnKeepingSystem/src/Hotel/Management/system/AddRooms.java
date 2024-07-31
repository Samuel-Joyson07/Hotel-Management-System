package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JTextField tf1,tf2;
    JButton submit, cancel;
    JComboBox cb1,cb2,cb3;
    AddRooms() {    // constructor is called first


        setLayout(null);
        setBounds(300,170,950,600);
        getContentPane().setBackground(Color.white);

        // Page Title heading
        JLabel head = new JLabel("Add Rooms");
        head.setBounds(120,30,180,40);
        head.setFont(new Font("ariel", Font.BOLD,30));
        add(head);

        // LABELS
        // First label - Room Number
        JLabel roomNo = new JLabel("Room Number : ");
        roomNo.setBounds(40,120,240,40);
        roomNo.setFont(new Font("ariel", Font.PLAIN,25));
        add(roomNo);

        // Second label - Room_Status
        JLabel room_status = new JLabel("Available : ");
        room_status.setBounds(40,180,180,40);
        room_status.setFont(new Font("ariel", Font.PLAIN,25));
        add(room_status);

        // Third label - cleaning_status
        JLabel cleaning_status = new JLabel("Cleaning Status : ");
        cleaning_status.setBounds(40,240,240,40);
        cleaning_status.setFont(new Font("ariel", Font.PLAIN,25));
        add(cleaning_status);

        // Fourth label - price
        JLabel price = new JLabel("Price : ");
        price.setBounds(40,300,180,40);
        price.setFont(new Font("ariel", Font.PLAIN,25));
        add(price);

        // Fifth label - BedType
        JLabel bedType = new JLabel("Bed Type : ");
        bedType.setBounds(40,360,180,40);
        bedType.setFont(new Font("ariel", Font.PLAIN,25));
        add(bedType);


        // TEXT FIELDS
        // first - room No
        tf1 = new JTextField();
        tf1.setBounds(250,125,145,30);
        tf1.setFont(new Font("ariel", Font.PLAIN,25));
        add(tf1);

        // second - price
        tf2 = new JTextField();
        tf2.setBounds(250,305,145,30);
        tf2.setFont(new Font("ariel", Font.PLAIN,25));
        add(tf2);

        // COMBO-BOX
        // combo box - room status
        String[] str1 = {"Available","Occupied"};
        cb1 = new JComboBox(str1);
        cb1.setBounds(250,185,145,30);
        cb1.setFont(new Font("ariel", Font.PLAIN,25));
        add(cb1);

        // combo box - cleaning status
        String[] str2 = {"Cleaned","Dirty"};
        cb2 = new JComboBox(str2);
        cb2.setBounds(250,245,145,30);
        cb2.setFont(new Font("ariel", Font.PLAIN,25));
        add(cb2);

        // combo box - bed type
        String[] str3 = {"Single Bed","Double Bed"};
        cb3 = new JComboBox(str3);
        cb3.setBounds(250,365,150,35);
        cb3.setFont(new Font("ariel", Font.PLAIN,22));
        add(cb3);

        // IMAGE
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i7 = img.getImage().getScaledInstance(550,550,Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel image = new JLabel(i8);
        image.setBounds(450,70,450,420);
        add(image);

        // BUTTONS
        // Button - Submit
        submit  = new JButton("Add Room");
        submit.setBounds(40,445,175,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("ariel", Font.PLAIN,22));
        submit.addActionListener(this);
        add(submit);

        // Button - Cancel
        cancel  = new JButton("Cancel");
        cancel.setBounds(230,445,175,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("ariel", Font.PLAIN,22));
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submit) {
            String room_details = tf1.getText();
            String cost_details = tf2.getText();
            String availableOption = (String)cb1.getSelectedItem();
            String cleanOption = (String) cb2.getSelectedItem();
            String bedTypeOption = (String) cb3.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "insert into rooms values('"+room_details+"','"+availableOption+"','"+cleanOption+"','"+cost_details+"','"+bedTypeOption+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Room Added Successfully!!");
                setVisible(false);
            }
            catch (Exception ae) {
                ae.printStackTrace();
            }

        }
        else if(e.getSource() == cancel){
            setVisible(false);
        }


    }
}
