import org.junit.Test;
import static org.junit.Assert.*;

public class SlimeXSlimonadeTycoonTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] morning = new int[] {5, 1, 1};
		int[] customers = new int[] {1, 2, 3};
		int stale_limit = 2;
		assertEquals(5, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] morning = new int[] {10, 20, 30};
		int[] customers = new int[] {30, 20, 10};
		int stale_limit = 1;
		assertEquals(40, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] morning = new int[] {1, 2, 3, 4, 5};
		int[] customers = new int[] {5, 5, 5, 5, 5};
		int stale_limit = 5;
		assertEquals(15, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] morning = new int[] {10000, 0, 0, 0, 0, 0, 0};
		int[] customers = new int[] {1, 2, 4, 8, 16, 32, 64};
		int stale_limit = 4;
		assertEquals(15, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
	}

    @Test(timeout=2000)
    public void test4() {
        int[] morning = new int[] {7706, 8516, 478, 4225, 8658, 283, 5562, 8189, 5442, 4490, 3160, 4199, 3985, 5000, 5900, 3889, 1234, 1823, 9278, 3364, 1077, 9628, 4150, 521, 2564, 4089, 1374, 9529, 5308, 9418, 9827, 3637, 319, 1112, 5477, 9046, 9441, 8392, 4440, 3731};
        int[] customers = new int[] {6920, 9976, 7754, 4714, 9925, 5458, 4807, 9912, 2748, 5842, 1845, 5443, 2797, 2730, 982, 2823, 209, 5056, 1517, 5389, 2006, 3116, 2048, 4880, 6110, 1241, 1829, 7174, 638, 640, 8860, 4026, 1862, 4671, 1735, 8315, 6865, 639, 3506, 8342};
        int stale_limit = 19;
        assertEquals(159501, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
    }
}
