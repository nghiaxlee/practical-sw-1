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
