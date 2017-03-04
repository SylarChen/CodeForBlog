package sample.hibernate4.car;

import java.io.Serializable;

public class CarMark implements Serializable {

	private static final long serialVersionUID = -840209218449463080L;
	
	private String name;
	private int historyInYears;

	public CarMark(String name, int historyInYears) {
		super();
		this.name = name;
		this.historyInYears = historyInYears;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHistoryInYears() {
		return historyInYears;
	}

	public void setHistoryInYears(int historyInYears) {
		this.historyInYears = historyInYears;
	}

}
