package sample.hibernate4;

public class Hawk extends Raptor {

	public static void main(String args[]) {

		System.out.println("Start Main Method");
		new Hawk();
		System.out.println("Leave Main Method");
	}

}

class Bird {
	{
		System.out.println("Bird1");
	}

	public Bird() {
		System.out.println("Bird2");
	}
}

class Raptor extends Bird {
	static {
		System.out.println("Raptor1");
	}

	public Raptor() {
		System.out.println("Raptor2");
	}

	{
		System.out.println("Raptor3");
	}
	
	static {
		System.out.println("Raptor4");
	}
}