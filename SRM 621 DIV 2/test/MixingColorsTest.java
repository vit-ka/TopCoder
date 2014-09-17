import org.junit.Test;
import static org.junit.Assert.*;

public class MixingColorsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] colors = new int[] {1, 7, 3};
		assertEquals(3, new MixingColors().minColors(colors));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] colors = new int[] {10};
		assertEquals(1, new MixingColors().minColors(colors));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] colors = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		assertEquals(4, new MixingColors().minColors(colors));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] colors = new int[] {534, 251, 76, 468, 909, 410, 264, 387, 102, 982, 199, 111, 659, 386, 151};
		assertEquals(10, new MixingColors().minColors(colors));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] colors = new int[] {4, 8, 16, 32, 64, 128, 256, 512, 1024};
		assertEquals(9, new MixingColors().minColors(colors));
	}
}
