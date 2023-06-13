package unitTest;

import org.testng.annotations.Test;

import common.Constants;

public class UnitTest {
	
	@Test
	public void endPointEnumTest() {
		System.out.println(Constants.POSTS.getName());
	}

}
