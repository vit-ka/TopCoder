import org.junit.Test;
import static org.junit.Assert.*;

public class EllysSortingTrimmerTest {
	
	@Test(timeout=2000)
	public void test0() {
		String S = "ABRACADABRA";
		int L = 5;
		assertEquals("AAAAA", new EllysSortingTrimmer().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String S = "ESPRIT";
		int L = 3;
		assertEquals("EIP", new EllysSortingTrimmer().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String S = "BAZINGA";
		int L = 7;
		assertEquals("AABGINZ", new EllysSortingTrimmer().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String S = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int L = 13;
		assertEquals("ABCDEFGHIJKLM", new EllysSortingTrimmer().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String S = "GOODLUCKANDHAVEFUN";
		int L = 10;
		assertEquals("AACDDEFGHK", new EllysSortingTrimmer().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String S = "AAAWDIUAOIWDESBEAIWODJAWDBPOAWDUISAWDOOPAWD";
		int L = 21;
		assertEquals("AAAAAAAAABBDDDDDDDEEI", new EllysSortingTrimmer().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String S = "TOPCODER";
		int L = 3;
		assertEquals("CDT", new EllysSortingTrimmer().getMin(S, L));
	}
}
