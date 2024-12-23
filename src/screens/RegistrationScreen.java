package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationScreen extends JFrame {
    private JTextField nameField, usernameField, mobileField;
    private JPasswordField passwordField;

    public RegistrationScreen() {
        setTitle("Railway Ticket Management System - Registration");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.YELLOW);

        JLabel titleLabel = new JLabel("Railway Ticket Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBounds(450, 50, 700, 50); // Adjust placement
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.RED);
        add(titleLabel);

        // Name Label and TextField
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setBounds(400, 200, 150, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        nameField.setBounds(600, 200, 300, 30);
        add(nameField);

        // Username Label and TextField
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLabel.setBounds(400, 270, 150, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameField.setBounds(600, 270, 300, 30);
        add(usernameField);

        // Mobile Label and TextField
        JLabel mobileLabel = new JLabel("Mobile:");
        mobileLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        mobileLabel.setBounds(400, 340, 150, 30);
        add(mobileLabel);

        mobileField = new JTextField();
        mobileField.setFont(new Font("Arial", Font.PLAIN, 18));
        mobileField.setBounds(600, 340, 300, 30);
        add(mobileField);

        // Password Label and PasswordField
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setBounds(400, 410, 150, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setBounds(600, 410, 300, 30);
        add(passwordField);

        // Register and Back Buttons
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 18));
        registerButton.setBounds(600, 490, 120, 40);
        registerButton.setBackground(Color.GREEN);
        add(registerButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds(780, 490, 120, 40);
        backButton.setBackground(Color.GREEN);
        add(backButton);

        // Register Button Action
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Use UserManager to register the user
                if (UserManager.registerUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "Registration Successful!");
                    dispose();
                    LoginScreen login = new LoginScreen();
                    login.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Username already exists!");
                }
            }
        });

        // Back Button Action
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginScreen login = new LoginScreen();
                login.setVisible(true);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationScreen register = new RegistrationScreen();
            register.setVisible(true);
        });
    }
}
