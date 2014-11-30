import org.junit.Test;
import static org.junit.Assert.*;

public class GoodSubsetTest {
	
	@Test(timeout=2000)
	public void test0() {
		int goodValue = 10;
		int[] d = new int[] {2,3,4,5};
		assertEquals(1, new GoodSubset().numberOfSubsets(goodValue, d));
	}

	@Test(timeout=2000)
	public void test1() {
		int goodValue = 6;
		int[] d = new int[] {2,3,4,5,6};
		assertEquals(2, new GoodSubset().numberOfSubsets(goodValue, d));
	}

	@Test(timeout=2000)
	public void test2() {
		int goodValue = 1;
		int[] d = new int[] {1,1,1};
		assertEquals(7, new GoodSubset().numberOfSubsets(goodValue, d));
	}

	@Test(timeout=2000)
	public void test3() {
		int goodValue = 12;
		int[] d = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
		assertEquals(6, new GoodSubset().numberOfSubsets(goodValue, d));
	}

	@Test(timeout=2000)
	public void test4() {
		int goodValue = 5;
		int[] d = new int[] {1,2,3,4};
		assertEquals(0, new GoodSubset().numberOfSubsets(goodValue, d));
	}

	@Test(timeout=2000)
	public void test5() {
		int goodValue = 268435456;
		int[] d = new int[] {1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 8, 8, 16, 16, 32, 64, 128, 256, 512, 1024, 2048, 1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 8, 8, 16, 16, 32, 64, 128, 256, 512, 1024, 20481, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 8, 8, 16, 16, 32, 64, 128, 256, 512, 1024, 2048};
		assertEquals(275027197, new GoodSubset().numberOfSubsets(goodValue, d));
	}

}
