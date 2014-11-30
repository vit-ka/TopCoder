import org.junit.Test;
import static org.junit.Assert.*;

public class PotentialGeometricSequenceTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] d = new int[] {0,1,2};
		assertEquals(6, new PotentialGeometricSequence().numberOfSubsequences(d));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] d = new int[] {1,2,4};
		assertEquals(5, new PotentialGeometricSequence().numberOfSubsequences(d));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] d = new int[] {3,2,1,0};
		assertEquals(10, new PotentialGeometricSequence().numberOfSubsequences(d));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] d = new int[] {1,2,4,8,16};
		assertEquals(9, new PotentialGeometricSequence().numberOfSubsequences(d));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] d = new int[] {1,3,5,5,5,5,64,4,23,2,3,4,5,4,3};
		assertEquals(37, new PotentialGeometricSequence().numberOfSubsequences(d));
	}
}
