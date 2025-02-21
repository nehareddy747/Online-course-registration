import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserDetailsPage extends JFrame implements ActionListener {
    private JTextField nameTextField, emailTextField, contactTextField, rollNoTextField, branchTextField, yearTextField, dobTextField;
    private JButton nextButton;

    public UserDetailsPage() {
        setTitle("ONLINE COURSE REGISTRATION (User Details)");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font boldFont = new Font(Font.MONOSPACED, Font.PLAIN, 27);
        Font textFieldFont = new Font(Font.MONOSPACED, Font.PLAIN, 23);
        // User Details
        addComponent(gbc, createLabel("Name:", boldFont), 0, 0);
        nameTextField = new JTextField(15);
        nameTextField.setFont(textFieldFont); 
        addComponent(gbc, nameTextField, 1, 0);

        addComponent(gbc, createLabel("Email:", boldFont), 0, 1);
        emailTextField = new JTextField(15);
        emailTextField.setFont(textFieldFont);
        addComponent(gbc, emailTextField, 1, 1);

        addComponent(gbc, createLabel("Contact Number:", boldFont), 0, 2);
        contactTextField = new JTextField(15);
        contactTextField.setFont(textFieldFont);
        addComponent(gbc, contactTextField, 1, 2);

        addComponent(gbc, createLabel("Roll No.:", boldFont), 0, 3);
        rollNoTextField = new JTextField(15);
        rollNoTextField.setFont(textFieldFont);
        addComponent(gbc, rollNoTextField, 1, 3);

        addComponent(gbc, createLabel("Branch:", boldFont), 0, 4);
        branchTextField = new JTextField(15);
        branchTextField.setFont(textFieldFont);
        addComponent(gbc, branchTextField, 1, 4);

        addComponent(gbc, createLabel("Year:", boldFont), 0, 5);
        yearTextField = new JTextField(15);
        yearTextField.setFont(textFieldFont);
        addComponent(gbc, yearTextField, 1, 5);

        addComponent(gbc, createLabel("DOB (YYYY-MM-DD):", boldFont), 0, 6);
        dobTextField = new JTextField(15);
        dobTextField.setFont(textFieldFont);
        addComponent(gbc, dobTextField, 1, 6);

        // Next Button
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(nextButton, gbc);

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
        if (e.getSource() == nextButton) {
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String contact = contactTextField.getText();
            String rollNo = rollNoTextField.getText();
            String branch = branchTextField.getText();
            String year = yearTextField.getText();
            String dob = dobTextField.getText();

            // if (name.isEmpty() || email.isEmpty() || contact.isEmpty() || rollNo.isEmpty() || branch.isEmpty() || year.isEmpty() || dob.isEmpty()) {
            //     JOptionPane.showMessageDialog(this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
            // } else {
            //     new CourseDetailsPage(name, email, contact, rollNo, branch, year, dob);
            //     dispose();
            // }
            new CourseDetailsPage(name, email, contact, rollNo, branch, year, dob);
                dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserDetailsPage::new);
    }
}
