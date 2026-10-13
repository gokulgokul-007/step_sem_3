import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CourseManagement extends JFrame {
    private JTextField nameField = new JTextField(12);
    private JList<String> courseList = new JList<>(new String[] {
            "Operating Systems", "Java Programming", "Data Structures",
            "Computer Networks", "Database Systems" });
    private DefaultTableModel model = new DefaultTableModel(
            new String[] { "Student Name", "Selected Course", "Status" }, 0);
    private JTable table = new JTable(model);

    public CourseManagement() {
        setTitle("Student Course Management");
        setSize(650, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroll = new JScrollPane(courseList);
        listScroll.setBorder(BorderFactory.createTitledBorder("Available Courses"));
        listScroll.setPreferredSize(new Dimension(190, 0));

        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setBorder(BorderFactory.createTitledBorder("Registrations"));

        JButton addBtn = new JButton("Add Registration");
        JButton removeBtn = new JButton("Remove Registration");
        addBtn.addActionListener(e -> addRegistration());
        removeBtn.addActionListener(e -> removeRegistration());

        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Student Name:"));
        bottom.add(nameField);
        bottom.add(addBtn);
        bottom.add(removeBtn);

        add(listScroll, BorderLayout.WEST);
        add(tableScroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addRegistration() {
        String name = nameField.getText().trim();
        String course = courseList.getSelectedValue();

        if (name.isEmpty() || course == null) {
            JOptionPane.showMessageDialog(this,
                    "Enter a student name and select a course.", "Missing Input",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        model.addRow(new Object[] { name, course, "Enrolled" });
        nameField.setText("");
    }

    private void removeRegistration() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this,
                    "Select a row in the table to remove.", "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        model.removeRow(row);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CourseManagement::new);
    }
}
