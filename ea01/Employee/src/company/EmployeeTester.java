package company;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTester {
    public static String readString(Scanner sc, String msg){
        System.out.print(msg);
        return sc.nextLine();
    }
    public static int readInt(Scanner sc, String msg){
        System.out.print(msg);
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }
    
    public static Employee readEmployee(Scanner sc){
        String firstName = readString(sc, "First name: ");
        String lastName  = readString(sc, "Last  name: ");
        String job       = readString(sc, "Job:        ");
        int    salary    = readInt(sc,    "Salary:     ");
        return new Employee(firstName, lastName, salary, job);
    }

    public static void main(String[] args) { // ver-3.0
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            employees.add(readEmployee(sc));
            System.out.println(employees.get(i));
        }
        
        int    raise  = readInt(sc,    "Raise: ");
        String job    = readString(sc, "Job?:  ");
        
        for (Employee e : employees) {
            if (e.getJob().equals(job)) e.raiseSalary(raise);
            System.out.println(e);
        }
        
        Employee richMan = employees.get(0);
        for (Employee e : employees)
            if (e.getSalary() > richMan.getSalary()) 
                richMan = e;
        
        System.out.println("Most payed employee:" + richMan);
    }      
/*    
    public static void main(String[] args) { // ver-2.0
        Scanner sc = new Scanner(System.in);
        String firstName = readString(sc, "First name: ");
        String lastName  = readString(sc, "Last  name: ");
        String job       = readString(sc, "Job:        ");
        int    salary    = readInt(sc,    "Salary:     ");
        int    raise     = readInt(sc,    "Raise:      ");
        Employee e = new Employee(firstName, lastName, salary, job);
        System.out.println(e.getFirstName() + " " + e.getLastName() + "' job: " + e.getJob() + ", salary: " + e.getSalary());
        e.raiseSalary(raise);
        System.out.println("After raise: ");
        System.out.println(e);
    }      
*/
/*
    public static void main(String[] args) { // ver-1.0
        Scanner sc = new Scanner(System.in);
        System.out.print("First name: ");
        String firstName = sc.nextLine();
        System.out.print("Last  name: ");
        String lastName  = sc.nextLine();
        System.out.print("Job:        ");
        String job       = sc.nextLine();
        System.out.print("Salary:     ");
        int    salary    = sc.nextInt();
        int    raise     = readInt(sc,    "Raise:   ");
        Employee e = new Employee(firstName, lastName, salary, job);
        System.out.println(e.getFirstName() + " " + e.getLastName() + "' job: " + e.getJob() + ", salary: " + e.getSalary());
        e.raiseSalary(raise);
        System.out.println("After raise: ");
        System.out.println(e);
    }      
*/    
}
