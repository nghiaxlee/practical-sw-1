package traffic_jam;

public class TrafficJam {

    public static void main(String[] args) {
        new Car("car1", 12.0, 73.4).start();
        new Car("car2", 12.0, 120.9).start();
        new MiniBus("minibus1", 120.0, 730.4).start();
        new MiniBus("minibus2", 120.0, 1200.923).start();
    }
    
}
