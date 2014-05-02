import org.junit.Test;
import static org.junit.Assert.*;

public class GoldenChainTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] sections = new int[] {3,3,3,3};
		assertEquals(3, new GoldenChain().minCuts(sections));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] sections = new int[] {2000000000};
		assertEquals(1, new GoldenChain().minCuts(sections));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] sections = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,
38,39,40,41,42,43,44,45,46,47,48,49,50};
		assertEquals(42, new GoldenChain().minCuts(sections));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] sections = new int[] {20000000,20000000,2000000000};
		assertEquals(3, new GoldenChain().minCuts(sections));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] sections = new int[] {10,10,10,10,10,1,1,1,1,1};
		assertEquals(5, new GoldenChain().minCuts(sections));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] sections = new int[] {1,10};
		assertEquals(1, new GoldenChain().minCuts(sections));
	}
}
