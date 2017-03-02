package sample.hibernate4;

public class Car implements IVehicle {
	
	public void start() {
		System.out.println("Car started");
	}

	public void stop() {
		System.out.println("Car stopped");
	}

	public void forward() {
		System.out.println("Car forwarded");
	}

	public void reverse() {
		System.out.println("Car reversed");
	}
	
}
