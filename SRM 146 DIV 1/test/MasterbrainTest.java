import org.junit.Test;
import static org.junit.Assert.*;

public class MasterbrainTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] guesses = new String[] {"1575"} ;
		String[] results = new String[] {"4b 0w"};
		assertEquals(2400, new Masterbrain().possibleSecrets(guesses, results));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] guesses = new String[] {"1234"};
		String[] results = new String[] {"0b 4w"};
		assertEquals(2392, new Masterbrain().possibleSecrets(guesses, results));
	}
	
	@Test//(timeout=2000)
	public void test2() {
		String[] guesses = new String[] {"6172","6162","3617"};
		String[] results = new String[] {"3b 0w","2b 1w","0b 3w"};
		assertEquals(14, new Masterbrain().possibleSecrets(guesses, results));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] guesses = new String[] {"1513","5654","4564","1377","1671","1342"};
		String[] results = new String[] {"1b 0w","0b 1w","1b 0w","1b 0w","0b 1w","0b 1w"};
		assertEquals(6, new Masterbrain().possibleSecrets(guesses, results));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] guesses = new String[] {"2611", "1371", "7417", "2647", "3735", "4272", "2442", "3443", "1252", "3353"};
		String[] results = new String[] {"0b 2w","0b 2w","0b 1w","0b 2w","1b 0w","1b 0w","1b 0w","0b 1w","1b 1w","0b 1w"};
		assertEquals(1, new Masterbrain().possibleSecrets(guesses, results));
	}
}
