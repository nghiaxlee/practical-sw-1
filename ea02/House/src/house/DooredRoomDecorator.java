package house;

public class DooredRoomDecorator extends RoomDecorator {

    private final Door door;

    @Override
    public void draw() {
        decoratedRoom.draw();
        System.out.println(door);
    }

    public DooredRoomDecorator(Door door, Room decoratedRoom) {
        super(decoratedRoom);
        this.door = door;
    }

  
}
