# CSC120-A5: Bringing it All Together

## Outline
In this assignment, we'll explore Association by building a virtual Train!

![A cartoon train with an engine and three passenger cars](https://jcrouser.github.io/CSC120/img/train.jpeg)

As before, all the files necessary for this assignment are contained within this repository. When you submit, please remember to include:

 - all files necessary to compile your program
 - `reflection.md` containing your reflections and notes
 - `rubric.md` where you document which elements of the assignment you have attempted and/or completed.
 
##  Program files
For this assignment, you'll be writing four interrelated classes:

 - The `Passenger` class (`Passenger.java`) will store information about an individual passenger
 - The `Engine` class (`Engine.java`) will represent the locomotive engine, storing information about its fuel type, level, etc.
 - The `Car` class (`Car.java`) will be used as a container for `Passenger` objects
 - and the `Train` (`Train.java`) class will tie them all together
 
 You'll also notice a 5th file in the repository (`FuelType.java`), which contains something that looks like an extremely simple class:
 ```
public enum FuelType {
    STEAM, INTERNAL_COMBUSTION, ELECTRIC, OTHER;
}
```
In Java, we can use the keyword `enum` to establish simple type that must take as its value one of a set of predefined constant values. We'll use this in the `Engine` class instead of a `String` to keep track of what kind of fuel the `Engine` uses. You don't need to change this file, but you can use the values it contains like this:

```
FuelType f = FuelType.ELECTRIC;
```

## Relationships between the Classes
 
Let's pause a moment to think about the different kinds of relationships we'll want to establish:

 - The `Train` class should have a **composition** relationship with the `Engine` class (if you remove the `Engine`, it ceases to be a `Train`, and if you destroy the `Train`, you get rid of the `Engine` as well).
 - The `Train` class has an **aggregation** relationship with the `Car` class (the `Train` has a collection of `Cars` associated with it at any given time, but you can add / remove `Cars` without destroying either the `Train` or the `Cars` themselves).
 - The `Passenger` class has **association** relationships with the `Car` class (`Passenger`s board `Car`s as their means of using the `Train` to move around more efficiently).
 
 ## Step 1: The `Engine` class
 We recommend you start by implementing the `Engine` class. Your `Engine` class will need:
 
  - a private `FuelType` attribute to indicate what type of fuel it uses, and `double`s to store the current and maximum fuel levels (along with an appropriate accessors for each)
  - a constructor, which takes in initial values for the attributes named above and sets them appropriately
  - a method `public void refuel()` which will reset the `Engine`'s current fuel level to the maximum
  - a method `public void go()` which will decrease the current fuel level and print some useful information (e.g. remaining fuel level) provided the fuel level is above 0 (otherwise it should throw a `RuntimeException` containing an informative message)
 
You can use the `main` method defined below as a starting point for testing:
 ```
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
```

## Step 2: the `Car` class
Next, we'll set to work on the `Car` class. The `Car` class will need:

 - a private `ArrayList` where it will store the `Passenger`s currently onboard, and an `int` for the `Car`'s maximum capacity (since `ArrayList`s will expand as we add objects, we'll need to manually limit their size)
 - a constructor, which takes in an initial value for the `Car`'s maximum capacity and initializes an appropriately-sized `ArrayList`
 - accessor-like methods `public int getCapacity()` and `public int seatsRemaining()` that return the maximum capacity and remaining seats, respectively
 - methods `public void addPassenger(Passenger p)` and `public void removePassenger(Passenger p)` to add or remove a `Passenger` from the `Car` (_Hint: don't forget to check that there are seats available if someone wants to board, and to confirm that the `Passenger` is actually onboard before trying to remove them! If you encounter a problem, throw a `RuntimeException`._)
 - and a final method `public void printManifest()` that prints out a list of all `Passenger`s aboard the car (or "This car is EMPTY." if there is no one on board)

## Step 3: completing the `Passenger` class
Now that you've got a functional `Car` class, the `Passenger` class can be expanded to use the `Car`'s methods to implement some of its own:

 - `public void boardCar(Car c)` can call `c.addPassenger(this)` to board a given `Car` (_Hint: this method should be ready to `catch` the `RuntimeException` that will be thrown by `c.addPassenger(...)` in the event that the car is full._)
 - `public void getOffCar(Car c)` can call `c.removePassenger(this)` to get off a given `Car` (_Hint: this method should be ready to `catch` the `RuntimeException` that will be thrown by `c.removePassenger(...)` in the event that the `Passenger` wasn't actually onboard._)

## Step 4: the `Train` class
Now we're in the home stretch! To assemble your `Train`, you'll need (at minimum):

 -  a private `Engine` attribute, which we will mark with the keyword `final` to establish the **composition** relationship (e.g. `private final Engine engine;`)
 -  a private `ArrayList` to keep track of the `Car`s currently attached
 -  a constructor `public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity)` which will initialize the `Engine` and `Car`s and store them
 -  a couple of accessors: 
     -  `public Engine getEngine()`
     -  `public Car getCar(int i)` to return the `i`th car
     -  `public int getMaxCapacity()` which will return the maximum total capacity across all `Car`s
     -  `public int seatsRemaining()` which will return the number of remaining open seats across all `Car`s
- and finally, its own `public void printManifest()` that prints a roster of all `Passenger`s onboard (_Hint: your `Car`s can help!_)
