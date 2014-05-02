import org.junit.Test;
import static org.junit.Assert.*;

public class ExerciseMachineTest {
	
	@Test(timeout=2000)
	public void test0() {
		String time = "00:30:00";
		assertEquals(99, new ExerciseMachine().getPercentages(time));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String time = "00:28:00";
		assertEquals(19, new ExerciseMachine().getPercentages(time));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String time = "23:59:59";
		assertEquals(0, new ExerciseMachine().getPercentages(time));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String time = "00:14:10";
		assertEquals(49, new ExerciseMachine().getPercentages(time));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String time = "00:19:16";
		assertEquals(3, new ExerciseMachine().getPercentages(time));
	}
}
