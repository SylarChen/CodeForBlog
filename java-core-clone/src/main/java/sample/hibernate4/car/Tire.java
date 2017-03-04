package sample.hibernate4.car;

import java.io.Serializable;

public class Tire implements Serializable{

	private static final long serialVersionUID = -4185789610721446662L;
	
	private TirePosition tirePosition;
	private int wear;
	
	public Tire(TirePosition tirePosition, int wear) {
		super();
		this.tirePosition = tirePosition;
		this.wear = wear;
	}
	
	public TirePosition getTirePosition() {
		return tirePosition;
	}
	public void setTirePosition(TirePosition tirePosition) {
		this.tirePosition = tirePosition;
	}
	public int getWear() {
		return wear;
	}
	public void setWear(int wear) {
		this.wear = wear;
	}
	
}

