import org.junit.Test;
import static org.junit.Assert.*;

public class SpamCheckerTest {
	
	@Test(timeout=2000)
	public void test0() {
		String judgeLog = "ooooxxxo";
		int good = 2;
		int bad = 3;
		assertEquals("SPAM", new SpamChecker().spamCheck(judgeLog, good, bad));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String judgeLog = "ooooxxxo";
		int good = 3;
		int bad = 4;
		assertEquals("NOT SPAM", new SpamChecker().spamCheck(judgeLog, good, bad));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String judgeLog = "xooooooooooooooooooooooooooo";
		int good = 1000;
		int bad = 1;
		assertEquals("SPAM", new SpamChecker().spamCheck(judgeLog, good, bad));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String judgeLog = "oxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		int good = 1000;
		int bad = 1;
		assertEquals("NOT SPAM", new SpamChecker().spamCheck(judgeLog, good, bad));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String judgeLog = "ooxoxoxooxoxxoxoxooxoxoxoxxoxx";
		int good = 15;
		int bad = 17;
		assertEquals("SPAM", new SpamChecker().spamCheck(judgeLog, good, bad));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String judgeLog = "oooxoxoxoxoxoxooxooxoxooxo";
		int good = 16;
		int bad = 18;
		assertEquals("NOT SPAM", new SpamChecker().spamCheck(judgeLog, good, bad));
	}
}
