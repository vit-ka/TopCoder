import org.junit.Test;
import static org.junit.Assert.*;

public class WolvesAndSheepTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] field = new String[] {
                 "W.WSS",
                 "WW.S.",
                 ".SSS.",
                 "SSS.S",
                 ".SS.S"};
		assertEquals(2, new WolvesAndSheep().getmin(field));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] field = new String[] {".....",
 ".....",
 "....."};
		assertEquals(0, new WolvesAndSheep().getmin(field));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] field = new String[] {".SS",
 "...",
 "S..",
 "W.W"};
		assertEquals(1, new WolvesAndSheep().getmin(field));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] field = new String[] {"WWWSWWSSWWW",
 "WWSWW.SSWWW",
 "WS.WSWWWWS."};
		assertEquals(10, new WolvesAndSheep().getmin(field));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] field = new String[] {".W.S.W.W",
 "W.W.S.W.",
 ".S.S.W.W",
 "S.S.S.W.",
 ".S.W.W.S",
 "S.S.W.W.",
 ".W.W.W.S",
 "W.W.S.S."};
		assertEquals(7, new WolvesAndSheep().getmin(field));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] field = new String[] {"W.SSWWSSSW.SS",
 ".SSSSW.SSWWWW",
 ".WWWWS.WSSWWS",
 "SS.WSS..W.WWS",
 "WSSS.SSWS.W.S",
 "WSS.WS...WWWS",
 "S.WW.S.SWWWSW",
 "WSSSS.SSW...S",
 "S.WWSW.WWSWSW",
 ".WSSS.WWSWWWS",
 "..SSSS.WWWSSS",
 "SSWSWWS.W.SSW",
 "S.WSWS..WSSS.",
 "WS....W..WSS."};
		assertEquals(24, new WolvesAndSheep().getmin(field));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String[] field = new String[] {"WW..SS",
 "WW..SS",
 "......",
 "......",
 "SS..WW",
 "SS..WW"};
		assertEquals(2, new WolvesAndSheep().getmin(field));
	}
}
