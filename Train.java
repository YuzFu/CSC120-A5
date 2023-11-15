import java.util.ArrayList;

/*
 * create Train class which will tie them all together
 */
public class Train {
    /*
     * a private attribute which we will mark with the keyword `final` to establish the composition relationship
     */
    private final Engine engine;
    /*
     * a private to keep track of the `Car`s currently attached
     */
    private ArrayList<Car> cars;

    /*
     * a constructor which will initialize the `Engine` and `Car`s and store them
     * @param fuel type, fuel capacity, number of cars, passenger capacity
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        engine = new Engine(fuelType, passengerCapacity);
        cars = new ArrayList<Car>();
        for (int i = 0; i < nCars; i++) {
            cars.add(new Car(passengerCapacity));
        }
    }

    /*
     * an accessor to return engine
     * @return engine
     */
    public Engine getEngine() {
        return engine;
    }

    /*
     * an accessor ro return the `i`th car
     * @return i th car
     */
    public Car getCar(int i) {
        return cars.get(i);
    }

    /*
     * an accessor which will return the maximum total capacity across all `Car`s
     * @return totalMaxCapacity
     */
    public int getMaxCapacity() {
        int totalMaxCapacity = 0;
        for (Car car : cars) {
            totalMaxCapacity += car. getCapacity();
        }
        return totalMaxCapacity;
    }

    /*
     * an accessor which will return the number of remaining open seats across all `Car`s
     * @return totalSeatsRemained
     */    
    public int seatsRemaining() {
            int totalSeatsRemained = 0;
        for (Car car : cars) {
            totalSeatsRemained += car.seatsRemaining();
        }
        return totalSeatsRemained;
    }

    /*
     * a method that prints a roster of all `Passenger`s onboard
     * @return a roster of all `Passenger`s onboard or a message of "This train is EMPTY."
     */
    public void printManifest() {
        int seatsOccupied = 0;
        for (Car car : cars) {
            seatsOccupied += car.seatsRemaining();
        }
        if (seatsOccupied > 0) {
            for (Car car : cars) {
            car.printManifest();
        }
    }
        else {
            System.out.println("This train is EMPTY.");
        }
        }
    }
