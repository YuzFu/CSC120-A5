/*
 * Create Passenger class which will store information about an individual passenger
 */
public class Passenger {
    /*
     * a private attribute to indicate passenger name
     */
    private String name;

    /*
     * constructor
     * @param name  passenger name
    */
    public Passenger(String name) {
        this.name = name;
    }

    /*
     * a method that can call `c.addPassenger(this)` to board a given `Car`
     * @param c
     * @catch the RuntimeException that will be thrown by `c.addPassenger(...)` in the event that the car is full
     */
    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
        } catch (Exception e) {
            throw new RuntimeException("Car in full capacity");
        }
    }

    /*
     * a method that can call `c.removePassenger(this)` to get off a given `Car`
     * @param c
     * @catch the RuntimeException that will be thrown by `c.removePassenger(...)` in the event that the `Passenger` wasn't actually onboard
     */   
    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
        } 
        catch (Exception e){
            throw new RuntimeException("Passenger not onboard");
        }
    }
}
