import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] prices = new String[] {"100 100 100"};
		String[] purchases = new String[] {"0,0:0", "0,2:5", "0,1:10"};
		assertEquals(4, new VendingMachine().motorUse(prices, purchases));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] prices = new String[] {"100 200 300 400 500 600"};
		String[] purchases = new String[] {"0,2:0", "0,3:5", "0,1:10", "0,4:15"};
		assertEquals(17, new VendingMachine().motorUse(prices, purchases));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] prices = new String[] {"100 200 300 400 500 600"};
		String[] purchases = new String[] {"0,2:0", "0,3:4", "0,1:8", "0,4:12"};
		assertEquals(11, new VendingMachine().motorUse(prices, purchases));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] prices = new String[] {"100 100 100"};
		String[] purchases = new String[] {"0,0:10", "0,0:11"};
		assertEquals(-1, new VendingMachine().motorUse(prices, purchases));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] prices = new String[] {"100 200 300",
 "600 500 400"};
		String[] purchases = new String[] {"0,0:0", "1,1:10", "1,2:20",
 "0,1:21", "1,0:22", "0,2:35"};
		assertEquals(6, new VendingMachine().motorUse(prices, purchases));
	}
}
