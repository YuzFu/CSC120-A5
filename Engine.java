public class Engine {
    /**
     * Attributes
     */
    private FuelType fuelType;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /*
     * constructor
    */
    public Engine(FuelType fuelType, double maxFuelLevel) {
        this.fuelType = fuelType;
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = maxFuelLevel; // Initialize current fuel to max level
    }

    /*
     * methods
     */
    public void refuel() {
        currentFuelLevel = maxFuelLevel;
    }

    public void go() {
        if (currentFuelLevel > 0) {
            currentFuelLevel -= 1.0; // You can change the amount you want to decrease by
            System.out.println("Remaining fuel level: " + currentFuelLevel);
        } else {
            throw new RuntimeException("Out of fuel");
        }
    }

    // public FuelType getFuelType() {
    //     return fuelType;
    // }

    // public double getCurrentFuelLevel() {
    //     return currentFuelLevel;
    // }

    // public double getMaxFuelLevel() {
    //     return maxFuelLevel;
    // }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}