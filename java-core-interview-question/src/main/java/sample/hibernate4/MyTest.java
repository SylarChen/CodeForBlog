package sample.hibernate4;

public class MyTest {
	String s;

	public static void main(String[] args) {
		MyTest obj = new MyTest();
		obj.go();
	}

	private MyTest() {
		s = "this is a test";
	}

	void go() {
		System.out.println(s);
	}
}