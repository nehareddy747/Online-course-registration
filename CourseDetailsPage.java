import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CourseDetailsPage extends JFrame implements ActionListener {
    private String userName, userEmail, userContact, userRollNo, userBranch, userYear, userDob;
    private String selectedCourse, selectedCourseType;
    private JTextField durationTextField, feesTextField;
    private Choice courseChoice;
    private JRadioButton onlineRadioButton, offlineRadioButton;
    private ButtonGroup courseTypeGroup;
    private JButton nextButton;

    public CourseDetailsPage(String name, String email, String contact, String rollNo, String branch, String year, String dob) {
        this.userName = name;
        this.userEmail = email;
        this.userContact = contact;
        this.userRollNo = rollNo;
        this.userBranch = branch;
        this.userYear = year;
        this.userDob = dob;

        setTitle("ONLINE COURSE REGISTRATION (Course Details)");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font boldFont = new Font(Font.SERIF, Font.BOLD, 20);
        Font textFieldFont = new Font(Font.SANS_SERIF, Font.PLAIN, 14); // Adjust font size here

        // Course Selection
        addComponent(gbc, createLabel("Select Course:", boldFont), 0, 0);
        courseChoice = new Choice();
        String[] courses = {"Java Programming", "Web Development", "Data Science", "Machine Learning", "CYBER"};
        for (String course : courses) {
            courseChoice.add(course);
        }
        courseChoice.setFont(textFieldFont); // Set font for Choice component
        addComponent(gbc, courseChoice, 1, 0);

        // Course Type Selection (Online/Offline)
        addComponent(gbc, createLabel("Select Course Type:", boldFont), 0, 1);
        onlineRadioButton = new JRadioButton("Online");
        onlineRadioButton.setFont(textFieldFont); // Set font for radio button
        offlineRadioButton = new JRadioButton("Offline");
        offlineRadioButton.setFont(textFieldFont); // Set font for radio button
        courseTypeGroup = new ButtonGroup();
        courseTypeGroup.add(onlineRadioButton);
        courseTypeGroup.add(offlineRadioButton);
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        typePanel.add(onlineRadioButton);
        typePanel.add(offlineRadioButton);
        addComponent(gbc, typePanel, 1, 1);

        // Course Duration
        addComponent(gbc, createLabel("Course Duration (months):", boldFont), 0, 2);
        durationTextField = new JTextField(15);
        durationTextField.setFont(textFieldFont); // Set font for text field
        addComponent(gbc, durationTextField, 1, 2);

        // Course Fees
        addComponent(gbc, createLabel("Course Fees ($):", boldFont), 0, 3);
        feesTextField = new JTextField(15);
        feesTextField.setFont(textFieldFont); // Set font for text field
        addComponent(gbc, feesTextField, 1, 3);

        // Next Button
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 4;
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
            selectedCourse = courseChoice.getSelectedItem();
            String duration = durationTextField.getText();
            String fees = feesTextField.getText();

            if (onlineRadioButton.isSelected()) {
                selectedCourseType = "Online";
            } else if (offlineRadioButton.isSelected()) {
                selectedCourseType = "Offline";
            } else {
                JOptionPane.showMessageDialog(this, "Please select a course type.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedCourse == null || duration.isEmpty() || fees.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                new PaymentPage(userName, userEmail, userContact, userRollNo, userBranch, userYear, userDob, selectedCourse, selectedCourseType, duration, fees);
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CourseDetailsPage("", "", "", "", "", "", ""));
    }
}
