import org.junit.Test;
import static org.junit.Assert.*;

public class MovingRooksDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int[] Y1 = new int[] {0};
		int[] Y2 = new int[] {0};
		assertEquals("Possible", new MovingRooksDiv2().move(Y1, Y2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] Y1 = new int[] {1,0};
		int[] Y2 = new int[] {0,1};
		assertEquals("Possible", new MovingRooksDiv2().move(Y1, Y2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] Y1 = new int[] {0,1};
		int[] Y2 = new int[] {1,0};
		assertEquals("Impossible", new MovingRooksDiv2().move(Y1, Y2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] Y1 = new int[] {3,1,2,0};
		int[] Y2 = new int[] {0,2,1,3};
		assertEquals("Possible", new MovingRooksDiv2().move(Y1, Y2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] Y1 = new int[] {3,1,2,0};
		int[] Y2 = new int[] {3,2,0,1};
		assertEquals("Impossible", new MovingRooksDiv2().move(Y1, Y2));
	}

    @Test(timeout=2000)
    public void test5() {
        int[] Y1 = new int[] {4, 6, 1, 0, 2, 5, 3};
        int[] Y2 = new int[] {4, 5, 2, 0, 1, 3, 6};
        assertEquals("Impossible", new MovingRooksDiv2().move(Y1, Y2));
    }
}
