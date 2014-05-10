import org.junit.Test;
import static org.junit.Assert.*;

public class RandomGraphTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 7;
		int p = 0;
		assertEquals(0.0, new RandomGraph().probability(n, p), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 3;
		int p = 620;
		assertEquals(0.0, new RandomGraph().probability(n, p), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 4;
		int p = 500;
		assertEquals(0.59375, new RandomGraph().probability(n, p), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 8;
		int p = 100;
		assertEquals(0.33566851611343496, new RandomGraph().probability(n, p), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test4() {
		int n = 15;
		int p = 50;
		assertEquals(0.5686761670525845, new RandomGraph().probability(n, p), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test5() {
		int n = 50;
		int p = 10;
		assertEquals(0.7494276522159893, new RandomGraph().probability(n, p), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test6() {
		int n = 50;
		int p = 1000;
		assertEquals(1.0, new RandomGraph().probability(n, p), 1e-9);
	}
}
