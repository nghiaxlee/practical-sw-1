package assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Monopoly {
    private LinkedList<Player> players;
    private final ArrayList<Field> fields;
    private final int DICE = 6;

    public Monopoly() {
        players = new LinkedList<>();
        fields = new ArrayList<>();
    }

    /**
     *
     */
    public void start()
    {
        Random rand = new Random();
        while (players.size() > 1)
        {
            ListIterator<Player> player = players.listIterator();
            while (player.hasNext())
            {
                Player curr = player.next();
                int dice = rand.nextInt(DICE) + 1;
                curr.setPos((curr.getPos() + dice) % fields.size());
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
            System.out.println(p);
        }
    }

    /**
     * @param filename
     * @throws FileNotFoundException
     * @throws InvalidInputException
     */
    public void read(String filename) throws FileNotFoundException, InvalidInputException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        int num_fields = sc.nextInt();
        if (num_fields == 0)
            throw new InvalidInputException();
        for(int i = 0; i < num_fields; ++i)
        {
            Field field;
            switch (sc.next().toLowerCase()) {
                case "service":
                    field = new Service(sc.nextInt(), fields.size());
                    break;
                case "lucky":
                    field = new Lucky(sc.nextInt(), fields.size());
                    break;
                case "property":
                    field = new Property(fields.size());
                    break;
                default:
                    throw new InvalidInputException();
            }
            fields.add(field);
        }
        int num_players = sc.nextInt();
        if (num_players == 0)
            throw new InvalidInputException();
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
    }
}
