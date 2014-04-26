package name.vitaly.kalinkin.topcoder.solution.srm_144.div_1;

import java.util.ArrayList;
import java.util.List;

public class PenLift {
    private static class Point {
        public int x;
        public int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Point parse(String input) {
            int spaceIndex = input.indexOf(' ');

            int x = Integer.parseInt(input.substring(0, spaceIndex));
            int y = Integer.parseInt(input.substring(spaceIndex + 1));
            Point result = new Point(x, y);
            return result;
        }

        public static List<Point> parseTwoPoints(String input) {
            int secondSpaceIndex = input.indexOf(' ', input.indexOf(' ') + 1);

            final Point firstPoint = parse(input.substring(0, secondSpaceIndex));
            final Point secondPoint = parse(input.substring(secondSpaceIndex + 1));
            return new ArrayList<Point>() {{ add(firstPoint); add(secondPoint); }};
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ')';
        }
    }

    public int numTimes(String[] segments, int n){
        List<List<Point>> parsedPoints = new ArrayList<List<Point>>(segments.length);

        for (String segment: segments) {
            List<Point> parsedPoint = Point.parseTwoPoints(segment);
            parsedPoints.add(parsedPoint);
        }

        System.out.println(parsedPoints);
        return 0;
    }
}
