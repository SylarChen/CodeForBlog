package sample.hibernate4;

public class Swap {

	public static void main(String args[]) {
		String name[] = { "Killer", "Miller" };
		String name0 = "Killer";
		String name1 = "Miller";
		swap(name0, name1);
		System.out.println(name0 + ", " + name1);
		swap(name);
		System.out.println(name[0] + ", " + name[1]);
	}

	public static void swap(String name[]) {
		String temp;
		temp = name[0];
		name[0] = name[1];
		name[1] = temp;
	}

	public static void swap(String name0, String name1) {
		String temp;
		temp = name0;
		name0 = name1;
		name1 = temp;
	}

}
