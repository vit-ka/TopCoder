import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] parent1 = new int[] {-1,-1,0};
		int[] parent2 = new int[] {-1,-1,1};
		assertEquals("Possible", new Family().isFamily(parent1, parent2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] parent1 = new int[] {-1,-1,-1,-1,-1};
		int[] parent2 = new int[] {-1,-1,-1,-1,-1};
		assertEquals("Possible", new Family().isFamily(parent1, parent2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] parent1 = new int[] {-1,-1,0,0,1};
		int[] parent2 = new int[] {-1,-1,1,2,2};
		assertEquals("Impossible", new Family().isFamily(parent1, parent2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] parent1 = new int[] {-1,-1,-1,-1,1,-1,0,5,6,-1,0,3,8,6}
;
		int[] parent2 = new int[] {-1,-1,-1,-1,3,-1,4,6,5,-1,5,4,6,1}
;
		assertEquals("Possible", new Family().isFamily(parent1, parent2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] parent1 = new int[] {-1,-1,-1,2,2,-1,5,6,4,6,2,1,8,0,2,4,6,9,-1,16,-1,11};
		int[] parent2 = new int[] {-1,-1,-1,1,0,-1,1,4,2,0,4,8,2,3,0,5,14,14,-1,7,-1,13};
		assertEquals("Impossible", new Family().isFamily(parent1, parent2));
	}

    @Test(timeout=2000)
    public void test5() {
        int[] parent1 = new int[] {-1, -1, 1, 1, 2, 2, 5, 3, 0, -1, 0, -1, -1, 10, 1, 10, 7, 16, 7, 3, 2, 11, 19, 4, -1, 0, 7, -1, 13, 21, 25, -1, 15, -1, 21, 3, 3, 28, 27, 5, 37, 27, 8, 9, 37, 1, 3, -1, 23, -1, 16, -1, 7, 4, 42, -1, 48, 56, 21, 49, -1, 28, -1, 17, 59, 39, 11, 20, 60, 49, 23, 9, -1, 53, 7, 61, 5, 76, 43, 47, 65, 46, 10, 70, 69, 6, -1, 81, 13, 67, 33, 86, 32, -1, 88, 53, 86, 40, 66, -1};
        int[] parent2 = new int[] {-1, -1, 0, 0, 0, 4, 0, 0, 1, -1, 5, -1, -1, 1, 13, 12, 15, 10, 10, 11, 14, 1, 7, 6, -1, 1, 21, -1, 1, 23, 27, -1, 2, -1, 28, 9, 19, 10, 14, 13, 24, 33, 36, 1, 23, 26, 33, -1, 8, -1, 30, -1, 37, 6, 53, -1, 15, 50, 17, 6, -1, 52, -1, 8, 40, 48, 23, 12, 59, 16, 31, 59, -1, 10, 40, 12, 9, 2, 13, 44, 5, 1, 78, 61, 3, 56, -1, 80, 43, 8, 70, 64, 89, -1, 48, 90, 15, 17, 61, -1};
        assertEquals("Possible", new Family().isFamily(parent1, parent2));
    }

}
