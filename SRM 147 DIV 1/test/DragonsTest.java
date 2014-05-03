import org.junit.Test;
import static org.junit.Assert.*;

public class DragonsTest {
	
	@Test//(timeout=2000)
	public void test0() {
		int[] initialFood = new int[] {0, 0, 4, 0, 0, 0};
		int rounds = 2;
		assertEquals("1", new Dragons().snaug(initialFood, rounds));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] initialFood = new int[] {0, 0, 4, 0, 0, 0};
		int rounds = 3;
		assertEquals("1/2", new Dragons().snaug(initialFood, rounds));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] initialFood = new int[] {1000, 1000, 1000, 1000, 1000, 1000};
		int rounds = 45;
		assertEquals("1000", new Dragons().snaug(initialFood, rounds));
	}
	
	@Test//(timeout=2000)
	public void test3() {
		int[] initialFood = new int[] {1, 2, 3, 4, 5, 6};
		int rounds = 45;
		assertEquals("7/2", new Dragons().snaug(initialFood, rounds));
	}
}
