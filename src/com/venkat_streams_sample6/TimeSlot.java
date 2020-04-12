package venkat_streams_sample6;

import java.util.Random;

public class TimeSlot {
	static Random random=new Random();

	public boolean isAvailable() {
		// ...
		return random.nextBoolean();
	}

	public void schedule() {
		// ...
		
	}

}
