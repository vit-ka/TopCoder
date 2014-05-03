import org.junit.Test;
import static org.junit.Assert.*;

public class LongWordsDiv1Test {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 1;
		assertEquals(1, new LongWordsDiv1().count(n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 2;
		assertEquals(2, new LongWordsDiv1().count(n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 5;
		assertEquals(1080, new LongWordsDiv1().count(n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 100;
		assertEquals(486425238, new LongWordsDiv1().count(n));
	}
}
