import org.junit.Test;
import static org.junit.Assert.*;

public class SilverbachConjectureTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 20;
        int[] result = new SilverbachConjecture().solve(n);
		assertEquals(n, result[0] + result[1]);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 30;
        int[] result = new SilverbachConjecture().solve(n);
        assertEquals(n, result[0] + result[1]);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 999;
        int[] result = new SilverbachConjecture().solve(n);
        assertEquals(n, result[0] + result[1]);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 45;
        int[] result = new SilverbachConjecture().solve(n);
        assertEquals(n, result[0] + result[1]);
	}
}
