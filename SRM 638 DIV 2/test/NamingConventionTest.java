import org.junit.Test;
import static org.junit.Assert.*;

public class NamingConventionTest {
	
	@Test(timeout=2000)
	public void test0() {
		String variableName = "sum_of_two_numbers";
		assertEquals("sumOfTwoNumbers", new NamingConvention().toCamelCase(variableName));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String variableName = "variable";
		assertEquals("variable", new NamingConvention().toCamelCase(variableName));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String variableName = "t_o_p_c_o_d_e_r";
		assertEquals("tOPCODER", new NamingConvention().toCamelCase(variableName));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String variableName = "the_variable_name_can_be_very_long_like_this";
		assertEquals("theVariableNameCanBeVeryLongLikeThis", new NamingConvention().toCamelCase(variableName));
	}
}
