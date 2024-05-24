package src.bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Login class represents the login interface for the Bank Management System.
 */
public class Login extends JFrame implements ActionListener {

    private JLabel labelWelcome, labelCardNo, labelPin;
    private JTextField textFieldCardNo;
    private JPasswordField passwordFieldPin;
    private JButton buttonSignIn, buttonClear, buttonSignUp;

    /**
     * Constructor initializes the login frame and its components.
     */
    public Login() {
        super("Bank Management System");
        initializeComponents();
        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        setUndecorated(true);
        setVisible(true);
    }

    /**
     * Initializes the components of the login frame.
     */
    private void initializeComponents() {
        // Adding Bank Logo
        ImageIcon bankIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image scaledBankIcon = bankIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel bankLogoLabel = new JLabel(new ImageIcon(scaledBankIcon));
        bankLogoLabel.setBounds(350, 10, 100, 100);
        add(bankLogoLabel);

        // Adding Card Image
        ImageIcon cardIcon = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image scaledCardIcon = cardIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel cardImageLabel = new JLabel(new ImageIcon(scaledCardIcon));
        cardImageLabel.setBounds(630, 350, 100, 100);
        add(cardImageLabel);

        // Welcome Label
        labelWelcome = new JLabel("WELCOME TO ATM");
        labelWelcome.setForeground(Color.WHITE);
        labelWelcome.setFont(new Font("AvantGarde", Font.BOLD, 38));
        labelWelcome.setBounds(230, 125, 450, 40);
        add(labelWelcome);

        // Card Number Label
        labelCardNo = new JLabel("Card No:");
        labelCardNo.setFont(new Font("Ralway", Font.BOLD, 28));
        labelCardNo.setForeground(Color.WHITE);
        labelCardNo.setBounds(150, 190, 375, 30);
        add(labelCardNo);

        // Card Number Text Field
        textFieldCardNo = new JTextField(15);
        textFieldCardNo.setBounds(325, 190, 230, 30);
        textFieldCardNo.setFont(new Font("Arial", Font.BOLD, 14));
        add(textFieldCardNo);

        // PIN Label
        labelPin = new JLabel("PIN: ");
        labelPin.setFont(new Font("Ralway", Font.BOLD, 28));
        labelPin.setForeground(Color.WHITE);
        labelPin.setBounds(150, 250, 375, 30);
        add(labelPin);

        // PIN Password Field
        passwordFieldPin = new JPasswordField(15);
        passwordFieldPin.setBounds(325, 250, 230, 30);
        passwordFieldPin.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordFieldPin);

        // Sign In Button
        buttonSignIn = new JButton("SIGN IN");
        buttonSignIn.setFont(new Font("Arial", Font.BOLD, 14));
        buttonSignIn.setForeground(Color.WHITE);
        buttonSignIn.setBackground(Color.BLACK);
        buttonSignIn.setBounds(300, 300, 100, 30);
        buttonSignIn.addActionListener(this);
        add(buttonSignIn);

        // Clear Button
        buttonClear = new JButton("CLEAR");
        buttonClear.setFont(new Font("Arial", Font.BOLD, 14));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setBackground(Color.BLACK);
        buttonClear.setBounds(430, 300, 100, 30);
        buttonClear.addActionListener(this);
        add(buttonClear);

        // Sign Up Button
        buttonSignUp = new JButton("SIGN UP");
        buttonSignUp.setFont(new Font("Arial", Font.BOLD, 14));
        buttonSignUp.setForeground(Color.WHITE);
        buttonSignUp.setBackground(Color.BLACK);
        buttonSignUp.setBounds(300, 350, 230, 30);
        buttonSignUp.addActionListener(this);
        add(buttonSignUp);

        // Background Image
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image scaledBackgroundIcon = backgroundIcon.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        JLabel backgroundImageLabel = new JLabel(new ImageIcon(scaledBackgroundIcon));
        backgroundImageLabel.setBounds(0, 0, 850, 480);
        add(backgroundImageLabel);
    }

    /**
     * Handles the action events for the buttons.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == buttonSignIn) {
                handleSignIn();
            } else if (e.getSource() == buttonClear) {
                handleClear();
            } else if (e.getSource() == buttonSignUp) {
                handleSignUp();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the sign-in action.
     *
     * @throws Exception if any SQL error occurs
     */
    private void handleSignIn() throws Exception {
        Connn conn = new Connn();
        String cardNo = textFieldCardNo.getText();
        String pin = new String(passwordFieldPin.getPassword());
        String query = "SELECT * FROM login WHERE card_number = '" + cardNo + "' AND pin = '" + pin + "'";
        ResultSet resultSet = conn.statement.executeQuery(query);

        if (resultSet.next()) {
            setVisible(false);
            new main_Class(pin);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
        }
    }

    /**
     * Handles the clear action.
     */
    private void handleClear() {
        textFieldCardNo.setText("");
        passwordFieldPin.setText("");
    }

    /**
     * Handles the sign-up action.
     */
    private void handleSignUp() {
        new Signup();
        setVisible(false);
    }

    /**
     * The main method to run the Login frame.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new Login();
    }
}
