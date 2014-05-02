import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ImageDithering {
	
	public int count(String dithered, String[] screen) {
		int result = 0;

        for (String screenLine : screen) {
            for (char screenChar : screenLine.toCharArray()) {
                if (dithered.indexOf(screenChar) != -1) {
                    ++result;
                }
            }
        }

        return result;
	}
}
