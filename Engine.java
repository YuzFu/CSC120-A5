/*
 * Create Engine class which will represent the locomotive engine, storing information about its fuel type, level, etc.
 */
public class Engine {
    /**
     * a private attribute to indicate what type of fuel it uses
     */
    private FuelType fuelType;
    /*
     * a private attribute to store the current fuel level
     */
    private double currentFuelLevel;
    /*
     * a private attribute to store the maximum fuel level
     */
    private double maxFuelLevel;

    /*
     * a constructor which takes in initial values for the attributes named above and sets them appropriately
     * @param fuelType
     * @param maxFuelLevel
    */
    public Engine(FuelType fuelType, double maxFuelLevel) {
        this.fuelType = fuelType;
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = maxFuelLevel;
    }

    /*
     * accessors to return FuelType
     * @return fueltype
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /*
     * accessors to return current fuel level
     * @return current fuel level
     */
    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    /*
     * accessors to return max fuel level
     * @return max fuel level
     */    
    public double getMaxFuelLevel() {
        return maxFuelLevel;
    }

    /*
     * a method which will reset the `Engine`'s current fuel level to the maximum
     */
    public void refuel() {
        currentFuelLevel = maxFuelLevel;
    }

    /*
     * a method which will decrease the current fuel level and print some useful information
     * @return currentFuelLevel
     * @throw RuntimeException and "Out of fuel"
     */
    public void go() {
        if (currentFuelLevel >= 1.0) {
            currentFuelLevel = 1.0; // You can change the amount you want to decrease by
            System.out.println("Remaining fuel level: " + currentFuelLevel);
        } else {
            throw new RuntimeException("Out of fuel");
        }
    }

    /*
     * the method defined below as a starting point for testing:
     */
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