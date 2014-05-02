import org.junit.Test;
import static org.junit.Assert.*;

public class BridgeCrossingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] times = new int[] { 1, 2, 5, 10 };
		assertEquals(17, new BridgeCrossing().minTime(times));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] times = new int[] { 1, 2, 3, 4, 5 };
		assertEquals(16, new BridgeCrossing().minTime(times));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] times = new int[] { 100 };
		assertEquals(100, new BridgeCrossing().minTime(times));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] times = new int[] { 1, 2, 3, 50, 99, 100 };
		assertEquals(162, new BridgeCrossing().minTime(times));
	}
}
