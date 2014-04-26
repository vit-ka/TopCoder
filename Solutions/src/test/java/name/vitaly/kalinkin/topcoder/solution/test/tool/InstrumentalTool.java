package name.vitaly.kalinkin.topcoder.solution.test.tool;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;

public abstract class InstrumentalTool {

    public static <T> void testOneToOne(T argument, T expectedResult, OneToOneOperator<T> operator) {
        Assert.assertThat(operator.takeAndReturn(argument), equalTo(expectedResult));
    }

    public static <T> void testOneToOneArray(T argument, T[] expectedResult, OneToOneArrayOperator<T> operator) {
        Assert.assertThat(operator.takeAndReturn(argument), equalTo(expectedResult));
    }
}
