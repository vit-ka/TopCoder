import org.junit.Test;
import static org.junit.Assert.*;

public class WritingWordsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String word = "A";
		assertEquals(1, new WritingWords().write(word));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String word = "ABC";
		assertEquals(6, new WritingWords().write(word));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String word = "VAMOSGIMNASIA";
		assertEquals(143, new WritingWords().write(word));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String word = "TOPCODER";
		assertEquals(96, new WritingWords().write(word));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String word = "SINGLEROUNDMATCH";
		assertEquals(183, new WritingWords().write(word));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String word = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
		assertEquals(1300, new WritingWords().write(word));
	}
}
