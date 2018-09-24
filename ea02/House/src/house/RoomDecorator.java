package house;

public abstract class RoomDecorator implements Room {

    protected Room decoratedRoom;

    public abstract void draw();

    public RoomDecorator(Room decoratedRoom) {
        this.decoratedRoom = decoratedRoom;
    }

}
