package house;

public class LivingRoom implements Room {

    private final Person owner;

    public void draw() {
        System.out.println(owner.name +  "'s living room");
    }

    public LivingRoom(Person owner) {
        this.owner = owner;
    }

}
