package school.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SchoolManagementSystemGUI {

    private School school;  // School object to manage teachers and students
    private JTextArea outputArea;  // Text area for displaying output messages
    private JComboBox<Student> studentComboBox;  // Combo box for selecting students
    private JComboBox<Teacher> teacherComboBox;  // Combo box for selecting teachers

    public SchoolManagementSystemGUI() {
        // Initialize lists of teachers and students
        List<Teacher> teacherList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        school = new School(teacherList, studentList);
        initUI();  // Initialize the user interface
    }

    private void initUI() {
        // Create the main frame
        JFrame frame = new JFrame("School Management System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel and set layout
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Place components on the panel
        placeComponents(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        // Add student label
        JLabel studentLabel = new JLabel("Add Student:");
        studentLabel.setBounds(10, 10, 80, 25);
        panel.add(studentLabel);

        // Add student name text field
        JTextField studentNameField = new JTextField(20);
        studentNameField.setBounds(100, 10, 160, 25);
        panel.add(studentNameField);

        // Add student grade text field
        JTextField studentGradeField = new JTextField(20);
        studentGradeField.setBounds(270, 10, 50, 25);
        panel.add(studentGradeField);

        // Add student button
        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.setBounds(330, 10, 150, 25);
        panel.add(addStudentButton);

        // Add teacher label
        JLabel teacherLabel = new JLabel("Add Teacher:");
        teacherLabel.setBounds(10, 40, 80, 25);
        panel.add(teacherLabel);

        // Add teacher name text field
        JTextField teacherNameField = new JTextField(20);
        teacherNameField.setBounds(100, 40, 160, 25);
        panel.add(teacherNameField);

        // Add teacher salary text field
        JTextField teacherSalaryField = new JTextField(20);
        teacherSalaryField.setBounds(270, 40, 50, 25);
        panel.add(teacherSalaryField);

        // Add teacher button
        JButton addTeacherButton = new JButton("Add Teacher");
        addTeacherButton.setBounds(330, 40, 150, 25);
        panel.add(addTeacherButton);

        // Add select student label
        JLabel selectStudentLabel = new JLabel("Select Student:");
        selectStudentLabel.setBounds(10, 70, 100, 25);
        panel.add(selectStudentLabel);

        // Add student combo box
        studentComboBox = new JComboBox<>();
        studentComboBox.setBounds(120, 70, 160, 25);
        panel.add(studentComboBox);

        // Add pay fees button
        JButton payFeesButton = new JButton("Pay Fees");
        payFeesButton.setBounds(290, 70, 100, 25);
        panel.add(payFeesButton);

        // Add select teacher label
        JLabel selectTeacherLabel = new JLabel("Select Teacher:");
        selectTeacherLabel.setBounds(10, 100, 100, 25);
        panel.add(selectTeacherLabel);

        // Add teacher combo box
        teacherComboBox = new JComboBox<>();
        teacherComboBox.setBounds(120, 100, 160, 25);
        panel.add(teacherComboBox);

        // Add pay salary button
        JButton paySalaryButton = new JButton("Pay Salary");
        paySalaryButton.setBounds(290, 100, 100, 25);
        panel.add(paySalaryButton);

        // Add output area with scroll pane
        outputArea = new JTextArea();
        outputArea.setEditable(false);  // Make the text area non-editable

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(10, 140, 560, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        // Add action listener for adding students
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = studentNameField.getText();
                int grade = Integer.parseInt(studentGradeField.getText());
                int id = school.getStudents().size() + 1;
                Student student = new Student(id, name, grade);
                school.addStudent(student);
                studentComboBox.addItem(student);
                outputArea.append("Added student: " + name + " (Grade: " + grade + ")\n");
            }
        });

        // Add action listener for adding teachers
        addTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = teacherNameField.getText();
                int salary = Integer.parseInt(teacherSalaryField.getText());
                int id = school.getTeachers().size() + 1;
                Teacher teacher = new Teacher(id, name, salary);
                school.addTeacher(teacher);
                teacherComboBox.addItem(teacher);
                outputArea.append("Added teacher: " + name + " (Salary: " + salary + ")\n");
            }
        });

        // Add action listener for paying fees
        payFeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = (Student) studentComboBox.getSelectedItem();
                if (student != null) {
                    student.payFees(1000);  // Example amount
                    outputArea.append(student.getName() + " paid fees. Total fees paid: $" + student.getFeesPaid() + "\n");
                    outputArea.append("Total money earned by school: $" + school.getTotalMoneyEarned() + "\n");
                }
            }
        });

        // Add action listener for paying salary
        paySalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher teacher = (Teacher) teacherComboBox.getSelectedItem();
                if (teacher != null) {
                    teacher.receiveSalary(teacher.getSalary());
                    outputArea.append("Paid salary to: " + teacher.getName() + ". Total salary earned: $" + teacher.getSalary() + "\n");
                    outputArea.append("Total money spent by school: $" + school.getTotalMoneySpent() + "\n");
                    outputArea.append("Remaining money in school: $" + (school.getTotalMoneyEarned() - school.getTotalMoneySpent()) + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchoolManagementSystemGUI();
            }
        });
    }
}
