package sample.hibernate4.car;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class Car implements Cloneable, Serializable{

	private static final long serialVersionUID = 855536990529969854L;
	
	private CarMark carMark;
	
	private LinkedHashSet<Tire> tireSet;

	public Car(CarMark carMark, LinkedHashSet<Tire> tireSet) {
		super();
		this.carMark = carMark;
		this.tireSet = tireSet;
	}

	public CarMark getCarMark() {
		return carMark;
	}

	public void setCarMark(CarMark carMark) {
		this.carMark = carMark;
	}

	public LinkedHashSet<Tire> getTireSet() {
		return tireSet;
	}

	public void setTireSet(LinkedHashSet<Tire> tireSet) {
		this.tireSet = tireSet;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
