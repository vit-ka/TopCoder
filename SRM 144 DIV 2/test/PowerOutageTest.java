import org.junit.Test;
import static org.junit.Assert.*;

public class PowerOutageTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] fromJunction = new int[] {0};
		int[] toJunction = new int[] {1};
		int[] ductLength = new int[] {10};
		assertEquals(10, new PowerOutage().estimateTimeOut(fromJunction, toJunction, ductLength));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] fromJunction = new int[] {0,1,0};
		int[] toJunction = new int[] {1,2,3};
		int[] ductLength = new int[] {10,10,10};
		assertEquals(40, new PowerOutage().estimateTimeOut(fromJunction, toJunction, ductLength));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] fromJunction = new int[] {0,0,0,1,4};
		int[] toJunction = new int[] {1,3,4,2,5};
		int[] ductLength = new int[] {10,10,100,10,5};
		assertEquals(165, new PowerOutage().estimateTimeOut(fromJunction, toJunction, ductLength));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] fromJunction = new int[] {0,0,0,1,4,4,6,7,7,7,20};
		int[] toJunction = new int[] {1,3,4,2,5,6,7,20,9,10,31};
		int[] ductLength = new int[] {10,10,100,10,5,1,1,100,1,1,5};
		assertEquals(281, new PowerOutage().estimateTimeOut(fromJunction, toJunction, ductLength));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] fromJunction = new int[] {0,0,0,0,0};
		int[] toJunction = new int[] {1,2,3,4,5};
		int[] ductLength = new int[] {100,200,300,400,500};
		assertEquals(2500, new PowerOutage().estimateTimeOut(fromJunction, toJunction, ductLength));
	}
}
