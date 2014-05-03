import org.junit.Test;
import static org.junit.Assert.*;

public class LongWordsDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		String word = "AAA";
		assertEquals("Dislikes", new LongWordsDiv2().find(word));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String word = "ABCBA";
		assertEquals("Likes", new LongWordsDiv2().find(word));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String word = "ABCBAC";
		assertEquals("Dislikes", new LongWordsDiv2().find(word));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String word = "TOPCODER";
		assertEquals("Likes", new LongWordsDiv2().find(word));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String word = "VAMOSGIMNASIA";
		assertEquals("Dislikes", new LongWordsDiv2().find(word));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String word = "SINGLEROUNDMATCH";
		assertEquals("Likes", new LongWordsDiv2().find(word));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String word = "DALELOBO";
		assertEquals("Likes", new LongWordsDiv2().find(word));
	}
}
