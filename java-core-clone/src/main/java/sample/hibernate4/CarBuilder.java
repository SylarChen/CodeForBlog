package sample.hibernate4;

import java.util.LinkedHashSet;

import sample.hibernate4.car.Car;
import sample.hibernate4.car.CarMark;
import sample.hibernate4.car.Tire;
import sample.hibernate4.car.TirePosition;

public class CarBuilder {
	
	public static Car buidFerrari(){
		
		CarMark carMark = new CarMark("Ferrari", 70);
		
		LinkedHashSet<Tire> tireSet = new LinkedHashSet<Tire>();
		tireSet.add(new Tire(TirePosition.LEFT_FRONT, 0));
		tireSet.add(new Tire(TirePosition.RIGHT_FRONT, 0));
		tireSet.add(new Tire(TirePosition.LEFT_REAR, 0));
		tireSet.add(new Tire(TirePosition.RIGHT_REAR, 0));
		
		Car car = new Car(carMark, tireSet);
		
		return car;
		
	}
	
}
