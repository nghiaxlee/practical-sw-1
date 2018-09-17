package company;

public class Employee {
    private String firstName;
    private String lastName;
    private int    salary;
    private String job;

    public Employee(String firstName, String lastName, int salary, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.job = job;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
    }
    
    public void raiseSalary(int percent){
        salary = (int)(salary * (1.0 + percent / 100.0));
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "' job is: " + job + ", salary: " + salary;
    }

}
  