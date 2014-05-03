import org.junit.Test;
import static org.junit.Assert.*;

public class MovingRooksDiv1Test {
	
	@Test(timeout=2000)
	public void test0() {
		int[] Y1 = new int[] {0};
		int[] Y2 = new int[] {0};
		assertArrayEquals(new int[] { }, new MovingRooksDiv1().move(Y1, Y2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] Y1 = new int[] {1,0};
		int[] Y2 = new int[] {0,1};
		assertArrayEquals(new int[] {0, 1 }, new MovingRooksDiv1().move(Y1, Y2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] Y1 = new int[] {1,2,0};
		int[] Y2 = new int[] {2,0,1};
		assertArrayEquals(new int[] {-1 }, new MovingRooksDiv1().move(Y1, Y2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] Y1 = new int[] {2,1,0,3,5,4};
		int[] Y2 = new int[] {0,1,2,3,4,5};
		assertArrayEquals(new int[] {0, 1, 0, 2, 1, 2, 4, 5 }, new MovingRooksDiv1().move(Y1, Y2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] Y1 = new int[] {10,9,8,7,6,5,4,3,2,1,0};
		int[] Y2 = new int[] {0,1,2,3,4,5,6,7,8,9,10};
		assertArrayEquals(new int[] {0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0, 10, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 1, 9, 1, 10, 2, 3, 2, 4, 2, 5, 2, 6, 2, 7, 2, 8, 2, 9, 2, 10, 3, 4, 3, 5, 3, 6, 3, 7, 3, 8, 3, 9, 3, 10, 4, 5, 4, 6, 4, 7, 4, 8, 4, 9, 4, 10, 5, 6, 5, 7, 5, 8, 5, 9, 5, 10, 6, 7, 6, 8, 6, 9, 6, 10, 7, 8, 7, 9, 7, 10, 8, 9, 8, 10, 9, 10 }, new MovingRooksDiv1().move(Y1, Y2));
	}
}
