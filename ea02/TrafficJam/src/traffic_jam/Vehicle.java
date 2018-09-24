package traffic_jam;

public abstract class Vehicle {
    
    protected final double fuelConsumption;
    protected final String vehicleName;
    protected double fuelLevel;
    
    public Vehicle(String vehicleName, double fuelConsumption, double fuelLevel) {
        this.vehicleName = vehicleName;
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
    }
    
    protected abstract String vehicleType();
    protected abstract long timeInterval();
            
    public double fuelConsumption() {
        return this.fuelConsumption;
    }
    
    public double fuelLevel() {
        return this.fuelLevel;
    }
    
    public void start() {
        new Thread(
                () -> {
                    boolean stalled = false;
                    while(!stalled){
                        Report report = new Report(vehicleType(), vehicleName, fuelLevel);
                        Traffic.getInstance().sendReport(report);
                        stalled = fuelLevel < 0.0;
                        fuelLevel -= fuelConsumption;
                        try {
                            Thread.sleep(timeInterval());
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            ).start();
    }
    
    
}
