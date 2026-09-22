package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
	
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;

	public CarRentalSystem() {
		cars = new ArrayList<>();
		customers=new ArrayList<>();
		rentals = new ArrayList<>();
	}
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void rentCar(Car car, Customer customer , int days) {
		if(car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car,customer,days));
		}
		else {
			System.out.println("Car is not available fo rent!");
		}	
	}
	public void returnCar(Car car) {
		car.returnCar();
		Rental rentalToRemove=null;
		for(Rental rental:rentals) {
			if(rental.getCar()==car) {
				rentalToRemove=rental;
				break;
			}
		}
		if(rentalToRemove!=null) {
			rentals.remove(rentalToRemove);
			System.out.println("Car returned successfully!");
		}
		else {
			System.out.println("Car was not rented!");
		}
	}
	
	public void menu() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		
		
		while(true) {
			System.out.println("-----CAR RENTAL SYSTEM-----");
			System.out.println("1.Rent a car");
			System.out.println("2.Return a car");
			System.out.println("3.Exit");
			System.out.print("Enter your choice: ");
			
			try {
				choice=Integer.parseInt(br.readLine());
			}
			catch(Exception e){
				System.err.println(e);
				e.printStackTrace();
			}
			if(choice==1) {
				
				String customerName = "";
				String carId = "";
				int rentalDays=0;
				String confirm="";
				System.out.println("\n---RENT A CAR---\n");
				System.out.print("Enter your name: ");
				try {
					customerName=br.readLine();
				} 
				catch (Exception e) {
					System.err.println(e);
					e.printStackTrace();
				}
				
				System.out.println("\nAvailable Cars: ");
				for (Car car:cars) {
					if(car.isAvailable()) {
						System.out.println(car.getCarId()+"-"+car.getBrand()+car.getModel());
					}
				}
				
				System.out.print("\nEnter the car ID you want to rent: ");
				try {
					carId=br.readLine();
				} 
				catch (Exception e) {
					System.err.println(e);
					e.printStackTrace();
				}
				
				System.out.print("\nEnter the number of days for rental: ");
				try {
					rentalDays=Integer.parseInt(br.readLine());
				} 
				catch (Exception e) {
					System.err.println(e);
					e.printStackTrace();
				}
				
				Customer newCustomer=new Customer("CUS"+(customers.size()+1),customerName);
				addCustomer(newCustomer);
				
				Car selectedCar=null;
				for(Car car:cars) {
					if(car.getCarId().equals(carId) && car.isAvailable()) {
						selectedCar=car;
						break;
					}
				}
				if(selectedCar!=null) {
					double totalPrice=selectedCar.calculatePrice(rentalDays);
					System.out.println("\n---RENTAL INFORMATION---\n");
					System.out.println("Customer ID: " + newCustomer.getCustomerId());
					System.out.println("Customer Name: " + newCustomer.getName());
					System.out.println("Car: "+selectedCar.getBrand() + " " + selectedCar.getModel());
					System.out.println("Rental Days: " + rentalDays);
					System.out.printf("Total Price: $%.2f%n",totalPrice);
					
					System.out.print("\nConfirm rental (Y/N): ");
					try {
						confirm=br.readLine();
					} 
					catch (IOException e) {
						System.err.println(e);
						e.printStackTrace();
					}
					
					if (confirm.equalsIgnoreCase("Y")) {
						rentCar(selectedCar,newCustomer,rentalDays);
							System.out.println("\nCar rented successfully");
					}
					else {
						System.out.println("\nRental Canceled");
					}
				}
				else {
					System.out.println("\nInvalid car selection/car is unavailable for rent ");
				}
			}
			else if(choice==2){
				String carId = "";
				System.out.println("\n---RETURN A CAR---\n");
				System.out.println("Enter the car ID you want to return: ");
				try {
					carId=br.readLine().trim();
				} 
				catch (IOException e) {
					System.err.println(e);
					e.printStackTrace();
				}
				Car carToReturn=null;
				for(Car car:cars) {
					if(car.getCarId().equalsIgnoreCase(carId) && !car.isAvailable()) {
						carToReturn=car;
						break;
					}
				}
				if(carToReturn != null) {
					Customer customer=null;
					for(Rental rental:rentals) {
						if(rental.getCar()==carToReturn) {
							customer=rental.getCustomer();
						}
					}
					if(customer!=null){
						returnCar(carToReturn);
						System.out.println("Car returned successfully"+customer.getName());
					}
					else {
						System.out.println("Car was not rental or rental information is missing");
					}
				}
				else {
					System.out.println("Invalid car ID or car is not rented");
				}
			}
			else if(choice==3) {
				break;
			}
			else {
				System.out.println("Invalid choice");
			}
		}
	}
}
