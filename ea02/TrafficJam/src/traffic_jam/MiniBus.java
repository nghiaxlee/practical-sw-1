package traffic_jam;


public class MiniBus extends Vehicle{
    private static final String TYPE_NAME = "MiniBus";
    private static final long TIME_INTERVAL = 2000;
    
    public MiniBus(String vehicleName, double fuelConsumption, double fuelLevel) {
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
