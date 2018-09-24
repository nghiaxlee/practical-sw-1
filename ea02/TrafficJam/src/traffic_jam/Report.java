package traffic_jam;

public class Report {
    private final String vehicleType;
    private final String vehicleName;
    private final double fuelLevel;
    
    public Report(String vehicleType, String vehicleName, double fuelLevel) {
        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;
        this.fuelLevel = fuelLevel; 
    }
    
    public String vehicleType() {
        return vehicleType;
    }

    public String vehicleName() {
        return vehicleName;
    }

    public double fuelLevel() {
        return fuelLevel;
    }
    
    
}
