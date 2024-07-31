package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard() {
        setLayout(null);
        setBounds(0,0,1500,850);

        // scaling(cropping) and setting the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        // crop image
        Image i2 = i1.getImage().getScaledInstance(1500,850,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0,0,1500,850);
        add(image1);

        // header text
        JLabel text = new JLabel("ROYAL ORCHID WELCOMES YOU!!");
        text.setBounds(450,50,1200,90);
        //text.setForeground(new Color(255,219,88));       // this is yellow color
        text.setForeground(Color.black);
        text.setFont(new Font("serif",Font.BOLD,40));
        image1.add(text);


        // creating MenuBar
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1500,40);
        mb.setBackground(Color.white);
        image1.add(mb);

        // heading for the MenuBar
        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.RED);
        hotel.setFont(new Font("serif", Font.BOLD,20));
        mb.add(hotel);      // to be written over the MenuBar object - ab

        // adding MenuItems for hotel
        JMenuItem reception = new JMenuItem("Reception");
        hotel.add(reception);
        reception.addActionListener(this);

        JMenuItem logout = new JMenuItem("Logout");
        hotel.add(logout);
        logout.addActionListener(this);

        // heading for the MenuBar
        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.BLUE);
        admin.setFont(new Font("serif", Font.BOLD,20));
        mb.add(admin);

        // adding MenuItems for admin
        JMenuItem emp = new JMenuItem("Add Employee");
        admin.add(emp);
        emp.addActionListener(this);

        JMenuItem rooms = new JMenuItem("Add Rooms");
        rooms.addActionListener(this);
        admin.add(rooms);

        JMenuItem driver = new JMenuItem("Add Drivers");
        driver.addActionListener(this);
        admin.add(driver);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // use getActionCommand - it returns String
        if(e.getActionCommand().equals("Add Rooms"))
            new AddRooms();
        else if (e.getActionCommand().equals("Add Employee"))
            new AddEmployee();
        else if(e.getActionCommand().equals("Add Drivers"))
            new AddDriver();
        else if(e.getActionCommand().equals("Reception"))
            new Reception();
        else if(e.getActionCommand().equals("Logout")) {
            setVisible(false);
            System.exit(0);
        }


    }

    public static void main(String[] args) {
        new Dashboard();
    }


}
