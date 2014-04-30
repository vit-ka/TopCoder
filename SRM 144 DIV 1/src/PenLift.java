import java.util.*;

import static java.lang.Math.*;

public class PenLift {
	
	public int numTimes(String[] segments, int n) {
        List<Segment> parsedSegments = parseSegments(segments);

        List<Segment> jointSegments = joinOverlapped(parsedSegments);
        List<Point> allVerticesPossible = getAllVertices(jointSegments);
        List<Node> nonJoinedGraph = createNonJoinedGraph(allVerticesPossible);
        List<Node> joinedGraph = joinGraph(nonJoinedGraph, jointSegments);

        List<List<Node>> components = splitByComponents(joinedGraph);

        if (n % 2 == 0)
            return components.size() - 1;

        int sum = 0;
        for (List<Node> component : components) {
            int numberOfOddVertices = getNumberOfOddVertices(component);

            sum += max(1, numberOfOddVertices / 2);
        }

        return sum - 1;
	}

    private int getNumberOfOddVertices(List<Node> component) {
        int oddNumber = 0;

        for (Node node : component) {
            if (node.neighbours.size() % 2 != 0) {
                oddNumber++;
            }
        }

        return oddNumber;
    }

    private List<List<Node>> splitByComponents(List<Node> joinedGraph) {
        List<List<Node>> result = new ArrayList<List<Node>>();
        Queue<Node> queue = new LinkedList<Node>();

        while (joinedGraph.size() > 0) {
            List<Node> currentComponent = new ArrayList<Node>();
            queue.add(joinedGraph.get(0));
            joinedGraph.get(0).mark = true;
            joinedGraph.remove(joinedGraph.get(0));

            while (queue.size() > 0) {
                Node currentNode = queue.poll();
                currentComponent.add(currentNode);

                for (Node neighbour : currentNode.neighbours) {
                    if (!neighbour.mark) {
                        joinedGraph.remove(neighbour);
                        queue.add(neighbour);
                        neighbour.mark = true;
                    }
                }
            }

            result.add(currentComponent);
        }


        return result;
    }

    private List<Node> joinGraph(List<Node> nonJoinedGraph, List<Segment> segments) {
        for (int i = 0; i < nonJoinedGraph.size(); ++i) {
            Point pointI = nonJoinedGraph.get(i).point;

            for (int j = i + 1; j < nonJoinedGraph.size(); ++j) {
                Point pointJ = nonJoinedGraph.get(j).point;

                boolean notNeighbours = false;

                // If there is no other vertices between the given two.
                for (int k = 0; k < nonJoinedGraph.size(); ++k) {
                    Point p3 = nonJoinedGraph.get(k).point;

                    if (pointI.equals(p3) || pointJ.equals(p3))
                        continue;

                    if (isThirdPointBetweenOthers(pointI, pointJ, p3)) {
                        notNeighbours = true;
                        break;
                    }
                }

                if (!notNeighbours && linkedByAnySegment(pointI, pointJ, segments)) {
                    nonJoinedGraph.get(i).neighbours.add(nonJoinedGraph.get(j));
                    nonJoinedGraph.get(j).neighbours.add(nonJoinedGraph.get(i));
                }
            }
        }

        return nonJoinedGraph;
    }

    private boolean linkedByAnySegment(Point point1, Point point2, List<Segment> segments) {
        for (Segment segment : segments) {
            if (isPointOnSegment(point1, segment) && isPointOnSegment(point2, segment)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPointOnSegment(Point point, Segment segment) {
        return (segment.isHorizontal() && point.y == segment.p1.y
                    && segment.p1.x <= point.x && segment.p2.x >= point.x)
                || (segment.isVertical() && point.x == segment.p1.x
                    && segment.p1.y <= point.y && segment.p2.y >= point.y);
    }

    private boolean isThirdPointBetweenOthers(Point p1, Point p2, Point p3) {
        return (p1.x == p2.x && p2.x == p3.x && ((p1.y < p3.y && p2.y > p3.y) || (p2.y < p3.y && p1.y > p3.y)))
                || (p1.y == p2.y && p2.y == p3.y && ((p1.x < p3.x && p2.x > p3.x) || (p2.x < p3.x && p1.x > p3.x)));
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

        // Intersects all segments pair by pair trying to find more points.
        for (int i = 0; i < jointSegments.size(); ++i) {
            for (int j = i + 1; j < jointSegments.size(); ++j) {
                Point intersection = intersectSegments(jointSegments.get(i), jointSegments.get(j));

                if (intersection != null && !result.contains(intersection))
                    result.add(intersection);
            }
        }

        return result;
    }

    private Point intersectSegments(Segment segment1, Segment segment2) {
        if ((segment1.isHorizontal() && segment2.isHorizontal()) || (segment1.isVertical() && segment2.isVertical()))
            return null;

        if (!segment1.isHorizontal()) {
            Segment temp = segment1;
            segment1 = segment2;
            segment2 = temp;
        }

        if (segment1.p1.x <= segment2.p1.x && segment1.p2.x >= segment2.p2.x
                && segment2.p1.y <= segment1.p1.y && segment2.p2.y >= segment1.p1.y) {
            Point intersectionPoint = new Point();

            intersectionPoint.x = segment2.p1.x;
            intersectionPoint.y = segment1.p1.y;

            //System.out.println(String.format("Found intersection point of %s and %s: %s", segment1, segment2, intersectionPoint));

            return intersectionPoint;
        }

        return null;
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
                        //System.out.println(String.format("Horizontal overlapping detected. New segment produced: %s", newSegment));
                        break;
                    }
                } else if (segment1.isVertical() && segment2.isVertical() && segment1.p1.x == segment2.p1.x) {
                    if (segment1.isVerticallyOverlappedWith(segment2)) {
                        Segment newSegment = Segment.joinVerticalSegments(segment1, segment2);
                        result.add(newSegment);
                        addToResult = false;

                        doNotAddToResult.add(segment2);
                        //System.out.println(String.format("Vertical overlapping detected. New segment produced: %s", newSegment));
                        break;
                    }
                }
            }

            if (addToResult) {
                result.add(segment1);
            }
        }

        //System.out.println(String.format("Overlapping reduction result: %s", result.size()));

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
        public boolean mark;

        @Override
        public String toString() {
            return "Node{" +
                    "point=" + point +
                    ", neighbours=" + neighbours.size() +
                    '}';
        }
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
