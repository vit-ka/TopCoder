import org.junit.Test;
import static org.junit.Assert.*;

public class CandidatesSelectionTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] score = new String[] {"CC", "AA", "BB"};
		int[] result = new int[] {1,2,0};
		assertEquals("Possible", new CandidatesSelection().possible(score, result));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] score = new String[] {"BAB", "ABB", "AAB", "ABA"};
		int[] result = new int[] {2,0,1,3};
		assertEquals("Possible", new CandidatesSelection().possible(score, result));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] score = new String[] {"BAB", "ABB", "AAB", "ABA"};
		int[] result = new int[] {0, 1, 3, 2};
		assertEquals("Impossible", new CandidatesSelection().possible(score, result));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] score = new String[] {"AAA", "ZZZ"};
		int[] result = new int[] {1, 0};
		assertEquals("Impossible", new CandidatesSelection().possible(score, result));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] score = new String[] {"ZZZ", "AAA"};
		int[] result = new int[] {0, 1};
		assertEquals("Possible", new CandidatesSelection().possible(score, result));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] score = new String[] {"ZYYYYX","YXZYXY","ZZZZXX","XZXYYX","ZZZYYZ","ZZXXYZ","ZYZZXZ","XZYYZX"};
		int[] result = new int[] {3,7,1,0,2,5,6,4};
		assertEquals("Possible", new CandidatesSelection().possible(score, result));
	}
}
