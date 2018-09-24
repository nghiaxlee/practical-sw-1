package house;

import java.util.ArrayList;
import java.util.Scanner;

public class House {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();
        while (true){
            System.out.print("What type of room do you wanna add? [L]iving room / [K]itchen: ");
            String s = sc.nextLine();
            Room r;
            if (s.equals("L")){
                System.out.print("Who's the owner: ");
                s = sc.nextLine();
                r = new LivingRoom(new Person(s));
            } else if (s.equals("K")){
                r = new Kitchen();
            } else {
                break;
            }
            

            while (true){
                System.out.print("Do you wanna add [D]oor or [W]indow: ");
                s = sc.nextLine();
                if (s.equals("D")){
                    System.out.print("Width:  ");
                    int width = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Height: ");
                    int height = sc.nextInt();
                    sc.nextLine();
                    Door door = new Door(width, height);
                    r = new DooredRoomDecorator(door, r);
                } else if (s.equals("W")){
                    System.out.print("Width:  ");
                    int width = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Height: ");
                    int height = sc.nextInt();
                    sc.nextLine();
                    Window window = new Window(width, height);
                    r = new WindowedRoomDecorator(window, r);
                } else {
                    break;
                }
            }
            rooms.add(r);
        }
        for (Room r : rooms){
            r.draw();
        }
    }
    
}
