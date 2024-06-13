package school.management.system;

/**
 * This class represents a student in the school system.
 * It keeps track of student's fees, name, grade, and fees paid.
 */
public class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * Constructor to create a new student with initial values.
     * @param id Unique identifier for the student.
     * @param name Name of the student.
     * @param grade Grade of the student.
     */
    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
        this.feesTotal = 30000; // Default total fees for the student
    }

    /**
     * Method to set a new grade for the student.
     * @param grade New grade to be set.
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Method to pay fees for the student.
     * @param fees Amount of fees to be paid.
     */
    public void payFees(int fees) {
        feesPaid += fees; // Add fees to feesPaid
        School.updateTotalMoneyEarned(feesPaid); // Update total money earned by the school
    }

    /**
     * Getter method to retrieve the student's ID.
     * @return Student's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method to retrieve the student's name.
     * @return Student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to retrieve the student's grade.
     * @return Student's grade.
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Getter method to retrieve the total fees paid by the student.
     * @return Total fees paid by the student.
     */
    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     * Getter method to retrieve the total fees payable by the student.
     * @return Total fees payable by the student.
     */
    public int getFeesTotal() {
        return feesTotal;
    }
    
    /**
     * Method to calculate the remaining fees to be paid by the student.
     * @return Remaining fees to be paid.
     */
    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    /**
     * Override of toString method to provide a string representation of the student object.
     * @return String representation of the student's name and total fees paid.
     */
    @Override
    public String toString() {
        return "Student's name: " + name + ", Total fees paid so far: $" + feesPaid;
    }
}
