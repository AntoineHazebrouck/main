package antoine;

import lombok.Data;

@Data
public class Code implements Runnable {
	private final String value;

	@Override
	public void run() {
		System.out.println("running");
	}
	
}
