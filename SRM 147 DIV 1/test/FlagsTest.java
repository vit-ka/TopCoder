import org.junit.Test;
import static org.junit.Assert.*;

public class FlagsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String numFlags = "10";
		String[] forbidden = new String[] {"0","1 2","1 2"};
		assertEquals(3L, new Flags().numStripes(numFlags, forbidden));
	}
	
	@Test//(timeout=2000)
	public void test1() {
		String numFlags = "100";
		String[] forbidden = new String[] {"0","1","2"};
		assertEquals(6L, new Flags().numStripes(numFlags, forbidden));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String numFlags = "100000000000000000";
		String[] forbidden = new String[] {"0","1"};
		assertEquals(50000000000000000L, new Flags().numStripes(numFlags, forbidden));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String numFlags = "10000000000000000";
		String[] forbidden = new String[] {"0 1", "0 1", "2 3 4", "2 3 4", "2 3 4"};
		assertEquals(40L, new Flags().numStripes(numFlags, forbidden));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String numFlags = "10000000000000000";
		String[] forbidden = new String[] {"0 1 2 3 4 5 6 7 8 9", "0 1 3 4 5 6 7 8 9", "0 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9", 
"0 1 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9", 
"0 1 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9", "0 1 2 3 4 5 6 7 8 9"};
		assertEquals(4999999999999996L, new Flags().numStripes(numFlags, forbidden));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String numFlags = "5";
		String[] forbidden = new String[] {"0","1","2","3","4","5"};
		assertEquals(1L, new Flags().numStripes(numFlags, forbidden));
	}
}
