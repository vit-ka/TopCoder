import org.junit.Test;
import static org.junit.Assert.*;

public class ElectronicPetEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int st1 = 3;
		int p1 = 3;
		int t1 = 3;
		int st2 = 5;
		int p2 = 2;
		int t2 = 3;
		assertEquals("Difficult", new ElectronicPetEasy().isDifficult(st1, p1, t1, st2, p2, t2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int st1 = 3;
		int p1 = 3;
		int t1 = 3;
		int st2 = 5;
		int p2 = 2;
		int t2 = 2;
		assertEquals("Easy", new ElectronicPetEasy().isDifficult(st1, p1, t1, st2, p2, t2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int st1 = 1;
		int p1 = 4;
		int t1 = 7;
		int st2 = 1;
		int p2 = 4;
		int t2 = 7;
		assertEquals("Difficult", new ElectronicPetEasy().isDifficult(st1, p1, t1, st2, p2, t2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int st1 = 1;
		int p1 = 1000;
		int t1 = 1000;
		int st2 = 2;
		int p2 = 1000;
		int t2 = 1000;
		assertEquals("Easy", new ElectronicPetEasy().isDifficult(st1, p1, t1, st2, p2, t2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int st1 = 1;
		int p1 = 1;
		int t1 = 1;
		int st2 = 2;
		int p2 = 2;
		int t2 = 2;
		assertEquals("Easy", new ElectronicPetEasy().isDifficult(st1, p1, t1, st2, p2, t2));
	}
}
