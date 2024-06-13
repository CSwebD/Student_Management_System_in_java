package school.management.system;

/**
 * This class is responsible for keeping the track of
 * teacher's name, id and salary.
 */

public class Teacher {
    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    public Teacher(int id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
    }

    // return id, name and salary for the teacher
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getSalary(){
        return salary;
    }

    // set the salary
    public void setSalary(int salary){
        this.salary = salary;
    }

    public void receiveSalary(int salary){ 
        salaryEarned += salary;
        School.updateTotalMoneySpent(salary);
    }

    @Override
    public String toString(){
        return "Name to the Teacher: " + name + "Total salary earned so far $" + salaryEarned;
    }
}
