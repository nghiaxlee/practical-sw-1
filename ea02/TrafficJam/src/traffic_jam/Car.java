package traffic_jam;

public class Car extends Vehicle{
    private static final String TYPE_NAME = "Car";
    private static final long TIME_INTERVAL = 1000;

    public Car(String vehicleName, double fuelConsumption, double fuelLevel) {
        super(vehicleName, fuelConsumption, fuelLevel);
    }
    
    @Override
    public String vehicleType() {
        return TYPE_NAME;
    }

    @Override
    protected long timeInterval() {
        return TIME_INTERVAL;
    }
    
}
