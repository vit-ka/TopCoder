import org.junit.Test;
import static org.junit.Assert.*;

public class MyVeryLongCakeTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 6;
		assertEquals(4, new MyVeryLongCake().cut(n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 3;
		assertEquals(1, new MyVeryLongCake().cut(n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 15;
		assertEquals(7, new MyVeryLongCake().cut(n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 1000000000;
		assertEquals(600000000, new MyVeryLongCake().cut(n));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int n = 577007436;
		assertEquals(384671628, new MyVeryLongCake().cut(n));
	}

    @Test(timeout=2000)
    public void test5() {
        int n = 4;
        assertEquals(2, new MyVeryLongCake().cut(n));
    }
}
