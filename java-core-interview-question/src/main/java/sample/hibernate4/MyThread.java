package sample.hibernate4;

public class MyThread extends Thread {
	String myName;

	MyThread(String name) {
		myName = name;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(myName);
		}
	}

	public static void main(String args[]) throws InterruptedException {
		MyThread mtl = new MyThread("mt1");
		MyThread mt2 = new MyThread("mt2");
		mtl.start();
		// XXX
		// mtl.join();
		mt2.start();
	}
}
