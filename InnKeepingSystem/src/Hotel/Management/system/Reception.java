package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    Reception() {
        setLayout(null);
        setBounds(200,120,1100,680);

        // LABELS
        // Label 1
        JButton new_customer_form = new JButton("New Customer Form");
        new_customer_form.setBounds(40,30,260,40);
        new_customer_form.setBackground(Color.BLACK);
        new_customer_form.setForeground(Color.WHITE);
        new_customer_form.setFont(new Font("ariel", Font.BOLD,17));
        new_customer_form.addActionListener(this);
        add(new_customer_form);

        // 2nd label - Rooms
        JButton rooms = new JButton("Rooms");
        rooms.setBounds(40,80,260,40);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setFont(new Font("ariel", Font.BOLD,17));
        rooms.addActionListener(this);
        add(rooms);

        // 3rd label - Department
        JButton dept = new JButton("Department");
        dept.setBounds(40,130,260,40);
        dept.setBackground(Color.BLACK);
        dept.setForeground(Color.WHITE);
        dept.setFont(new Font("ariel", Font.BOLD,17));
        dept.addActionListener(this);
        add(dept);

        // 4th label - All Employees
        JButton empl = new JButton("All Employees");
        empl.setBounds(40,180,260,40);
        empl.setBackground(Color.BLACK);
        empl.setForeground(Color.WHITE);
        empl.setFont(new Font("ariel", Font.BOLD,17));
        empl.addActionListener(this);
        add(empl);

        // 5th label - Customer Info
        JButton cust_info = new JButton("Customer Info");
        cust_info.setBounds(40,230,260,40);
        cust_info.setBackground(Color.BLACK);
        cust_info.setForeground(Color.WHITE);
        cust_info.setFont(new Font("ariel", Font.BOLD,17));
        cust_info.addActionListener(this);
        add(cust_info);

        // 6th label - Manager Info
        JButton mgr_info = new JButton("Manager Info");
        mgr_info.setBounds(40,280,260,40);
        mgr_info.setBackground(Color.BLACK);
        mgr_info.setForeground(Color.WHITE);
        mgr_info.setFont(new Font("ariel", Font.BOLD,17));
        mgr_info.addActionListener(this);
        add(mgr_info);

        // 7th label - Checkout
        JButton checkout = new JButton("Checkout");
        checkout.setBounds(40,330,260,40);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("ariel", Font.BOLD,17));
        checkout.addActionListener(this);
        add(checkout);

        // 8th label - Update Status
        JButton update_status = new JButton("Update Status");
        update_status.setBounds(40,380,260,40);
        update_status.setBackground(Color.BLACK);
        update_status.setForeground(Color.WHITE);
        update_status.setFont(new Font("ariel", Font.BOLD,17));
        update_status.addActionListener(this);
        add(update_status);

        // 9th label - Update Room Status
        JButton update_room_status = new JButton("Update Room Status");
        update_room_status.setBounds(40,430,260,40);
        update_room_status.setBackground(Color.BLACK);
        update_room_status.setForeground(Color.WHITE);
        update_room_status.setFont(new Font("ariel", Font.BOLD,17));
        update_room_status.addActionListener(this);
        add(update_room_status);

        // 10th label - Pickup Service
        JButton pickup_service = new JButton("Pickup Service");
        pickup_service.setBounds(40,480,260,40);
        pickup_service.setBackground(Color.BLACK);
        pickup_service.setForeground(Color.WHITE);
        pickup_service.setFont(new Font("ariel", Font.BOLD,17));
        pickup_service.addActionListener(this);
        add(pickup_service);

        // 11th label - Search Room
        JButton search_room = new JButton("Search Room");
        search_room.setBounds(40,530,260,40);
        search_room.setBackground(Color.BLACK);
        search_room.setForeground(Color.WHITE);
        search_room.setFont(new Font("ariel", Font.BOLD,17));
        search_room.addActionListener(this);
        add(search_room);

        // 12th label - Logout
        JButton logout = new JButton("Go to Dashboard");
        logout.setBounds(40,580,260,40);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("ariel", Font.BOLD,17));
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(670,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360,70,670,500);
        add(image);


        setVisible(true);
    }




    public static void main(String[] args) {
        Reception reception = new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("New Customer Form")) {
            setVisible(false);
            new AddCustomer();
        } else if (e.getActionCommand().equals("Rooms")) {
            setVisible(false);
            new Room();
        } else if (e.getActionCommand().equals("Department")) {
            setVisible(false);
            new Department();
        } else if (e.getActionCommand().equals("All Employees")) {
            setVisible(false);
            new All_Employees();
        } else if (e.getActionCommand().equals("Customer Info")) {
            setVisible(false);
            new Customer_Info();
        } else if (e.getActionCommand().equals("Manager Info")) {
            setVisible(false);
            new Manager_Info();
        } else if (e.getActionCommand().equals("Search Room")) {
            setVisible(false);
            new search_Room();
        } else if (e.getActionCommand().equals("Update Status")) {
            setVisible(false);
            new Update_Status();
        } else if (e.getActionCommand().equals("Update Room Status")) {
            setVisible(false);
            new Update_Room_Status();
        } else if (e.getActionCommand().equals("Pickup Service")) {
            setVisible(false);
            new Pickup();
        } else if (e.getActionCommand().equals("Checkout")) {
            setVisible(false);
            new Checkout();
        } else if (e.getActionCommand().equals("Go to Dashboard")) {
            setVisible(false);
        }
    }
}
