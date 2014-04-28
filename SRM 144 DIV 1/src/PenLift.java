import java.util.*;

import static java.lang.Math.*;

public class PenLift {
	
	public int numTimes(String[] segments, int n) {
        List<Segment> parsedSegments = parseSegments(segments);

        List<Segment> jointSegments = joinOverlapped(parsedSegments);
        List<Point> allVerticesPossible = getAllVertices(jointSegments);
        List<Node> createNonjoinedGraph = createNonJoinedGraph(allVerticesPossible);

        return 0;
	}

    private List<Node> createNonJoinedGraph(List<Point> allVerticesPossible) {
        List<Node> result = new ArrayList<Node>();

        for (Point point : allVerticesPossible) {
            Node node = new Node();
            node.point = point;
            node.neighbours = new ArrayList<Node>();
            result.add(node);
        }

        return result;
    }

    private List<Point> getAllVertices(List<Segment> jointSegments) {
        List<Point> result = new ArrayList<Point>();

        for (Segment segment : jointSegments) {
            if (!result.contains(segment.p1))
                result.add(segment.p1);

            if (!result.contains(segment.p2))
                result.add(segment.p2);
        }

        return result;
    }

    private List<Segment> joinOverlapped(List<Segment> parsedSegments) {
        List<Segment> reducedByOverlapping = reduceSegmentsWithOverlapping(parsedSegments);
        List<Segment> reducedByOverlappingNextStep = reduceSegmentsWithOverlapping(reducedByOverlapping);

        while (reducedByOverlapping.size() > reducedByOverlappingNextStep.size()) {
            reducedByOverlapping = reducedByOverlappingNextStep;
            reducedByOverlappingNextStep = reduceSegmentsWithOverlapping(reducedByOverlapping);
        }

        return reducedByOverlappingNextStep;
    }

    private List<Segment> reduceSegmentsWithOverlapping(List<Segment> segments) {
        List<Segment> result = new ArrayList<Segment>();
        List<Segment> doNotAddToResult = new ArrayList<Segment>();

        for (int i = 0; i < segments.size(); ++i) {
            Segment segment1 = segments.get(i);
            boolean addToResult = true;

            if (doNotAddToResult.contains(segment1))
                continue;

            for (int j = i + 1; j < segments.size(); ++j) {
                Segment segment2 = segments.get(j);

                if (segment1.isHorizontal() && segment2.isHorizontal() && segment1.p1.y == segment2.p1.y) {
                    if (segment1.isHorizontallyOverlappedWith(segment2)) {
                        Segment newSegment = Segment.joinHorizontalSegments(segment1, segment2);
                        result.add(newSegment);
                        addToResult = false;

                        doNotAddToResult.add(segment2);
                        System.out.println(String.format("Horizontal overlapping detected. New segment produced: %s", newSegment));
                        break;
                    }
                } else if (segment1.isVertical() && segment2.isVertical() && segment1.p1.x == segment2.p1.x) {
                    if (segment1.isVerticallyOverlappedWith(segment2)) {
                        Segment newSegment = Segment.joinVerticalSegments(segment1, segment2);
                        result.add(newSegment);
                        addToResult = false;

                        doNotAddToResult.add(segment2);
                        System.out.println(String.format("Vertical overlapping detected. New segment produced: %s", newSegment));
                        break;
                    }
                }
            }

            if (addToResult) {
                result.add(segment1);
            }
        }

        System.out.println(String.format("Overlapping reduction result: %s", result.size()));

        return result;
    }

    private List<Segment> parseSegments(String[] segments) {
        List<Segment> result = new ArrayList<Segment>();

        for (String segmentStr : segments) {
            result.add(parseOneSegment(segmentStr));
        }

        return result;
    }

    private Segment parseOneSegment(String segmentStr) {
        String[] coordinates = segmentStr.split("\\s");

        Segment result = new Segment();

        result.p1 = new Point();
        result.p2 = new Point();

        result.p1.x = Integer.valueOf(coordinates[0]);
        result.p1.y = Integer.valueOf(coordinates[1]);
        result.p2.x = Integer.valueOf(coordinates[2]);
        result.p2.y = Integer.valueOf(coordinates[3]);

        if (result.p1.x > result.p2.x) {
            Point temp = result.p1;
            result.p1 = result.p2;
            result.p2 = temp;
        } else if (result.p1.y > result.p2.y) {
            Point temp = result.p1;
            result.p1 = result.p2;
            result.p2 = temp;
        }

        return result;
    }

    public static class Node {
        public Point point;
        public List<Node> neighbours;
    }

    public static class Segment {
        public Point p1;
        public Point p2;

        public boolean isVertical() {
            return p1.x - p2.x == 0;
        }

        public boolean isHorizontal() {
            return p1.y - p2.y == 0;
        }

        public boolean isHorizontallyOverlappedWith(Segment segment2) {
            return (p1.x <= segment2.p1.x && p2.x >= segment2.p1.x)
                    || (segment2.p1.x <= p1.x && segment2.p2.x >= p1.x);
        }

        public boolean isVerticallyOverlappedWith(Segment segment2) {
            return (p1.y <= segment2.p1.y && p2.y >= segment2.p1.y)
                    || (segment2.p1.y <= p1.y && segment2.p2.y >= p1.y);
        }

        public static Segment joinHorizontalSegments(Segment segment1, Segment segment2) {
            Segment result = new Segment();

            result.p1 = new Point();
            result.p2 = new Point();

            result.p1.x = min(segment1.p1.x, segment2.p1.x);
            result.p2.x = max(segment1.p2.x, segment2.p2.x);

            result.p1.y = result.p2.y = segment1.p1.y;

            return result;
        }

        public static Segment joinVerticalSegments(Segment segment1, Segment segment2) {
            Segment result = new Segment();

            result.p1 = new Point();
            result.p2 = new Point();

            result.p1.y = min(segment1.p1.y, segment2.p1.y);
            result.p2.y = max(segment1.p2.y, segment2.p2.y);

            result.p1.x = result.p2.x = segment1.p1.x;

            return result;
        }

        @Override
        public String toString() {
            return "{" + p1 +"," + p2 + '}';
        }
    }

    public static class Point {
        public int x;
        public int y;

        @Override
        public String toString() {
            return "(" + x + ";" + y + ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
