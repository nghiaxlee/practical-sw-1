package box;

import java.util.ArrayList;
import java.util.ListIterator;

public class Store {
    private final int MAXCAPACITY;
    private final ArrayList<Integer> boxes;

    public Store(int maxCapacity){
        this.MAXCAPACITY = maxCapacity;
        boxes = new ArrayList<>(MAXCAPACITY);
    }

    public boolean addBox(int boxID){
        if(boxes.size() == MAXCAPACITY){
            return false;
        } else {
            boxes.add(boxID);
        }

        return true;
    }

    public boolean removeBox(int boxID){
        ListIterator<Integer> l = boxes.listIterator();
        if(l.hasNext()){
            int id = l.next();
            if(id == boxID){
                l.remove();
                return true;
            }
        }

        return false;
    }

    public boolean containsBox(int boxID){
        for(int id : boxes){
            if(id == boxID){
                return true;
            }
        }

        return false;
    }

    public void empty(){
        boxes.clear();
    }

    public int numBoxes(){
        return boxes.size();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Store s = new Store(5);

        s.addBox(1000);
        s.addBox(1001);
        s.addBox(1002);
        s.addBox(1003);
        s.addBox(1004); //5.

        System.out.println("Can we put this into the store? " + s.addBox(1006));
        System.out.println("Is 1004 in the store? " + s.containsBox(1004));

        s.empty();
        System.out.println("How many boxes are in the store? " + s.numBoxes());
    }

}
