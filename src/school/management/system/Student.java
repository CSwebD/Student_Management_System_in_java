package school.management.system;

/**
 * This class is responsible for keeping the track of students fees, name, grades & fees paid
 */

 public class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * To create a new student by initializing
     * @param id id for student: unique
     * @param name name of the student
     * @param grade grade of the student
     */
    public Student(int id, String name, int grade){
        this.feesPaid = 0;
        this.feesTotal = 30000;
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Not going to alter student's name, student's id

    /**
     * Used to upgrade the student's grade.
     * @param grade new grade of the student.
     */
    public void setGrade(int grade){
        this.grade = grade;
    }

    //
    // Keep adding the fees to feesPaid Field.
    // Add the fees to the fess paid.
    // The school is going recieve the funds.
    // the fees that the student pays
    public void payFees(int fees){
        feesPaid += fees;
        School.updateTotalMoneyEarned(feesPaid);
    }

    // return id, name, grade, feespaid, feestotal
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getGrade(){
        return grade;
    }

    public int getFeesPaid(){
        return feesPaid;
    }

    public int getFeesTotal(){
        return feesTotal;
    }
    
    // The remaining fees
    public int getRemainingFees(){
        return feesTotal - feesPaid;
    }

    @Override
    public String toString(){
        return "Student's name: " +name +"Total fees paid so far $" + feesPaid;
    }

 }

 
