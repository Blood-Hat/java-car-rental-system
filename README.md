# Car Rental System in Java

A console-based car rental application that I built while learning object-oriented programming in Java. The project models cars, customers, and rentals as separate classes and connects them through a menu-driven rental system.

## Features

- Displays the cars that are currently available
- Creates a customer record during the rental process
- Calculates the rental price from the daily rate and number of days
- Marks a selected car as unavailable after a confirmed rental
- Returns a rented car and makes it available again
- Keeps active rental information while the program is running

## Object-oriented design

| Class | Responsibility |
| --- | --- |
| `Car` | Stores vehicle details, pricing, and availability |
| `Customer` | Stores the generated customer ID and customer name |
| `Rental` | Connects a customer, a car, and the rental duration |
| `CarRentalSystem` | Manages the collections and the rent/return workflow |
| `Main` | Adds sample cars and starts the menu |

This structure helped me practise encapsulation, constructors, object relationships, Java collections, and updating an object's state through methods.

## Run the project

You need a Java Development Kit (JDK) installed.

From the project folder, compile the source files:

```text
javac -d build src/com/Car.java src/com/Customer.java src/com/Rental.java src/com/CarRentalSystem.java src/com/Main.java
```

Then start the program:

```text
java -cp build com.Main
```

You can also import the folder into Eclipse and run `Main.java`.

## Example workflow

1. Choose **Rent a car**.
2. Enter a name, an available car ID, and the rental duration.
3. Review the calculated price and confirm the rental.
4. Choose **Return a car** and enter the same car ID to return it.

## Current limitations and future improvements

This is a learning project and currently stores all data in memory, so rentals reset when the program closes. Input validation also needs improvement: rental days should be restricted to positive numbers, and invalid numeric input should return to the menu cleanly. Future versions could add persistent storage, a graphical interface, clearer status messages, and automated tests.

## Author

**Abhra Chowdhury** — [Blood-Hat](https://github.com/Blood-Hat)

I built this project as part of my Java learning journey, using the knowledge and understanding I gathered while practising object-oriented programming.
