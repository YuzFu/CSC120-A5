import java.util.ArrayList;

public class Car {
    /**
     * Attributes
     */
    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    /*
     * constructor
    */
    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<Passenger>();
    }

    /*
     * methods
     */
    public int getCapacity() {
        return maxCapacity;
    }
    
    public int seatsRemaining() {
        int seatsOccupied = passengers.size();
        int seatsRemained = maxCapacity - seatsOccupied;
        return seatsRemained;
    }

    public void addPassenger(Passenger p) {
        int seatsOccupied = passengers.size();
        if (seatsOccupied < maxCapacity) {
            passengers.add(p);
        }
        else{
            throw new RuntimeException("Car in full capacity");
        }
    }

    public boolean containsPassenger(Passenger p) {
        return passengers.contains(p);
    }   

    public void removePassenger(Passenger p) {
        if (passengers.contains(p)) {
            passengers.remove(p);
        } 
        else{
            throw new RuntimeException("Passenger not onboard");
        }
    }

    public void printManifest(){
        int seatsOccupied = passengers.size();
        if (seatsOccupied > 0) {
            for (int i = 0; i < maxCapacity; i++) {
            Passenger passenger = passengers.get(i);
            System.out.println(passenger);
        }
    }
        else {
            System.out.println("This car is EMPTY.");
        }
        }
        
    }