import java.util.ArrayList;

/*
 * Create Car class which will be used as a container for `Passenger` objects
 */
public class Car {
    /*
     * a private `ArrayList` where it will store the `Passenger`s currently onboard
     */
    private ArrayList<Passenger> passengers;
    /*
     * an `int` for the `Car`'s maximum capacity
     */
    private int maxCapacity;

    /*
     * constructor
     * @param maxCapacity The maximum number of passengers the car can hold
     */
    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<Passenger>();
    }

    /*
     * accessor-like method that return the maximum capacity
     * @return maximum capacity
     */
    public int getCapacity() {
        return maxCapacity;
    }
    
    /*
     * accessor-like method that return the remaining seats
     * return remaining seats
     */
    public int seatsRemaining() {
        int seatsOccupied = passengers.size();
        int seatsRemained = maxCapacity - seatsOccupied;
        return seatsRemained;
    }

    /*
     * method to add a `Passenger` from the `Car`
     * @param p passenger to add
     * @throws RuntimeException If the passenger is already onboard or if the car is at full capacity
     */
    public void addPassenger(Passenger p) {
        int seatsOccupied = passengers.size();
        if (seatsOccupied < maxCapacity) {
            if (p instanceof Passenger){
                throw new RuntimeException("Passenger already onboard");
            }
            else{
                passengers.add(p);
            }
        }
        else{
            throw new RuntimeException("Car in full capacity");
        }
    }

    /*
     * method to confirm that the `Passenger` is actually onboard
     * @param p passenger to check
     * @return  if passenger is onboard
     */
    public boolean containsPassenger(Passenger p) {
        return passengers.contains(p);
    }   

    /*
     * method to remove a `Passenger` from the `Car`
     * @param p passenger to remove
     * @throws RuntimeException If the passenger is not onboard
     */
    public void removePassenger(Passenger p) {
        if (passengers.contains(p)) {
            passengers.remove(p);
        } 
        else{
            throw new RuntimeException("Passenger not onboard");
        }
    }

    /*
     * method that prints out a list of all `Passenger`s aboard the car
     * @return a list of all `Passenger`s aboard the car (or "This car is EMPTY." if there is no one on board)
     */
    public void printManifest(){
        int seatsOccupied = passengers.size();
        if (seatsOccupied > 0) {
            for (Passenger p : passengers) {
                System.out.println(p);
        }
    }
        else {
            System.out.println("This car is EMPTY.");
        }
        }
        
    }