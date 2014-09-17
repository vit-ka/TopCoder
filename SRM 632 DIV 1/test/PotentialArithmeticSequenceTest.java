import org.junit.Test;
import static org.junit.Assert.*;

public class PotentialArithmeticSequenceTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] d = new int[] {0,1,0,2,0,1,0};
		assertEquals(28, new PotentialArithmeticSequence().numberOfSubsequences(d));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] d = new int[] {0,0,0,0,0,0,0};
		assertEquals(7, new PotentialArithmeticSequence().numberOfSubsequences(d));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] d = new int[] {0,0,0,0,1,1,1};
		assertEquals(8, new PotentialArithmeticSequence().numberOfSubsequences(d));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] d = new int[] {0,100,0,2,0};
		assertEquals(11, new PotentialArithmeticSequence().numberOfSubsequences(d));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] d = new int[] {1,11,3,0,1,0,1,0,1,0,1,0,3,0,2,0,0,0,0,1,2,3,20};
		assertEquals(49, new PotentialArithmeticSequence().numberOfSubsequences(d));
	}
}
