package school.management.system;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Teacher> teachers;
    private List<Student> students;
    private static int totalMoneyEarned;
    private static int totalMoneySpent;

    /**
     * Default constructor to initialize the lists of teachers and students.
     */
    public School() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    /**
     * Parameterized constructor to initialize the school with lists of teachers and students.
     * @param teachers List of teachers.
     * @param students List of students.
     */
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers != null ? teachers : new ArrayList<>();
        this.students = students != null ? students : new ArrayList<>();
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    /**
     * Gets the list of teachers in the school.
     * @return List of teachers.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Adds a teacher to the school.
     * @param teacher The teacher to be added.
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * Gets the list of students in the school.
     * @return List of students.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Adds a student to the school.
     * @param student The student to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Gets the total money earned by the school.
     * @return Total money earned.
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Updates the total money earned by the school.
     * @param moneyEarned Money earned to be added.
     */
    public static void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
    }

    /**
     * Gets the total money spent by the school.
     * @return Total money spent.
     */
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * Updates the total money spent by the school.
     * @param moneySpent Money spent to be added.
     */
    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneySpent += moneySpent;
    }
}
