import org.junit.Test;
import static org.junit.Assert.*;

public class BoardFoldingDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		String[] paper = new String[] {"10",
 "11"};
		assertEquals(1, new BoardFoldingDiv2().howMany(paper));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] paper = new String[] {"1111111",
 "1111111"};
		assertEquals(84, new BoardFoldingDiv2().howMany(paper));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] paper = new String[] {"0110",
 "1001",
 "1001",
 "0110"};
		assertEquals(9, new BoardFoldingDiv2().howMany(paper));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] paper = new String[] {"0",
 "0",
 "0",
 "1",
 "0",
 "0"};
		assertEquals(6, new BoardFoldingDiv2().howMany(paper));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] paper = new String[] {"000",
 "010",
 "000"};
		assertEquals(1, new BoardFoldingDiv2().howMany(paper));
	}
}
