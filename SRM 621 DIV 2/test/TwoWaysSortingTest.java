import org.junit.Test;
import static org.junit.Assert.*;

public class TwoWaysSortingTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] stringList = new String[] {"a", "aa", "bbb"};
		assertEquals("both", new TwoWaysSorting().sortingMethod(stringList));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] stringList = new String[] {"c", "bb", "aaa"};
		assertEquals("lengths", new TwoWaysSorting().sortingMethod(stringList));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] stringList = new String[] {"etdfgfh", "aio"};
		assertEquals("none", new TwoWaysSorting().sortingMethod(stringList));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] stringList = new String[] {"aaa", "z"};
		assertEquals("lexicographically", new TwoWaysSorting().sortingMethod(stringList));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] stringList = new String[] {"z"};
		assertEquals("both", new TwoWaysSorting().sortingMethod(stringList));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] stringList = new String[] {"abcdef", "bcdef", "cdef", "def", "ef", "f", "topcoder"};
		assertEquals("lexicographically", new TwoWaysSorting().sortingMethod(stringList));
	}
}
