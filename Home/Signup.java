package src.bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Signup class represents the signup form for the Bank Management System.
 */
public class Signup extends JFrame implements ActionListener {

    private JRadioButton r1, r2, m1, m2, m3;
    private JButton next;
    private JTextField textName, textFname, textEmail, textAdd, textCity, textState, textPin;
    private JDateChooser dateChooser;
    private final String formNumber;

    /**
     * Constructor initializes the signup form and its components.
     */
    public Signup() {
        super("APPLICATION FORM");

        Random random = new Random();
        long first4 = (random.nextLong() % 9000L) + 1000L;
        formNumber = " " + Math.abs(first4);

        initializeComponents();
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    /**
     * Initializes the components of the signup form.
     */
    private void initializeComponents() {
        // Adding Bank Logo
        ImageIcon bankIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image scaledBankIcon = bankIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel bankLogoLabel = new JLabel(new ImageIcon(scaledBankIcon));
        bankLogoLabel.setBounds(25, 10, 100, 100);
        add(bankLogoLabel);

        // Application Form Label
        JLabel labelFormNumber = new JLabel("APPLICATION FORM NO." + formNumber);
        labelFormNumber.setBounds(160, 20, 600, 40);
        labelFormNumber.setFont(new Font("Raleway", Font.BOLD, 38));
        add(labelFormNumber);

        // Page 1 Label
        JLabel labelPage1 = new JLabel("Page 1");
        labelPage1.setFont(new Font("Raleway", Font.BOLD, 22));
        labelPage1.setBounds(330, 70, 600, 30);
        add(labelPage1);

        // Personal Details Label
        JLabel labelPersonalDetails = new JLabel("Personal Details");
        labelPersonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        labelPersonalDetails.setBounds(290, 90, 600, 30);
        add(labelPersonalDetails);

        // Name Label and Text Field
        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 190, 100, 30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 190, 400, 30);
        add(textName);

        // Father's Name Label and Text Field
        JLabel labelFname = new JLabel("Father's Name :");
        labelFname.setFont(new Font("Raleway", Font.BOLD, 20));
        labelFname.setBounds(100, 240, 200, 30);
        add(labelFname);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway", Font.BOLD, 14));
        textFname.setBounds(300, 240, 400, 30);
        add(textFname);

        // Date of Birth Label and Date Chooser
        JLabel labelDob = new JLabel("Date of Birth");
        labelDob.setFont(new Font("Raleway", Font.BOLD, 20));
        labelDob.setBounds(100, 340, 200, 30);
        add(labelDob);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 340, 400, 30);
        add(dateChooser);

        // Gender Label and Radio Buttons
        JLabel labelGender = new JLabel("Gender");
        labelGender.setFont(new Font("Raleway", Font.BOLD, 20));
        labelGender.setBounds(100, 290, 200, 30);
        add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 290, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(450, 290, 90, 30);
        add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        // Email Label and Text Field
        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 390, 200, 30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        textEmail.setBounds(300, 390, 400, 30);
        add(textEmail);

        // Marital Status Label and Radio Buttons
        JLabel labelMaritalStatus = new JLabel("Marital Status :");
        labelMaritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMaritalStatus.setBounds(100, 440, 200, 30);
        add(labelMaritalStatus);

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        m1.setBackground(new Color(222, 255, 228));
        m1.setBounds(300, 440, 100, 30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        m2.setBackground(new Color(222, 255, 228));
        m2.setBounds(450, 440, 100, 30);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setFont(new Font("Raleway", Font.BOLD, 14));
        m3.setBackground(new Color(222, 255, 228));
        m3.setBounds(635, 440, 100, 30);
        add(m3);

        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(m1);
        maritalStatusGroup.add(m2);
        maritalStatusGroup.add(m3);

        // Address Label and Text Field
        JLabel labelAddress = new JLabel("Address :");
        labelAddress.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAddress.setBounds(100, 490, 200, 30);
        add(labelAddress);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway", Font.BOLD, 14));
        textAdd.setBounds(300, 490, 400, 30);
        add(textAdd);

        // City Label and Text Field
        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100, 540, 200, 30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD, 14));
        textCity.setBounds(300, 540, 400, 30);
        add(textCity);

        // Pin Code Label and Text Field
        JLabel labelPinCode = new JLabel("Pin Code :");
        labelPinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPinCode.setBounds(100, 590, 200, 30);
        add(labelPinCode);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.BOLD, 14));
        textPin.setBounds(300, 590, 400, 30);
        add(textPin);

        // State Label and Text Field
        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Raleway", Font.BOLD, 20));
        labelState.setBounds(100, 640, 200, 30);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        textState.setBounds(300, 640, 400, 30);
        add(textState);

        // Next Button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(750, 550, 80, 30);
        next.addActionListener(this);
        add(next);

        // Set Background Color
        getContentPane().setBackground(new Color(222, 255, 228));
    }

    /**
     * Handles the actions performed by the user.
     *
     * @param e ActionEvent triggered by user actions.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital = null;
        if (m1.isSelected()) {
            marital = "Married";
        } else if (m2.isSelected()) {
            marital = "Unmarried";
        } else if (m3.isSelected()) {
            marital = "Other";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
                Connn conn = new Connn();
                String query = "insert into signup values('" + formNumber + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + pincode + "', '" + state + "')";
                conn.statement.executeUpdate(query);
                new Signup2(formNumber);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Main method to run the Signup form.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        new Signup();
    }
}
