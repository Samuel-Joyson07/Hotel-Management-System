package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener  {

    JTextField name1, age1, salary1, phone1, email1, aadhaar1;
    JComboBox jobs;
    JRadioButton gender_male, gender_female;
    JButton submit,cancel;
    AddEmployee() {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,170,950,600);

        JLabel head = new JLabel();

        //Labels & TextFields for name, age, gender, job, salary, phone, email, aadhar

        // NAME
        JLabel name = new JLabel("Name : ");
        name.setBounds(40,40,150,40);
        name.setFont(new Font("serif", Font.BOLD,25));
        add(name);

        name1 = new JTextField();
        name1.setBounds(200,50,145,30);
        name1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(name1);

        //AGE
        JLabel age = new JLabel("Age : ");
        age.setBounds(40,90,150,40);
        age.setFont(new Font("serif", Font.BOLD,25));
        add(age);

        age1 = new JTextField();
        age1.setBounds(200,100,145,30);
        age1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(age1);

        //GENDER (radio buttons)
        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(40,140,150,40);
        gender.setFont(new Font("serif", Font.BOLD,25));
        add(gender);

        gender_male = new JRadioButton("Male");
        gender_male.setBounds(200,140,80,40);
        gender_male.setFont(new Font("Tahoma", Font.PLAIN,14));
        gender_male.setBackground(Color.WHITE);
        add(gender_male);
        gender_female = new JRadioButton("Female");
        gender_female.setBounds(280,140,90,40);
        gender_female.setFont(new Font("Tahoma", Font.PLAIN,14));
        gender_female.setBackground(Color.WHITE);
        add(gender_female);

        // grouping
        ButtonGroup bg = new ButtonGroup();
        bg.add(gender_male);
        bg.add(gender_female);


        //JOB (ComboBox)
        JLabel job = new JLabel("Job : ");
        job.setBounds(40,190,100,40);
        job.setFont(new Font("serif", Font.BOLD,25));
        add(job);

        String[] roles = {"Front Desk Clerk","Porter","Housekeeper","Kitchen staff","Room Service","Chef","Waiter/Waitress","Manager","Accountant"};
        jobs = new JComboBox((roles));
        jobs.setBounds(200,200,145,30);
        jobs.setBackground(Color.WHITE);
        add(jobs);


        // SALARY
        JLabel salary = new JLabel("Salary : ");
        salary.setBounds(40,240,100,40);
        salary.setFont(new Font("serif", Font.BOLD,25));
        add(salary);

        salary1 = new JTextField();
        salary1.setBounds(200,250,145,30);
        salary1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(salary1);

        // EMAIL
        JLabel email = new JLabel("Email : ");
        email.setBounds(40,290,100,40);
        email.setFont(new Font("serif", Font.BOLD,25));
        add(email);

        email1 = new JTextField();
        email1.setBounds(200,300,145,30);
        email1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(email1);

        // PHONE
        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(40,340,100,40);
        phone.setFont(new Font("serif", Font.BOLD,25));
        add(phone);

        phone1 = new JTextField();
        phone1.setBounds(200,350,145,30);
        phone1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(phone1);

        // AADHAAR
        JLabel aadhaar = new JLabel("Aadhar No : ");
        aadhaar.setBounds(40,390,145,40);
        aadhaar.setFont(new Font("serif", Font.BOLD,25));
        add(aadhaar);

        aadhaar1 = new JTextField();
        aadhaar1.setBounds(200,400,145,30);
        aadhaar1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(aadhaar1);


        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i6 = i5.getImage().getScaledInstance(550,550,Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel image = new JLabel(i7);
        image.setBounds(380,70,550,420);
        add(image);

        submit  = new JButton("Submit");
        submit.setBounds(40,460,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("ariel", Font.PLAIN,20));
        submit.addActionListener(this);
        add(submit);

        // Button - Cancel
        cancel  = new JButton("Cancel");
        cancel.setBounds(200,460,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("ariel", Font.PLAIN,20));
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submit){
            //name, age, gender, job, salary, phone, email, aadhar
            String get_name = name1.getText();
            String get_age = age1.getText();
            String get_salary = salary1.getText();
            String get_phone = phone1.getText();
            String get_email = email1.getText();
            String get_aadhaar = aadhaar1.getText();
            String get_gender = null;

            if(gender_male.isSelected()) {
                get_gender = "Male";
            }
            else if(gender_female.isSelected()) {
                get_gender = "Female";
            }


            String get_Job = (String)jobs.getSelectedItem();     // converting from Object type to String
            //if(get_name.equals(" ") &&  )
                //JOptionPane.showMessageDialog(null,"Name cannot be empty");

            //else {
                // always use try catch block to work with databases
                try {
                    Conn c = new Conn();
                    String query = "insert into employees values('" + get_name + "','" + get_age + "','" + get_gender + "','" + get_Job + "','" + get_salary + "','" + get_phone + "','" + get_email + "','" + get_aadhaar + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                    setVisible(false);
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            //}
        }
        else if(e.getSource() == cancel){
            setVisible(false);
        }



    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}


