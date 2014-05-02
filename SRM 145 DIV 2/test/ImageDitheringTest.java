import org.junit.Test;
import static org.junit.Assert.*;

public class ImageDitheringTest {
	
	@Test(timeout=2000)
	public void test0() {
		String dithered = "BW";
		String[] screen = new String[] {"AAAAAAAA",
 "ABWBWBWA",
 "AWBWBWBA",
 "ABWBWBWA",
 "AWBWBWBA",
 "AAAAAAAA"};
		assertEquals(24, new ImageDithering().count(dithered, screen));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String dithered = "BW";
		String[] screen = new String[] {"BBBBBBBB",
 "BBWBWBWB",
 "BWBWBWBB",
 "BBWBWBWB",
 "BWBWBWBB",
 "BBBBBBBB"};
		assertEquals(48, new ImageDithering().count(dithered, screen));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String dithered = "ACEGIKMOQSUWY";
		String[] screen = new String[] {"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"};
		assertEquals(150, new ImageDithering().count(dithered, screen));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String dithered = "CA";
		String[] screen = new String[] {"BBBBBBB",
 "BBBBBBB",
 "BBBBBBB"};
		assertEquals(0, new ImageDithering().count(dithered, screen));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String dithered = "DCBA";
		String[] screen = new String[] {"ACBD"};
		assertEquals(4, new ImageDithering().count(dithered, screen));
	}
}
