package antoine;

public class AfficheA extends Thread {
	int no, lifetime;

	public AfficheA(int no, int lifetime) {
		this.no = no;
		this.lifetime = lifetime;
		this.start();
	}

	public void run() {
		for (int i = 0; i < lifetime; i++) {
			System.out.println("A " + no + "says hello " + i);
			Thread.yield();
		}
		System.out.println("A " + no + " completed\n");
	}
}
