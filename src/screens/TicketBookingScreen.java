package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TicketBookingScreen extends JFrame {
    private JTextField nameField, dobField, noOfPassengersField, totalAmountField, dodField;
    private JComboBox<String> sourceComboBox, destinationComboBox;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JLabel priceLabel;
    private int pricePerTicket = 100;  // Price per ticket for any route

    public TicketBookingScreen() {
        setTitle("Railway Ticket Management System - Book Ticket");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.YELLOW);

        JLabel titleLabel = new JLabel("Book a Ticket");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBounds(450, 50, 700, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.RED);
        add(titleLabel);

        // Passenger Name Label and TextField
        JLabel nameLabel = new JLabel("Passenger Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setBounds(400, 150, 250, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        nameField.setBounds(800, 150, 300, 30);
        add(nameField);

        // Gender Label and Radio Buttons
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        genderLabel.setBounds(400, 200, 150, 30);
        add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(new Font("Arial", Font.PLAIN, 18));
        maleRadioButton.setBounds(800, 200, 80, 30);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(new Font("Arial", Font.PLAIN, 18));
        femaleRadioButton.setBounds(990, 200, 100, 30);
        add(femaleRadioButton);

        // Group gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Date of Birth Label and TextField
        JLabel dobLabel = new JLabel("Date of Birth (DD-MM-YY):");
        dobLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dobLabel.setBounds(400, 250, 650, 30);
        add(dobLabel);

        dobField = new JTextField();
        dobField.setFont(new Font("Arial", Font.PLAIN, 18));
        dobField.setBounds(800, 250, 250, 30);
        add(dobField);

        // Source Label and ComboBox (Drop-down)
        JLabel sourceLabel = new JLabel("Source:");
        sourceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        sourceLabel.setBounds(400, 300, 150, 30);
        add(sourceLabel);

        String[] cities = {"Mumbai", "Delhi", "Kolkata", "Chennai", "Bangalore"};
        sourceComboBox = new JComboBox<>(cities);
        sourceComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        sourceComboBox.setBounds(800, 300, 300, 30);
        add(sourceComboBox);

        // Destination Label and ComboBox (Drop-down)
        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        destinationLabel.setBounds(400, 350, 150, 30);
        add(destinationLabel);

        destinationComboBox = new JComboBox<>(cities);
        destinationComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        destinationComboBox.setBounds(800, 350, 300, 30);
        add(destinationComboBox);

        // Date of Departure Label and TextField (Updated y positions)
        JLabel dodLabel = new JLabel("Date of Departure (DD-MM-YY):");
        dodLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dodLabel.setBounds(400, 400, 650, 30);  // Updated y position for DOD label
        add(dodLabel);

        dodField = new JTextField();
        dodField.setFont(new Font("Arial", Font.PLAIN, 18));
        dodField.setBounds(800, 400, 250, 30);  // Updated y position for DOD text field
        add(dodField);

// Number of Passengers Label and TextField (Updated y positions)
        JLabel passengersLabel = new JLabel("No. of Passengers:");
        passengersLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passengersLabel.setBounds(400, 450, 200, 30);  // Updated y position for Passengers label
        add(passengersLabel);

        noOfPassengersField = new JTextField();
        noOfPassengersField.setFont(new Font("Arial", Font.PLAIN, 18));
        noOfPassengersField.setBounds(800, 450, 100, 30);  // Updated y position for Passengers field
        add(noOfPassengersField);

// Price Label (Updated y position)
        priceLabel = new JLabel("Price per Ticket: 100");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        priceLabel.setBounds(400, 500, 250, 30);  // Updated y position for Price label
        add(priceLabel);

// Total Amount Label and TextField (Updated y position)
        JLabel totalAmountLabel = new JLabel("Total Amount:");
        totalAmountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        totalAmountLabel.setBounds(400, 550, 150, 30);  // Updated y position for Total Amount label
        add(totalAmountLabel);

        totalAmountField = new JTextField();
        totalAmountField.setFont(new Font("Arial", Font.PLAIN, 18));
        totalAmountField.setBounds(800, 550, 300, 30);  // Updated y position for Total Amount field
        totalAmountField.setEditable(false);
        add(totalAmountField);

// Book Ticket Button (Updated y position)
        JButton bookButton = new JButton("Book Ticket");
        bookButton.setFont(new Font("Arial", Font.BOLD, 18));
        bookButton.setBounds(600, 600, 150, 40);  // Updated y position for Book Ticket button
        bookButton.setBackground(Color.GREEN);
        add(bookButton);

// Logout Button (Updated y position)
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 18));
        logoutButton.setBounds(780, 600, 120, 40);  // Updated y position for Logout button
        logoutButton.setBackground(Color.GREEN);
        add(logoutButton);


        // DocumentListener to update total amount dynamically as the user types
        noOfPassengersField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTotalAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTotalAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTotalAmount();
            }
        });

        // Book Ticket Button Action
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passengerName = nameField.getText();
                String dob = dobField.getText();
                String source = (String) sourceComboBox.getSelectedItem();
                String destination = (String) destinationComboBox.getSelectedItem();
                String dod = dodField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                String noOfPassengers = noOfPassengersField.getText();

                if (passengerName.isEmpty() || dob.isEmpty() || dod.isEmpty() || source.isEmpty() || destination.isEmpty() || noOfPassengers.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (source.equals(destination)) {
                    JOptionPane.showMessageDialog(null, "Source and destination cannot be the same.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int passengers = Integer.parseInt(noOfPassengers);
                        // Calculate total amount based on number of passengers and price per ticket
                        int totalAmount = passengers * pricePerTicket;
                        totalAmountField.setText(String.valueOf(totalAmount));

                        // Show booking confirmation
                        JOptionPane.showMessageDialog(null, "Ticket Booked Successfully!\nPassenger: " + passengerName + "\nGender: " + gender + "\nDate of Birth: " + dob + "\nSource: " + source + "\nDestination: " + destination + "\nTotal Amount: " + totalAmount);

                        // Reset the fields after booking the ticket
                        resetFields();

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number of passengers.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Logout Button Action
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.setVisible(true);
            }
        });

        setVisible(true);
    }

    private void updateTotalAmount() {
        try {
            int passengers = Integer.parseInt(noOfPassengersField.getText());
            int totalAmount = passengers * pricePerTicket;
            totalAmountField.setText(String.valueOf(totalAmount));
        } catch (NumberFormatException ex) {
            totalAmountField.setText("");  // Clear the total if input is invalid
        }
    }

    private void resetFields() {
        nameField.setText("");
        dobField.setText("");
        dodField.setText("");
        noOfPassengersField.setText("");
        totalAmountField.setText("");
        sourceComboBox.setSelectedIndex(0); // Reset to default value
        destinationComboBox.setSelectedIndex(0); // Reset to default value
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicketBookingScreen ticketBookingScreen = new TicketBookingScreen();
            ticketBookingScreen.setVisible(true);
        });
    }
}
