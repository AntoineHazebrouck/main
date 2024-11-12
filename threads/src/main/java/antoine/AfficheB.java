package antoine;

public class AfficheB implements Runnable {
	int no, lifetime;
	Thread t;

	public AfficheB(int no, int lifetime) {
		this.no = no;
		this.lifetime = lifetime;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		for (int i = 0; i < lifetime; i++) {
			System.out.println("B " + no + "says hello " + i);
			Thread.yield();
		}
		System.out.println("B " + no + " completed\n");
	}

	public void join() throws InterruptedException {
		t.join();
	}
}