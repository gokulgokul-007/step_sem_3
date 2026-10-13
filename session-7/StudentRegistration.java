import javax.swing.*;
import java.awt.*;

public class StudentRegistration extends JFrame {
    private JTextField nameField = new JTextField(15);
    private JTextField regField = new JTextField(15);
    private JRadioButton male = new JRadioButton("Male");
    private JRadioButton female = new JRadioButton("Female");
    private JRadioButton other = new JRadioButton("Other");
    private JComboBox<String> deptBox = new JComboBox<>(
            new String[] { "CSE", "IT", "ECE", "EEE", "MECH", "CIVIL" });

    public StudentRegistration() {
        setTitle("Student Registration");
        setSize(380, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 8, 8));

        ButtonGroup group = new ButtonGroup();   // only one gender selectable
        group.add(male);
        group.add(female);
        group.add(other);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> showDetails());

        add(new JLabel("  Student Name:"));
        add(nameField);
        add(new JLabel("  Register Number:"));
        add(regField);
        add(new JLabel("  Gender:"));
        add(genderPanel);
        add(new JLabel("  Department:"));
        add(deptBox);
        add(new JLabel());
        add(submit);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showDetails() {
        String gender = male.isSelected() ? "Male"
                : female.isSelected() ? "Female"
                : other.isSelected() ? "Other" : "Not selected";

        String msg = "Name: " + nameField.getText()
                + "\nRegister No: " + regField.getText()
                + "\nGender: " + gender
                + "\nDepartment: " + deptBox.getSelectedItem();

        JOptionPane.showMessageDialog(this, msg, "Registration Details",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistration::new);
    }
}
