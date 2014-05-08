import org.junit.Test;
import static org.junit.Assert.*;

public class ChooseTheBestOneTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 3;
		assertEquals(2, new ChooseTheBestOne().countNumber(N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 6;
		assertEquals(6, new ChooseTheBestOne().countNumber(N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 10;
		assertEquals(8, new ChooseTheBestOne().countNumber(N));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 1234;
		assertEquals(341, new ChooseTheBestOne().countNumber(N));
	}


    @Test(timeout=2000)
    public void test4() {
        int N = 2414;
        assertEquals(1368, new ChooseTheBestOne().countNumber(N));
    }
}
