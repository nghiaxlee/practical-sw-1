package prac;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Scanner sc = new Scanner(System.in);
//        System.out.println("LMN");
        ArrayList<Student> student_list = new ArrayList<>();
        System.out.println("Number of students:");
        int n = sc.nextInt();
        for(int i = 0; i < n; ++i) {
            student_list.add(ReadStudent(sc));
        }
        int max_id = 0;
        int min_id = 0;
        for(int i = 1; i < n; ++i) {
            if (student_list.get(max_id).getGrades() < student_list.get(i).getGrades())
                max_id = i;
            if (student_list.get(min_id).getGrades() > student_list.get(i).getGrades())
                min_id = i;
        }
        double best_grades = student_list.get(max_id).getGrades();
        double worst_grades = student_list.get(min_id).getGrades();
        System.out.println("Best average: " + best_grades);
        System.out.println("Worst average: " + worst_grades);
        System.out.println("Difference of best and worst: " +
            (best_grades - worst_grades));
        System.out.println("Average of best and worst: " +
            (best_grades + worst_grades) / 2);
    }

    private static Student ReadStudent(Scanner sc) {
        System.out.println("Student's name: ");
        String name = sc.next();
        System.out.println("Student's nationality: ");
        String nationality = sc.next();
        System.out.println("Student's grades: ");
        double average = Double.parseDouble(sc.next());
        return new Student(name, nationality, average);
    }
}
