package school.management.system;

/**
 * This class represents a teacher in the school system.
 * It keeps track of teacher's ID, name, salary, and salary earned.
 */
public class Teacher {
    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    /**
     * Constructor to create a new teacher with initial values.
     * @param id Unique identifier for the teacher.
     * @param name Name of the teacher.
     * @param salary Salary of the teacher.
     */
    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0; // Initialize salary earned to 0
    }

    /**
     * Getter method to retrieve the teacher's ID.
     * @return Teacher's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method to retrieve the teacher's name.
     * @return Teacher's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to retrieve the teacher's salary.
     * @return Teacher's salary.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Setter method to set the teacher's salary.
     * @param salary New salary to be set.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Method for the teacher to receive their salary.
     * @param salary Salary amount to be received.
     */
    public void receiveSalary(int salary) {
        salaryEarned += salary; // Add received salary to salaryEarned
        School.updateTotalMoneySpent(salary); // Update total money spent by the school
    }

    /**
     * Override of toString method to provide a string representation of the teacher object.
     * @return String representation of the teacher's name and total salary earned.
     */
    @Override
    public String toString() {
        return "Teacher's name: " + name + ", Total salary earned so far: $" + salaryEarned;
    }
}
