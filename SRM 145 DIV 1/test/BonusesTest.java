import org.junit.Test;
import static org.junit.Assert.*;

public class BonusesTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] points = new int[] {1,2,3,4,5};
		assertArrayEquals(new int[] { 6,  13,  20,  27,  34 }, new Bonuses().getDivision(points));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] points = new int[] {5,5,5,5,5,5};
		assertArrayEquals(new int[] { 17,  17,  17,  17,  16,  16 }, new Bonuses().getDivision(points));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] points = new int[] {485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296,
 255, 360, 231, 311, 275,  93, 463, 115, 366, 197, 470};
		assertArrayEquals(new int[] { 8,  6,  4,  2,  8,  5,  5,  3,  1,  4,  5,  4,  6,  3,  5,  4,  1,  8,  1,  6,  3,  8 }, new Bonuses().getDivision(points));
	}

    @Test(timeout=2000)
    public void test3() {
        int[] points = new int[] {352, 483, 206, 372, 398, 318, 241, 125, 243, 460, 331, 80, 128, 238, 415, 197, 95, 317, 208, 432, 481, 461, 270, 385, 393, 139, 422, 9, 309};
        assertArrayEquals(new int[] { 5, 6, 2, 5, 5, 4, 2, 1, 2, 6, 4, 0, 1, 2, 5, 2, 1, 4, 2, 6, 6, 6, 3, 5, 5, 1, 5, 0, 4 }, new Bonuses().getDivision(points));
    }
}
