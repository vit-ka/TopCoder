import org.junit.Test;
import static org.junit.Assert.*;

public class CCipherTest {
	
	@Test(timeout=2000)
	public void test0() {
		String cipherText = "VQREQFGT";
		int shift = 2;
		assertEquals("TOPCODER", new CCipher().decode(cipherText, shift));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String cipherText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int shift = 10;
		assertEquals("QRSTUVWXYZABCDEFGHIJKLMNOP", new CCipher().decode(cipherText, shift));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String cipherText = "TOPCODER";
		int shift = 0;
		assertEquals("TOPCODER", new CCipher().decode(cipherText, shift));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String cipherText = "ZWBGLZ";
		int shift = 25;
		assertEquals("AXCHMA", new CCipher().decode(cipherText, shift));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String cipherText = "DBNPCBQ";
		int shift = 1;
		assertEquals("CAMOBAP", new CCipher().decode(cipherText, shift));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String cipherText = "LIPPSASVPH";
		int shift = 4;
		assertEquals("HELLOWORLD", new CCipher().decode(cipherText, shift));
	}
}
