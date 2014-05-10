import org.junit.Test;
import static org.junit.Assert.*;

public class CandidatesSelectionEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] score = new String[] {"ACB", "BAC", "CBA"};
		int x = 1;
		assertArrayEquals(new int[] {1, 2, 0 }, new CandidatesSelectionEasy().sort(score, x));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] score = new String[] {"A", "C", "B", "C", "A"};
		int x = 0;
		assertArrayEquals(new int[] {0, 4, 2, 1, 3 }, new CandidatesSelectionEasy().sort(score, x));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] score = new String[] {"LAX","BUR","ONT","LGB","SAN","SNA","SFO","OAK","SJC"};
		int x = 2;
		assertArrayEquals(new int[] {5, 3, 8, 7, 4, 6, 1, 2, 0 }, new CandidatesSelectionEasy().sort(score, x));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] score = new String[] {"BBCBABAC","BCBACABA","CCCBAACB","CACABABB","AABBBBCC"};
		int x = 6;
		assertArrayEquals(new int[] {0, 1, 3, 2, 4 }, new CandidatesSelectionEasy().sort(score, x));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] score = new String[] {"XXYWZWWYXZ","YZZZYWYZYW","ZYZZWZYYWW","ZWZWZWZXYW","ZYXWZXWYXY","YXXXZWXWXW","XWWYZWXYXY","XYYXYWYXWY","ZZYXZYZXYY","WXZXWYZWYY"};
		int x = 3;
		assertArrayEquals(new int[] {0, 3, 4, 5, 7, 8, 9, 6, 1, 2 }, new CandidatesSelectionEasy().sort(score, x));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] score = new String[] {"X"};
		int x = 0;
		assertArrayEquals(new int[] {0 }, new CandidatesSelectionEasy().sort(score, x));
	}

    @Test(timeout=2000)
    public void test6() {
        String[] score = new String[] {"AB", "AB", "AB"};
        int x = 0;
        assertArrayEquals(new int[] {0, 1, 2 }, new CandidatesSelectionEasy().sort(score, x));
    }
}
