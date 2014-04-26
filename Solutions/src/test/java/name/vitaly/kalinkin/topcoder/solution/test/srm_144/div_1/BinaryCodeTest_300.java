package name.vitaly.kalinkin.topcoder.solution.test.srm_144.div_1;

import name.vitaly.kalinkin.topcoder.solution.srm_144.div_1.BinaryCode_300;
import name.vitaly.kalinkin.topcoder.solution.test.tool.InstrumentalTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BinaryCodeTest_300 {

    @Test
    public void testStandardCases() throws Exception {
        BinaryCode_300 testable = new BinaryCode_300();

        InstrumentalTool.testOneToOneArray("123210122", new String[] { "011100011",  "NONE" }, testable::decode);
        InstrumentalTool.testOneToOneArray("11", new String[] { "01",  "10" }, testable::decode);
        InstrumentalTool.testOneToOneArray("22111", new String[] { "NONE",  "11001" }, testable::decode);
        InstrumentalTool.testOneToOneArray("123210120", new String[] { "NONE",  "NONE" }, testable::decode);
        InstrumentalTool.testOneToOneArray("3", new String[] { "NONE",  "NONE" }, testable::decode);
        InstrumentalTool.testOneToOneArray("12221112222221112221111111112221111",
                new String[] { "01101001101101001101001001001101001",  "10110010110110010110010010010110010" }, testable::decode);
    }

    @Test
    public void testSystemCases() throws Exception {
        BinaryCode_300 testable = new BinaryCode_300();

        InstrumentalTool.testOneToOneArray("122", new String[] { "011",  "NONE" }, testable::decode);
    }
}
