import org.junit.Test;
import static org.junit.Assert.*;

public class CandyCupRunningCompetitionTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 3;
		int[] A = new int[] {0,1};
		int[] B = new int[] {1,2};
		assertEquals(1, new CandyCupRunningCompetition().findMaximum(N, A, B));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 4;
		int[] A = new int[] {0,1,0,2};
		int[] B = new int[] {1,3,2,3};
		assertEquals(10, new CandyCupRunningCompetition().findMaximum(N, A, B));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 3;
		int[] A = new int[] {0};
		int[] B = new int[] {1};
		assertEquals(0, new CandyCupRunningCompetition().findMaximum(N, A, B));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 5;
		int[] A = new int[] {};
		int[] B = new int[] {};
		assertEquals(0, new CandyCupRunningCompetition().findMaximum(N, A, B));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 6;
		int[] A = new int[] {1,1,2,0,4,3,0,1,4};
		int[] B = new int[] {3,2,3,1,5,5,2,4,3};
		assertEquals(39, new CandyCupRunningCompetition().findMaximum(N, A, B));
	}
}
