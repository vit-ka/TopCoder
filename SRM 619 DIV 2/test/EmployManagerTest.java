import org.junit.Test;
import static org.junit.Assert.*;

public class EmployManagerTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] value = new int[] {1, 1};
		String[] earning = new String[] {"02", "20"};
		assertEquals(0, new EmployManager().maximumEarnings(value, earning));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] value = new int[] {2, 2};
		String[] earning = new String[] {"01", "10"};
		assertEquals(-1, new EmployManager().maximumEarnings(value, earning));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] value = new int[] {1, 2, 3, 4};
		String[] earning = new String[] {"0121", "1021", "2201", "1110"};
		assertEquals(-1, new EmployManager().maximumEarnings(value, earning));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] value = new int[] {2, 2, 0, 1, 4, 0, 1, 0, 0, 4};
		String[] earning = new String[] {"0100451253",  "1010518123",  "0102989242",  "0020093171",  "4590045480",  "5189400676",  "1893500826",  "2121468008",  "5247872007",  "3321066870"};
		assertEquals(156, new EmployManager().maximumEarnings(value, earning));
	}
}
