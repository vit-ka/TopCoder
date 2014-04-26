import org.junit.Test;
import static org.junit.Assert.*;

public class EllysScrabbleTest {
	
	@Test(timeout=2000)
	public void test0() {
		String letters = "TOPCODER";
		int maxDistance = 3;
		assertEquals("CODTEPOR", new EllysScrabble().getMin(letters, maxDistance));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String letters = "ESPRIT";
		int maxDistance = 3;
		assertEquals("EIPRST", new EllysScrabble().getMin(letters, maxDistance));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String letters = "BAZINGA";
		int maxDistance = 8;
		assertEquals("AABGINZ", new EllysScrabble().getMin(letters, maxDistance));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int maxDistance = 9;
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", new EllysScrabble().getMin(letters, maxDistance));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String letters = "GOODLUCKANDHAVEFUN";
		int maxDistance = 7;
		assertEquals("CADDGAHEOOFLUKNNUV", new EllysScrabble().getMin(letters, maxDistance));
	}
	
	@Test//(timeout=2000)
	public void test5() {
		String letters = "AAAWDIUAOIWDESBEAIWODJAWDBPOAWDUISAWDOOPAWD";
		int maxDistance = 6;
		assertEquals("AAAADDEIBWAEUIODWADSBIAJWODIAWDOPOAWDUOSPWW", new EllysScrabble().getMin(letters, maxDistance));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String letters = "ABRACADABRA";
		int maxDistance = 2;
		assertEquals("AABARACBDAR", new EllysScrabble().getMin(letters, maxDistance));
	}
}
