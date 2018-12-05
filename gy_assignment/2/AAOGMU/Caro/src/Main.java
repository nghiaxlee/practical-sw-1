// Le Minh Nghia
//
// AAOGMU
//
// 2nd Assignment - Tricky 5-in-a-row
//
// 2018/11/18 14:14:19
//
// This solution was submitted and prepared by Le Minh Nghia, AAOGMU for the
// 2nd Assignment - Tricky 5-in-a-row assignment of the Practical software engineering I. course.
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

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
//        TicTacToe game = new TicTacToe(10);
//        while (game.getWinner() == -1)
//        {
//            game.print();
//            System.out.print("Player's turn: ");
//            System.out.println(game.getPlayer());
//            Scanner sc = new Scanner(System.in);
//            int i = sc.nextInt();
//            int j = sc.nextInt();
//            game.step(i, j);
//        }
//        System.out.println("Winner is: " + game.getWinner());
        GameWindow canvas = new GameWindow(10);
        canvas.setVisible(true);
    }
}
