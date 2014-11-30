import org.junit.Test;
import static org.junit.Assert.*;

public class RunningAroundParkTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 3;
		int[] d = new int[] {1,2,3};
		assertEquals(1, new RunningAroundPark().numberOfLap(N, d));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 24;
		int[] d = new int[] {6,6};
		assertEquals(2, new RunningAroundPark().numberOfLap(N, d));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 3;
		int[] d = new int[] {3,2,1};
		assertEquals(3, new RunningAroundPark().numberOfLap(N, d));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 50;
		int[] d = new int[] {1,3,5,7,9,2,4,6,8,10};
		assertEquals(2, new RunningAroundPark().numberOfLap(N, d));
	}
}
