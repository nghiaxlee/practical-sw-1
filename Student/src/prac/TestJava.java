package prac;

import java.util.Scanner;

public class TestJava {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Student student = new Student();
        boolean exit = false;
        while (!exit) {
            System.out.println("TEST MENU:");
            System.out.println("1: add your student information");
            System.out.println("2: print student properties");
            System.out.println("3: exit");

            System.out.println("Pick one:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Student's name: ");
                    String name = sc.next();
                    System.out.println("Student's nationality: ");
                    String nationality = sc.next();
                    System.out.println("Student's grades: ");
                    double average = Double.parseDouble(sc.next());
                    student = new Student(name, nationality, average);
                    break;
                case 2:
                    if (student.getName() == null)
                        System.out.println("Your information is empty");
                    else
                        System.out.println(student);
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }
    }
}
