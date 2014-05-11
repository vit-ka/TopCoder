import org.junit.Test;
import static org.junit.Assert.*;

public class PairGameTest {
	
	@Test(timeout=2000)
	public void test0() {
		int a = 1;
		int b = 2;
		int c = 2;
		int d = 1;
		assertEquals(2, new PairGame().maxSum(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int a = 15;
		int b = 4;
		int c = 10;
		int d = 7;
		assertEquals(7, new PairGame().maxSum(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int a = 1;
		int b = 1;
		int c = 10;
		int d = 10;
		assertEquals(-1, new PairGame().maxSum(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int a = 1000;
		int b = 1001;
		int c = 2000;
		int d = 2001;
		assertEquals(1001, new PairGame().maxSum(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int a = 10944;
		int b = 17928;
		int c = 7704;
		int d = 21888;
		assertEquals(144, new PairGame().maxSum(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int a = 1;
		int b = 1;
		int c = 1;
		int d = 1;
		assertEquals(2, new PairGame().maxSum(a, b, c, d));
	}

    @Test(timeout=2000)
    public void test6() {
        int a = 1000000;
        int b = 1;
        int c = 1000000;
        int d = 1;
        assertEquals(1000001, new PairGame().maxSum(a, b, c, d));
    }
}
