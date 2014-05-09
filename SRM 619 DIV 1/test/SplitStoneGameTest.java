import org.junit.Test;
import static org.junit.Assert.*;

public class SplitStoneGameTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] number = new int[] {1, 1, 1};
		assertEquals("LOSE", new SplitStoneGame().winOrLose(number));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] number = new int[] {2, 2};
		assertEquals("LOSE", new SplitStoneGame().winOrLose(number));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] number = new int[] {1, 1, 2};
		assertEquals("WIN", new SplitStoneGame().winOrLose(number));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] number = new int[] {1, 2, 3, 4, 3, 2, 2, 4, 3, 1, 4, 4, 1, 2, 4, 4, 1, 4, 3, 1, 4, 2, 1};
		assertEquals("WIN", new SplitStoneGame().winOrLose(number));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] number = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 3, 1, 9, 1, 3, 1, 1, 1, 1, 1};
		assertEquals("LOSE", new SplitStoneGame().winOrLose(number));
	}

    @Test(timeout=2000)
    public void test5() {
        int[] number = new int[] {1, 1, 1, 1, 2, 1, 8, 2, 8, 1, 5, 20, 1, 1, 1, 1, 27, 1, 1, 1};
        assertEquals("LOSE", new SplitStoneGame().winOrLose(number));
    }
}
