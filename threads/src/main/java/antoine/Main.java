package antoine;

public class Main {
	public static void main(String args[]) throws InterruptedException {
		String tre = "tre";
		Thread thread = new Thread(new Code(tre), "running thread");

		thread.start();


		
		System.out.println("End of program" + tre);
	}
}
