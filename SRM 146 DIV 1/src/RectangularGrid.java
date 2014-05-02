import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class RectangularGrid {
	
	public long countRectangles(int width, int height) {

        long sum = 0;

        for (int i = 1; i <= width; ++i) {
            for (int j = i + 1; j <= height; ++j) {
                int currentRectCount = (width - i + 1) * (height - j + 1);

                sum += currentRectCount;
            }
        }

        for (int i = 1; i <= height; ++i) {
            for (int j = i + 1; j <= width; ++j) {
                int currentRectCount = (height - i + 1) * (width - j + 1);

                sum += currentRectCount;
            }
        }

        return sum;
	}
}
