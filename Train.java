import java.util.ArrayList;

public class Train {
    /*
     * Attributes
     */
    private final Engine engine;
    private ArrayList<Car> cars;

    /*
     * constructor
    */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        engine = new Engine(fuelType, passengerCapacity);
        cars = new ArrayList<Car>();
        for (int i = 0; i < nCars; i++) {
            cars.add(new Car(passengerCapacity));
        }
    }

    /*
     * methods
     */
    public Engine getEngine() {
        return engine;
    }

    public Car getCar(int i) {
        return cars.get(i);
    }

    public int getMaxCapacity() {
        int totalMaxCapacity = 0;
        for (Car car : cars) {
            totalMaxCapacity += car. getCapacity();
        }
        return totalMaxCapacity;
    }
    public int seatsRemaining() {
            int totalSeatsRemained = 0;
        for (Car car : cars) {
            totalSeatsRemained += car.seatsRemaining();
        }
        return totalSeatsRemained;
    }

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
