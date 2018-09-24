package traffic_jam;

public class Traffic {
    private static Traffic instance;
   
    public static synchronized Traffic getInstance() {
        if (instance == null) {
            instance = new Traffic();
        }
        return instance;
    }
    
    public synchronized void sendReport(Report report) {
        String fuelLevelMeter = report.fuelLevel() > 0.0
                ? Double.toString(report.fuelLevel())
                : "stalled";
        
        System.out.println(report.vehicleName() + "," + report.vehicleType() + ": " +
                fuelLevelMeter);
    }
}
