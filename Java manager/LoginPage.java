import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class LoginPage {
    private Manager manager;
    private JFrame loginFrame;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private Container c;

    public LoginPage(Manager manager) {
        this.manager = manager;
    }

    public void createLoginPage() {
        loginFrame = new JFrame("Manager LOGIN Page");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(800, 600);

        c = loginFrame.getContentPane();

        JLabel titleLabel = new JLabel("Welcome to SKYLINE AIRLINE ");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setBounds(50, 50, 500, 70);
        c.add(titleLabel);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setFont(new Font("Serif", Font.BOLD, 20));
        userIdLabel.setBounds(70, 150, 100, 30);
        c.add(userIdLabel);

        userIdField = new JTextField();
        userIdField.setBounds(160, 150, 200, 30);
        c.add(userIdField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 20));
        passwordLabel.setBounds(70, 200, 100, 30);
        c.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(160, 200, 200, 30);
        c.add(passwordField);

        

        

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Serif", Font.BOLD, 20));
        loginButton.setBounds(120, 300, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String password = new String(passwordField.getPassword());

                if (password.equals("Manager01")) {
                    manager.showSecondPage();
                    loginFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Sorry! Incorrect password, please try again.");
                }
            }
        });
        c.add(loginButton);


        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("LoginPage1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        loginFrame.getContentPane().add(image);

        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }
}