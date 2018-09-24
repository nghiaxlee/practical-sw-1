package house;

public class WindowedRoomDecorator extends RoomDecorator {

    private final Window window;

    @Override
    public void draw() {
        decoratedRoom.draw();
        System.out.println(window);
    }

    public WindowedRoomDecorator(Window window, Room decoratedRoom) {
        super(decoratedRoom);
        this.window = window;
    }
}
