import org.junit.Test;
import static org.junit.Assert.*;

public class MyLongCakeTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 6;
		assertEquals(4, new MyLongCake().cut(n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 3;
		assertEquals(1, new MyLongCake().cut(n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 15;
		assertEquals(7, new MyLongCake().cut(n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 100000;
		assertEquals(60000, new MyLongCake().cut(n));
	}
}
