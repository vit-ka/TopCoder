import org.junit.Test;
import static org.junit.Assert.*;

public class GoodCompanyDivOneTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] superior = new int[] {-1};
		int[] training = new int[] {1, 2};
		assertEquals(3, new GoodCompanyDivOne().minimumCost(superior, training));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] superior = new int[] {-1, 0, 0};
		int[] training = new int[] {1, 2, 3};
		assertEquals(10, new GoodCompanyDivOne().minimumCost(superior, training));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] superior = new int[] {-1, 0, 0, 0};
		int[] training = new int[] {1, 2, 3};
		assertEquals(-1, new GoodCompanyDivOne().minimumCost(superior, training));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] superior = new int[] {-1, 0, 0, 2, 2, 2, 1, 1, 6, 0, 5, 4, 11, 10, 3, 6, 11, 7, 0, 2, 13, 14, 2, 10, 9, 11, 22, 10, 3};
		int[] training = new int[] {4, 2, 6, 6, 8, 3, 3, 1, 1, 5, 8, 6, 8, 2, 4};
		assertEquals(71, new GoodCompanyDivOne().minimumCost(superior, training));
	}
}
