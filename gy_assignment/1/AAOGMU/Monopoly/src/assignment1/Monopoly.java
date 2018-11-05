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


import java.io.BufferedReader;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.util.*;



/**

 * This class simulates the Monopoly game with players, fields and dice are given from

 * a file.

 */

public class Monopoly {

    private LinkedList<Player> players;

    private ArrayList<Field> fields;

    private ArrayList<Integer> rolls;

    private boolean test_flag;

    private final int DICE = 6;



    public Monopoly() {

        players = new LinkedList<>();

        fields = new ArrayList<>();

        rolls = new ArrayList<>();

        test_flag = false;

    }



    /**

     * Starts the game with list of players and list of fields and keep playing until

     * only one player left, then output that player as the winner of the game.

     */

    public void start() throws NotEnoughRollException

    {

        Random rand = new Random();

        ListIterator<Integer> roll = rolls.listIterator();

        while (players.size() > 1)

        {

            ListIterator<Player> player = players.listIterator();

            while (players.size() > 1 && player.hasNext())

            {

                Player curr = player.next();

                // if test_flag is on, then we already have the roll in each turn

                // and we will use it to check our program.

                if (test_flag)
                    if (!roll.hasNext())
                        throw new NotEnoughRollException();

                int dice = test_flag ? roll.next() : rand.nextInt(DICE) + 1;

                curr.updatePos(dice, fields.size());

                fields.get(curr.getPos()).event(curr);

                if (!curr.stillAlive())

                {

                    curr.lose();

                    player.remove();

                }

            }

        }

        for(Player p: players)

        {

            // This will only print the winner.

            System.out.println(p);

        }

    }



    /**
     * Reads and stores the data from file.

     * @param filename

     * The place of input file on the computer.

     * @throws FileNotFoundException

     * Cannot find the input file.

     * @throws InvalidInputException

     * Did not have the correct kind of Field, Player.

     * @throws NoSuchElementException

     * Not enough input.

     */

    public void read(String filename) throws FileNotFoundException, InvalidInputException,

            NoSuchElementException, InfiniteLoopGameException, NegativeInputException

    {

        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));

        int num_fields = inputCheck(sc);

        int cnt_lucky = 0;

        // For checking input number

        int tmp;

        if (num_fields == 0)

            throw new InfiniteLoopGameException();

        for(int i = 0; i < num_fields; ++i)

        {

            Field field;

            switch (sc.next().toLowerCase()) {

                case "service":

                    tmp = inputCheck(sc);

                    field = new Service(tmp, fields.size());

                    break;

                case "lucky":

                    tmp = inputCheck(sc);

                    field = new Lucky(tmp, fields.size());

                    ++cnt_lucky;

                    break;

                case "property":

                    field = new Property(fields.size());

                    break;

                default:

                    throw new InvalidInputException();

            }

            fields.add(field);

        }

        if (cnt_lucky == num_fields)

            throw new InfiniteLoopGameException();

        int num_players = sc.nextInt();

        if (num_players == 0)

            throw new InfiniteLoopGameException();

        for(int i = 0; i < num_players; ++i)

        {

            Player player;

            String name = sc.next();

            String strategy = sc.next();

            switch (strategy.toLowerCase()) {

                case "careful":

                    player = new Careful(name);

                    break;

                case "greedy":

                    player = new Greedy(name);

                    break;

                case "tactical":

                    player = new Tactical(name);

                    break;

                default:

                    throw new InvalidInputException();

            }

            players.add(player);

        }

        while (sc.hasNextInt())

        {

            test_flag = true;

            tmp = inputCheck(sc);

            if (tmp > 6 || tmp < 1)

                throw new InvalidInputException();

            else

                rolls.add(tmp);

        }

    }

    private int inputCheck(Scanner sc) throws NegativeInputException
    {
        int tmp = sc.nextInt();
        if (tmp < 0)
            throw new NegativeInputException();
        return tmp;
    }

}

