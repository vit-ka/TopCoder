import org.junit.Test;
import static org.junit.Assert.*;

public class StringsNightmareAgainTest {
	
	@Test(timeout=2000)
	public void test0() {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int n = 4;
		assertEquals(2L, new StringsNightmareAgain().UniqueSubstrings(a, b, c, d, n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int a = 2;
		int b = 3;
		int c = 1;
		int d = 1;
		int n = 6;
		assertEquals(3L, new StringsNightmareAgain().UniqueSubstrings(a, b, c, d, n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int a = 4;
		int b = 3;
		int c = 1;
		int d = 1;
		int n = 6;
		assertEquals(3L, new StringsNightmareAgain().UniqueSubstrings(a, b, c, d, n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int a = 4;
		int b = 3;
		int c = 3;
		int d = 3;
		int n = 10;
		assertEquals(5L, new StringsNightmareAgain().UniqueSubstrings(a, b, c, d, n));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int a = 5;
		int b = 3;
		int c = 2;
		int d = 3;
		int n = 11;
		assertEquals(9L, new StringsNightmareAgain().UniqueSubstrings(a, b, c, d, n));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int a = 10;
		int b = 1000000;
		int c = 1000000;
		int d = 1;
		int n = 51;
		assertEquals(63L, new StringsNightmareAgain().UniqueSubstrings(a, b, c, d, n));
	}
}
