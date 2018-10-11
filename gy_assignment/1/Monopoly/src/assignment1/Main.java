// Le Minh Nghia
//
// AAOGMU
//
// First assignment - exercise number 4
//
// 2018/10/10 18:17:37
//
// This solution was submitted and prepared by Le Minh Nghia, AAOGMU for the
// First assignment - exercise number 4 assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

package assignment1;



import java.io.FileNotFoundException;

import java.util.NoSuchElementException;



public class Main {



    public static void main(String[] args) {

        // TODO: Create Document:.

//        description of the exercise DONE
//        short description how to use your program (user doc) DONE
//        UML class diagram (made with a dedicated UML tool) DONE
//        short descriptions of the implemented methods DONE
//        list of test cases you have tested (at least 10 pieces)
        // TODO: Gen big test.


        // TODO: Write out the history of the game;


        Monopoly game = new Monopoly();

        try {

            game.read("assignments-1-input.txt");

        } catch (FileNotFoundException e) {

            System.out.println("File not found!");

            System.exit(-1);

        } catch (InvalidInputException e) {

            System.out.println("Invalid input!");

            System.exit(-1);

        } catch (NoSuchElementException e) {

            System.out.println("Not enough elements or invalid input!");

            System.exit(-1);

        } catch (InfiniteLoopGameException e) {

            System.out.println("This input will cause infinite loop game!");

            System.exit(-1);

        } catch (NegativeInputException e) {

            System.out.println("The input should not have negative numbers!");

            System.exit(-1);
        }

        try {
            game.start();
        } catch (NotEnoughRollException e) {

            System.out.println("Error in testing: Not enough turns to find the winner");

            System.exit(-1);
        }

    }

}

