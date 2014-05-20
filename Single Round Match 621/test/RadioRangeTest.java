import org.junit.Test;
import static org.junit.Assert.*;

public class RadioRangeTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] X = new int[] {0};
		int[] Y = new int[] {0};
		int[] R = new int[] {5};
		int Z = 10;
		assertEquals(0.5, new RadioRange().RadiusProbability(X, Y, R, Z), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] X = new int[] {0};
		int[] Y = new int[] {0};
		int[] R = new int[] {10};
		int Z = 10;
		assertEquals(0.0, new RadioRange().RadiusProbability(X, Y, R, Z), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] X = new int[] {10};
		int[] Y = new int[] {10};
		int[] R = new int[] {10};
		int Z = 10;
		assertEquals(0.4142135623730951, new RadioRange().RadiusProbability(X, Y, R, Z), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] X = new int[] {11, -11, 0, 0};
		int[] Y = new int[] {0, 0, 11, -11};
		int[] R = new int[] {10, 10, 10, 10};
		int Z = 31;
		assertEquals(0.3548387096774194, new RadioRange().RadiusProbability(X, Y, R, Z), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] X = new int[] {100};
		int[] Y = new int[] {100};
		int[] R = new int[] {1};
		int Z = 10;
		assertEquals(1.0, new RadioRange().RadiusProbability(X, Y, R, Z), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] X = new int[] {1000000000};
		int[] Y = new int[] {1000000000};
		int[] R = new int[] {1000000000};
		int Z = 1000000000;
		assertEquals(0.41421356237309503, new RadioRange().RadiusProbability(X, Y, R, Z), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test6() {
		int[] X = new int[] {20, -20, 0, 0};
		int[] Y = new int[] {0, 0, 20, -20};
		int[] R = new int[] {50, 50, 50, 50};
		int Z = 100;
		assertEquals(0.3, new RadioRange().RadiusProbability(X, Y, R, Z), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test7() {
		int[] X = new int[] {0, -60, -62, -60, 63, -97};
		int[] Y = new int[] {-72, 67, 61, -8, -32, 89};
		int[] R = new int[] {6, 7, 8, 7, 5, 6};
		int Z = 918;
		assertEquals(0.9407071068962471, new RadioRange().RadiusProbability(X, Y, R, Z), 1e-9);
	}
}
