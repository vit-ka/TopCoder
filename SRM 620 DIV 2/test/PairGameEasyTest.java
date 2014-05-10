import org.junit.Test;
import static org.junit.Assert.*;

public class PairGameEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 5;
		assertEquals("Able to generate", new PairGameEasy().able(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int a = 1;
		int b = 2;
		int c = 2;
		int d = 1;
		assertEquals("Not able to generate", new PairGameEasy().able(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int a = 2;
		int b = 2;
		int c = 2;
		int d = 999;
		assertEquals("Not able to generate", new PairGameEasy().able(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int a = 2;
		int b = 2;
		int c = 2;
		int d = 1000;
		assertEquals("Able to generate", new PairGameEasy().able(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int a = 47;
		int b = 58;
		int c = 384;
		int d = 221;
		assertEquals("Able to generate", new PairGameEasy().able(a, b, c, d));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int a = 1000;
		int b = 1000;
		int c = 1000;
		int d = 1000;
		assertEquals("Able to generate", new PairGameEasy().able(a, b, c, d));
	}
}
