/**
 * It specifies the package to which the current Java file belongs.
 */
package src.bank.management.system;

/**
 * Importing Swing library for GUI components.
 * Importing AWT library for basic GUI functionality.
 * Importing ActionEvent class for handling GUI events.
 * Importing ActionListener interface for listening to GUI events.
 * Importing Date class for working with dates
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * The Deposit class allows users to deposit money into their bank account.
 */
public class Deposit extends JFrame implements ActionListener {
    private String pin;
    private TextField textField;

    private JButton depositButton, backButton;

    /**
     * Constructs a Deposit window with the given user PIN.
     *
     * @param pin the user's PIN
     */
    public Deposit(String pin) {
        this.pin = pin;

        // Set up the main background image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image scaledImage = icon.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 1550, 830);
        add(backgroundLabel);

        // Set up the instruction label
        JLabel instructionLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setFont(new Font("System", Font.BOLD, 16));
        instructionLabel.setBounds(460, 180, 400, 35);
        backgroundLabel.add(instructionLabel);

        // Set up the text field for amount input
        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 230, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        backgroundLabel.add(textField);

        // Set up the deposit button
        depositButton = new JButton("DEPOSIT");
        depositButton.setBounds(700, 362, 150, 35);
        depositButton.setBackground(new Color(65, 125, 128));
        depositButton.setForeground(Color.WHITE);
        depositButton.addActionListener(this);
        backgroundLabel.add(depositButton);

        // Set up the back button
        backButton = new JButton("BACK");
        backButton.setBounds(700, 406, 150, 35);
        backButton.setBackground(new Color(65, 125, 128));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        backgroundLabel.add(backButton);

        // Set up the JFrame properties
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }
    
    
    /**
     * Handles the actions performed by the user.
     *
     * @param e ActionEvent triggered by user actions.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();

            if (e.getSource() == depositButton) {
                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit.");
                } else {
                    Connn conn = new Connn();
                    conn.statement.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " deposited successfully.");
                    setVisible(false);
                    new main_Class(pin);
                }
            } else if (e.getSource() == backButton) {
                setVisible(false);
                new main_Class(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * The main method to launch the Deposit window.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        new Deposit("");
    }
}
