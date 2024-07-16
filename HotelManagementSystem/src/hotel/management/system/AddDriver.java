package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener  {

    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JButton submit, cancel;
    JComboBox cb1,cb2;
    AddDriver() {    // constructor is called first


        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(200,120,1100,680);

        // Page Title heading
        JLabel head = new JLabel("Add Driver");
        head.setBounds(120,30,180,40);
        head.setFont(new Font("ariel", Font.BOLD,30));
        add(head);

        // LABELS
        // First label - Name
        JLabel name = new JLabel("Name : ");
        name.setBounds(40,120,240,40);
        name.setFont(new Font("ariel", Font.PLAIN,25));
        add(name);

        // Second label - Age
        JLabel age = new JLabel("Age : ");
        age.setBounds(40,170,180,40);
        age.setFont(new Font("ariel", Font.PLAIN,25));
        add(age);

        // Third label - Gender
        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(40,220,240,40);
        gender.setFont(new Font("ariel", Font.PLAIN,25));
        add(gender);

        // Fourth label - Car Company
        JLabel car_company = new JLabel("Car Company : ");
        car_company.setBounds(40,270,180,40);
        car_company.setFont(new Font("ariel", Font.PLAIN,25));
        add(car_company);

        // Fifth label - Car Model
        JLabel car_model = new JLabel("Car Model : ");
        car_model.setBounds(40,320,180,40);
        car_model.setFont(new Font("ariel", Font.PLAIN,25));
        add(car_model);

        // Sixth label - Available
        JLabel availability = new JLabel("Available : ");
        availability.setBounds(40,370,180,40);
        availability.setFont(new Font("ariel", Font.PLAIN,25));
        add(availability);

        // Seventh label - location
        JLabel location = new JLabel("Location : ");
        location.setBounds(40,420,180,40);
        location.setFont(new Font("ariel", Font.PLAIN,25));
        add(location);

        //  8th label - Phone
        JLabel phoneNo = new JLabel("Phone : ");
        phoneNo.setBounds(40,470,180,40);
        phoneNo.setFont(new Font("ariel", Font.PLAIN,25));
        add(phoneNo);

        // TEXT FIELDS
        // first - name
        tf1 = new JTextField();
        tf1.setBounds(250,125,145,30);
        tf1.setFont(new Font("ariel", Font.PLAIN,25));
        add(tf1);

        // second - age
        tf2 = new JTextField();
        tf2.setBounds(250,175,145,30);
        tf2.setFont(new Font("ariel", Font.PLAIN,25));
        add(tf2);

        // third - car_company
        tf3 = new JTextField();
        tf3.setBounds(250,275,145,30);
        tf3.setFont(new Font("ariel", Font.PLAIN,25));
        add(tf3);

        // fourth - car_model
        tf4 = new JTextField();
        tf4.setBounds(250,325,145,30);
        tf4.setFont(new Font("ariel", Font.PLAIN,25));
        add(tf4);

        // sixth - location
        tf5 = new JTextField();
        tf5.setBounds(250,425,145,30);
        tf5.setFont(new Font("ariel", Font.PLAIN,25));
        add(tf5);

        tf6 = new JTextField();
        tf6.setBounds(250,475,145,30);
        tf6.setFont(new Font("ariel", Font.PLAIN,25));
        add(tf6);

        // COMBO-BOX
        // combo box - available
        String[] str1 = {"Available","Not Available"};
        cb2 = new JComboBox(str1);
        cb2.setBounds(250,380,145,30);
        cb2.setFont(new Font("ariel", Font.PLAIN,25));
        add(cb2);

        // combo box - gender
        String[] str2 = {"Male","Female"};
        cb1 = new JComboBox(str2);
        cb1.setBounds(250,220,145,30);
        cb1.setFont(new Font("ariel", Font.PLAIN,25));
        add(cb1);

        // IMAGE
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i7 = img.getImage().getScaledInstance(600,450,Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel image = new JLabel(i8);
        image.setBounds(450,120,600,450);
        add(image);

        // BUTTONS
        // Button - Submit
        submit  = new JButton("Add Driver");
        submit.setBounds(40,545,175,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("ariel", Font.PLAIN,22));
        submit.addActionListener(this);
        add(submit);

        // Button - Cancel
        cancel  = new JButton("Cancel");
        cancel.setBounds(230,545,175,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("ariel", Font.PLAIN,22));
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddDriver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submit) {
            String name = tf1.getText();
            String age = tf2.getText();
            String gender = (String)cb1.getSelectedItem();
            String company = tf3.getText();
            String car_model = tf4.getText();
            String available = (String) cb2.getSelectedItem();
            String location = tf5.getText();
            String phone = tf6.getText();


            try {
                Conn c = new Conn();
                String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+available+"','"+location+"','"+phone+"','"+car_model+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Driver Added Successfully!!");
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
