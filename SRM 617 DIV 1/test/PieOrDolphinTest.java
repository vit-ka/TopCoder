import org.junit.Test;
import static org.junit.Assert.*;

public class PieOrDolphinTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] choice1 = new int[] {10, 20, 10};
		int[] choice2 = new int[] {20, 30, 20};
		assertArrayEquals(new int[] {2, 2, 1 }, new PieOrDolphin().Distribute(choice1, choice2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] choice1 = new int[] {0, 0};
		int[] choice2 = new int[] {1, 1};
		assertArrayEquals(new int[] {2, 1 }, new PieOrDolphin().Distribute(choice1, choice2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] choice1 = new int[] {0, 1, 2, 3, 5, 6, 7, 8};
		int[] choice2 = new int[] {8, 7, 6, 5, 3, 2, 1, 0};
		assertArrayEquals(new int[] {2, 2, 2, 2, 2, 2, 2, 2 }, new PieOrDolphin().Distribute(choice1, choice2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] choice1 = new int[] {49, 0, 48, 1};
		int[] choice2 = new int[] {3, 4, 5, 6};
		assertArrayEquals(new int[] {2, 2, 2, 2 }, new PieOrDolphin().Distribute(choice1, choice2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] choice1 = new int[] {21,4,14,0,31,46,1,34,2,3,27,19,47,46,17,11,41,12,31,0,34,18,8,14,23,40,0,18,48,35,42,24,25,32,25,44,17,6,44,34,12,39,43,39,26,
34,10,6,13,2,40,15,16,32,32,29,1,23,8,10,49,22,10,15,40,20,0,30,1,43,33,42,28,39,28,4,38,11,5,1,47,12,0,22,20,33,33,34,18,8,23,6};
		int[] choice2 = new int[] {25,5,39,20,44,47,11,49,42,17,25,15,23,11,32,17,24,4,11,47,27,41,40,0,49,27,5,28,6,11,18,0,17,1,0,32,45,28,17,5,13,40,40,25,33,
7,8,32,12,0,39,30,8,39,23,9,8,34,34,37,5,1,24,23,0,29,11,42,29,40,24,18,37,1,21,0,31,47,23,33,45,48,31,11,40,45,24,22,19,26,37,39};
		assertArrayEquals(new int[] {2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1, 2, 1, 2, 1, 1, 2, 2, 1, 1, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 2, 1, 2, 2, 2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 1, 1, 2, 1, 1, 2, 2, 2, 1 }, new PieOrDolphin().Distribute(choice1, choice2));
	}
}
