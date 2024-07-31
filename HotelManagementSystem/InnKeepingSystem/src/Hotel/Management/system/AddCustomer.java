package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tf1,tf2,tf3,tf4;
    JRadioButton rb1,rb2;
    JComboBox cb1;
    Choice ch1;
    JButton submit,back;
    Date d;
    AddCustomer() {

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(200,120,1100,680);

        // Page Title heading
        JLabel head = new JLabel("New Customer Form");
        head.setBounds(80,20,280,40);
        head.setFont(new Font("ariel", Font.BOLD,26));
        add(head);

        // LABELS
        // First label - ID
        JLabel id = new JLabel("ID : ");
        id.setBounds(40,100,240,40);
        id.setFont(new Font("ariel", Font.PLAIN,25));
        add(id);

        // Second label - Number
        JLabel number = new JLabel("Number : ");
        number.setBounds(40,160,180,40);
        number.setFont(new Font("ariel", Font.PLAIN,25));
        add(number);

        // Third label - Name
        JLabel name = new JLabel("Name : ");
        name.setBounds(40,220,240,40);
        name.setFont(new Font("ariel", Font.PLAIN,25));
        add(name);

        // Fourth label - Gender
        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(40,280,180,40);
        gender.setFont(new Font("ariel", Font.PLAIN,25));
        add(gender);

        // Fifth label - Country
        JLabel country = new JLabel("Country : ");
        country.setBounds(40,340,180,40);
        country.setFont(new Font("ariel", Font.PLAIN,25));
        add(country);

        // Sixth label - Allocated Room Number
        JLabel alloc_room = new JLabel("Allocated Room No : ");
        alloc_room.setBounds(40,400,240,40);
        alloc_room.setFont(new Font("ariel", Font.PLAIN,25));
        add(alloc_room);

        // 7th label - Check-in Time
        JLabel check_in_time = new JLabel("Check-in Time : ");
        check_in_time.setBounds(40,460,180,40);
        check_in_time.setFont(new Font("ariel", Font.PLAIN,25));
        add(check_in_time);

        // check in time
        d = new Date();
        JLabel date = new JLabel("" + d);   // use this trick to convert to String
        date.setBounds(300,465,210,30);
        date.setFont(new Font("ariel", Font.BOLD,13));
        add(date);

        // 8th label - Deposit
        JLabel deposit = new JLabel("Deposit : ");
        deposit.setBounds(40,520,180,40);
        deposit.setFont(new Font("ariel", Font.PLAIN,25));
        add(deposit);

        // IMAGE
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/cust.jpg"));
        Image i1 = img.getImage().getScaledInstance(450,400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(550,95,450,450);
        add(image);

        // BUTTONS
        // Button - Submit
        submit  = new JButton("Add Customer");
        submit.setBounds(40,585,190,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("ariel", Font.PLAIN,22));
        submit.addActionListener(this);
        add(submit);

        // Button - Back
        back  = new JButton("Back");
        back.setBounds(245,585,190,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("ariel", Font.PLAIN,22));
        back.addActionListener(this);
        add(back);

        // Input Fields
        // ID
        String[] options = {"Passport","Aadhaar Card","Driving Licence","Voter-ID card","Ration Card"};
        cb1 = new JComboBox(options);
        cb1.setBounds(300,100,190,30);
        cb1.setFont(new Font("ariel", Font.PLAIN,20));
        add(cb1);

        // number
        tf1 = new JTextField();
        tf1.setBounds(300,165,190,30);
        tf1.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf1);

        // name
        tf2 = new JTextField();
        tf2.setBounds(300,225,190,30);
        tf2.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf2);

        // country
        tf3 = new JTextField();
        tf3.setBounds(300,345,190,30);
        tf3.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf3);

        // deposit
        tf4 = new JTextField();
        tf4.setBounds(300,525,190,30);
        tf4.setFont(new Font("ariel", Font.PLAIN,20));
        add(tf4);

        // gender
        rb1 = new JRadioButton("Male");
        rb1.setBounds(300,280,80,30);
        rb1.setFont(new Font("ariel", Font.PLAIN,20));
        rb1.setBackground(Color.WHITE);
        add(rb1);

        rb2 = new JRadioButton("Female");
        rb2.setBounds(390,280,100,30);
        rb2.setFont(new Font("ariel", Font.PLAIN,20));
        rb2.setBackground(Color.WHITE);
        add(rb2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        setVisible(true);

        ch1 = new Choice();
        ch1.setBounds(300,400,190,30);
        ch1.setFont(new Font("ariel", Font.PLAIN,20));
        add(ch1);

        try {
            Conn c = new Conn();
            String query = "select * from rooms where availability = 'available'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                ch1.add(rs.getString("roomNumber"));
                    // this is the adv of Choice method
                    // we can add values dynamically unlike JComboBox
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == submit) {

            String id = (String) cb1.getSelectedItem();
            String num = tf1.getText();
            String name = tf2.getText();
            String gen = null;
            if(rb1.isSelected())
                gen = "Male";
            else
                gen = "Female";
            String country = tf3.getText();
            String Allocated_room = (String) ch1.getSelectedItem();
            String time = "" + d;
            String deposit = tf4.getText();
            //JOptionPane.showMessageDialog(null,"New Customer Added Successfully!!");

            try {
                String query = "insert into customer values('"+id+"','"+num+"','"+name+"','"+gen+"','"+country+"','"+Allocated_room+"','"+time+"','"+deposit+"')";
                String query1 = "update rooms set availability = 'Occupied' where roomNumber = '"+Allocated_room+"'";

                Conn conn = new Conn();

                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null,"New Customer Added Successfully!!");
                setVisible(false);
                new Reception();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getActionCommand().equals("Back")) {
            setVisible(false);
            new Reception();
        }


    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}

