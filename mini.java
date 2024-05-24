package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// The 'mini' class extends JFrame and implements ActionListener to create a GUI for displaying mini statements
public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    
    // Constructor that takes the pin as a parameter and sets up the GUI
    mini(String pin){
        this.pin = pin;
        getContentPane().setBackground(new Color(255,204,204)); // Set background color
        setSize(400,600); // Set size of the frame
        setLocation(20,20); // Set location of the frame
        setLayout(null); // Use absolute layout

        // Label to display transaction details
        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        // Label for the title
        JLabel label2 = new JLabel("TechCoder A.V");
        label2.setFont(new Font("System", Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        // Label to display card number
        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        // Label to display total balance
        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        // Fetch and display card number
        try{
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while (resultSet.next()){
                // Mask card number except for the first 4 and last 4 digits
                label3.setText("Card Number:  "+ resultSet.getString("card_number").substring(0,4) + "XXXXXXXX"+ resultSet.getString("card_number").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        // Fetch and display transaction details and calculate total balance
        try{
            int balance =0;
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                // Append transaction details to the label
                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                // Update balance based on transaction type
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            // Display the total balance
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        // Exit button to close the application
        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true); // Make the frame visible
    }

    // Handle button click event to close the frame
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new mini("");
    }
}
