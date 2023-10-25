public class Passenger {
    /*
     * Attributes
     */
    private String name;

    /*
     * constructor
    */
    public Passenger(String name) {
        this.name = name;
    }

    /*
     * methods
     */
    public void boardCar(Car c) {
        int seatsR = c.seatsRemaining();
        if (seatsR > 0) {
            c.addPassenger(this);
        }
        else {
            throw new RuntimeException("Car in full capacity");
        }  
    }

    public void getOffCar(Car c) {
        if (c.containsPassenger(this)) {
            c.removePassenger(this);
        } 
        else{
            throw new RuntimeException("Passenger not onboard");
        }
    }
}
