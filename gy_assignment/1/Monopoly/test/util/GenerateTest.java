import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateTest {
    public static void Gen() throws Exception {
        Random rand = new Random();
        String[] field_name = {"Service", "Lucky", "Property"};
        String[] player_type = {"Careful", "Tactical", "Greedy"};
        int n_field = 100;
        int n_player = 100;
        PrintWriter pw = new PrintWriter(new FileWriter("test/12.txt"));
        pw.println(n_field);
        for(int i = 1; i <= n_field; ++i)
        {
            int type = rand.nextInt(3);
            pw.print(field_name[type]);
            if (type == 0)
                pw.print(" " + (rand.nextInt(6000) + 100));
            if (type == 1)
                pw.print(" " + (rand.nextInt(100) + 100));
            pw.println();
        }
        pw.println(n_player);
        int c = 0;
        for(int i = 1; i <= n_player; ++i)
        {
            int type = rand.nextInt(3);
            char c1 = (char)(c % 26 + 65);
            char c2 = (char)(c / 26 + 65);
            String name = new String();
            name += c1;
            name += c2;
            c++;
            pw.println(name + " " + player_type[type]);
        }
        pw.flush();
        pw.close();
    }
}
