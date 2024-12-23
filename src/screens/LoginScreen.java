package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        setTitle("Railway Ticket Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(Color.YELLOW);

        JLabel titleLabel = new JLabel("Railway Ticket Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBounds(450, 50, 700, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.RED);
        add(titleLabel);

        // Username Label and TextField
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLabel.setBounds(400, 200, 150, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameField.setBounds(600, 200, 300, 30);
        add(usernameField);

        // Password Label and PasswordField
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setBounds(400, 270, 150, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setBounds(600, 270, 300, 30);
        add(passwordField);

        // Login and Register Buttons
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBounds(600, 350, 120, 40);
        loginButton.setBackground(Color.GREEN);
        add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 18));
        registerButton.setBounds(780, 350, 120, 40);
        registerButton.setBackground(Color.GREEN);
        add(registerButton);

        // Login Button Action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Directly use the static authenticateUser method from UserManager
                if (UserManager.authenticateUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    dispose();
                    TicketBookingScreen ticketBookingScreen = new TicketBookingScreen();
                    ticketBookingScreen.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });

        // Register Button Action
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegistrationScreen registrationScreen = new RegistrationScreen();
                registrationScreen.setVisible(true);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginScreen login = new LoginScreen();
            login.setVisible(true);
        });
    }
}
