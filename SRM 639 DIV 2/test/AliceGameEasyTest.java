import org.junit.Test;
import static org.junit.Assert.*;

public class AliceGameEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		long x = 7L;
		long y = 14L;
		assertEquals(2L, new AliceGameEasy().findMinimumValue(x, y));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long x = 10L;
		long y = 0L;
		assertEquals(4L, new AliceGameEasy().findMinimumValue(x, y));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long x = 932599670050L;
		long y = 67400241741L;
		assertEquals(1047062L, new AliceGameEasy().findMinimumValue(x, y));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long x = 7L;
		long y = 13L;
		assertEquals(-1L, new AliceGameEasy().findMinimumValue(x, y));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long x = 0L;
		long y = 0L;
		assertEquals(0L, new AliceGameEasy().findMinimumValue(x, y));
	}
	
	@Test(timeout=2000)
	public void test5() {
		long x = 100000L;
		long y = 400500L;
		assertEquals(106L, new AliceGameEasy().findMinimumValue(x, y));
	}
}
