package com;

import java.util.ArrayList;
import java.util.List;

public class Main{

	public static void main(String[] args) {
		CarRentalSystem rentalSystem = new CarRentalSystem();
		
		List<Car>mycars = new ArrayList<Car>();
		mycars.add(new Car("C001","Toyota","Canary",600.0));
		mycars.add(new Car("C002", "Lamborghini", "Aventador", 1500.0));
		mycars.add(new Car("C003", "Rolls Royce", "Phantom", 1200.0));
		mycars.add(new Car("C004", "Ferrari", "488 Spider", 1350.0));
		mycars.add(new Car("C005", "Bentley", "Continental GT", 900.0));
		mycars.add(new Car("C006", "Porsche", "911 Carrera", 650.0));
		mycars.add(new Car("C007", "Mercedes", "G-Wagon", 700.0));
		mycars.add(new Car("C008", "McLaren", "720S", 1400.0));
		mycars.add(new Car("C009", "Aston Martin", "DB11", 850.0));
		mycars.add(new Car("C015", "Pagani", "Huayra", 2800.0));
		
		for(int i=0;i<mycars.size();i++) {
			rentalSystem.addCar(mycars.get(i));
		}
//		for(Car currentcar :mycars) {
//			rentalSystem.addCar(currentcar);
//		}
		rentalSystem.menu();
	}

}
