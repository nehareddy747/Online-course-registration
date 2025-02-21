import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PaymentPage extends JFrame implements ActionListener {
    private String userName, userEmail, userContact, userRollNo, userBranch, userYear, userDob, selectedCourse, selectedCourseType, courseDuration, courseFees;
    private Choice paymentMethodChoice;
    private JTextField transactionIdTextField;
    private JButton finishButton;

    public PaymentPage(String name, String email, String contact, String rollNo, String branch, String year, String dob,
                      String course, String courseType, String duration, String fees) {
        this.userName = name;
        this.userEmail = email;
        this.userContact = contact;
        this.userRollNo = rollNo;
        this.userBranch = branch;
        this.userYear = year;
        this.userDob = dob;
        this.selectedCourse = course;
        this.selectedCourseType = courseType;
        this.courseDuration = duration;
        this.courseFees = fees;

        setTitle("ONLINE COURSE REGISTRATION (Payment Details)");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font boldFont = new Font(Font.SERIF, Font.BOLD, 20);

        // Payment Method
        addComponent(gbc, createLabel("Select Payment Method:", boldFont), 0, 0);
        paymentMethodChoice = new Choice();
        String[] paymentMethods = {"Credit Card", "Debit Card", "Net Banking", "UPI"};
        for (String method : paymentMethods) {
            paymentMethodChoice.add(method);
        }
        addComponent(gbc, paymentMethodChoice, 1, 0);

        // Transaction ID
        addComponent(gbc, createLabel("Transaction ID:", boldFont), 0, 1);
        transactionIdTextField = new JTextField(15);
        addComponent(gbc, transactionIdTextField, 1, 1);

        // Finish Button
        finishButton = new JButton("Finish");
        finishButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(finishButton, gbc);

        setVisible(true);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private void addComponent(GridBagConstraints gbc, Component component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(component, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == finishButton) {
            String paymentMethod = paymentMethodChoice.getSelectedItem();
            String transactionId = transactionIdTextField.getText();

            if (transactionId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Transaction ID must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Displaying information and handling registration
                System.out.println("Name: " + userName);
                System.out.println("Email: " + userEmail);
                System.out.println("Contact: " + userContact);
                System.out.println("Roll No.: " + userRollNo);
                System.out.println("Branch: " + userBranch);
                System.out.println("Year: " + userYear);
                System.out.println("DOB: " + userDob);
                System.out.println("Selected Course: " + selectedCourse);
                System.out.println("Course Type: " + selectedCourseType);
                System.out.println("Course Duration: " + courseDuration + " months");
                System.out.println("Course Fees: $" + courseFees);
                System.out.println("Payment Method: " + paymentMethod);
                System.out.println("Transaction ID: " + transactionId);

                // Showing success messages
                JOptionPane.showMessageDialog(this, "Payment Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Closing the payment page
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        SwingUtilities.invokeLater(() -> {
            PaymentPage paymentPage = new PaymentPage("", "", "",
                    "", "", "", "",
                    "", "", "", "");
        });
    }
}
