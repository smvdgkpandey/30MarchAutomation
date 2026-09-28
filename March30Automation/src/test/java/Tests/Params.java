package Tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Params {
	
	
	
	@Parameters({"brow"})
	@Test
	public void run(String browser) {
		System.out.println(browser);
	}

}
