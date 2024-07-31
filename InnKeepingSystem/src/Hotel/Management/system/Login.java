package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
        // making username and password public for use in other methods
        JTextField username, password;
        JButton login, cancel;
        Login() {
            getContentPane().setBackground(Color.WHITE);

            setLayout(null);      // setBounds will work only if setLayout() is null


            // username field
            JLabel user = new JLabel("Username : ");
            user.setBounds(70,80,150,30);
            user.setFont(new Font("serif",Font.BOLD,25));
            add(user);

            // text field for username
            username = new JTextField();
            username.setBounds(220,85,230,25);
            add(username);

            // password field
            JLabel pass = new JLabel("Password : ");
            pass.setBounds(70,130,150,30);
            pass.setFont(new Font("serif",Font.BOLD,25));
            add(pass);

            // text field for password
            password = new JTextField();
            password.setBounds(220,135,230,25);
            add(password);

            // Login button
            login = new JButton("Login");
            login.setBounds(70,200,180,30);
            login.setBackground(Color.BLACK);
            login.setForeground(Color.WHITE);
            login.addActionListener(this);
            add(login);

            // Cancel button
            cancel = new JButton("Cancel");
            cancel.setBounds(270,200,180,30);
            cancel.setBackground(Color.BLACK);
            cancel.setForeground(Color.WHITE);
            cancel.addActionListener(this);
            add(cancel);

            // adding image
            ImageIcon person = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
            // crop image
            Image i1 = person.getImage().getScaledInstance(190,190,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i1);
            JLabel label = new JLabel(i2);
            label.setBounds(500,50,190,190);
            add(label);


            setBounds(400,250,750,400);
            setVisible(true);
        }


        public void actionPerformed(ActionEvent ae) {
            // if login is pressed
            if(ae.getSource() == login) {
                    String getUser = username.getText(); // getting username
                    int getPass = Integer.parseInt(password.getText()); // get password and convert to int

                    try {
                        Conn c = new Conn();
                        // make sure that there is no space between the string for the query
                        String query = "select * from login where username = '" + getUser + "' and password =  '" + getPass + "'; ";
                        ResultSet rs = c.s.executeQuery(query);
                        // if there is a result
                        if(rs.next())
                            new Dashboard();
                        else{
                            JOptionPane.showMessageDialog(null,"Invalid username or password");
                            setVisible(false);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
            // if cancel is pressed
            else if(ae.getSource() == cancel) {
                setVisible(false);
                new HotelManagementSystem();
            }

        }


    public static void main(String[] args) {
        new Login();
    }
}
