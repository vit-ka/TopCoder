import org.junit.Test;
import static org.junit.Assert.*;

public class AliceGameTest {
	
	@Test(timeout=2000)
	public void test0() {
		long x = 8L;
		long y = 17L;
		assertEquals(2L, new AliceGame().findMinimumValue(x, y));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long x = 17L;
		long y = 8L;
		assertEquals(3L, new AliceGame().findMinimumValue(x, y));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long x = 0L;
		long y = 0L;
		assertEquals(0L, new AliceGame().findMinimumValue(x, y));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long x = 9L;
		long y = 9L;
		assertEquals(-1L, new AliceGame().findMinimumValue(x, y));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long x = 500000L;
		long y = 500000L;
		assertEquals(294L, new AliceGame().findMinimumValue(x, y));
	}

	@Test(timeout=2000)
	public void test5() {
		long x = 2;
		long y = 999999999998L;
		assertEquals(-1, new AliceGame().findMinimumValue(x, y));
	}

	@Test(timeout=2000)
	public void test6() {
		long x = 2000001;
		long y = 999997999999L;
		assertEquals(3, new AliceGame().findMinimumValue(x, y));
	}

	@Test(timeout=2000)
	public void test7() {
		long x = 999999999998L;
		long y = 2;
		assertEquals(-1, new AliceGame().findMinimumValue(x, y));
	}
}
