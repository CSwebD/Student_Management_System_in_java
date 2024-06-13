package school.management.system;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Teacher> teachers;
    private List<Student> students;
    private static int totalMoneyEarned;
    private static int totalMoneySpent;

    public School() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    public School(List<Teacher> teachers, List<Student> students){
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    // the list of teachers in the school
    public List<Teacher> getTeachers() {
        return teachers;
    }
    
    // add teachers in the school
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // the list of students in the school
    public List<Student> getStudents() {
        return students;
    }

    // add students in the school
    public void addStudent(Student student) {
        students.add(student);
    }

    // return the total earned by the school
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    // adds the total money earned by the school
    public static void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
    }

    // the total money spent by the school
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    // update the money that is spent by the school which
    // is the salary given by the school to its teachers
    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneySpent += moneySpent;
    }    
}
