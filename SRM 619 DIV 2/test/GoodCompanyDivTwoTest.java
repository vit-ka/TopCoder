import org.junit.Test;
import static org.junit.Assert.*;

public class GoodCompanyDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] superior = new int[] {-1, 0};
		int[] workType = new int[] {1, 2};
		assertEquals(2, new GoodCompanyDivTwo().countGood(superior, workType));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] superior = new int[] {-1, 0};
		int[] workType = new int[] {1, 1};
		assertEquals(1, new GoodCompanyDivTwo().countGood(superior, workType));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] superior = new int[] {-1, 0, 1, 1};
		int[] workType = new int[] {1, 4, 3, 2};
		assertEquals(4, new GoodCompanyDivTwo().countGood(superior, workType));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] superior = new int[] {-1, 0, 1, 0, 0};
		int[] workType = new int[] {3, 3, 5, 2, 2};
		assertEquals(4, new GoodCompanyDivTwo().countGood(superior, workType));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] superior = new int[] {-1, 0, 1, 1, 1, 0, 2, 5};
		int[] workType = new int[] {1, 1, 2, 3, 4, 5, 3, 3};
		assertEquals(7, new GoodCompanyDivTwo().countGood(superior, workType));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] superior = new int[] {-1, 0, 0, 1, 1, 3, 0, 2, 0, 5, 2, 5, 5, 6, 1, 2, 11, 12, 10, 4, 7, 16, 10, 9, 12, 18, 15, 23, 20, 7, 4};
		int[] workType = new int[] {4, 6, 4, 7, 7, 1, 2, 8, 1, 7, 2, 4, 2, 9, 11, 1, 10, 11, 4, 6, 11, 7, 2, 8, 9, 9, 10, 10, 9, 8, 8};
		assertEquals(27, new GoodCompanyDivTwo().countGood(superior, workType));
	}
}
