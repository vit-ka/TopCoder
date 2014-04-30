import java.util.*;

import static java.lang.Math.max;

public class PowerOutage {
	
	public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength) {
		Junction zeroJunction = convertToJunctions(fromJunction, toJunction, ductLength);

        long longestPath = findLongestPath(zeroJunction);
        long sumOfAllPaths = 0;

        for (int aDuctLength : ductLength)
            sumOfAllPaths += aDuctLength;

        return (int) (2 * sumOfAllPaths - longestPath);
	}

    private long findLongestPath(Junction junction) {
        junction.mark = true;

        for (Link link : junction.links) {
            if (!link.dest.mark) {
                link.totalLength = link.length + findLongestPath(link.dest);
            }
        }

        Collections.sort(junction.links, new Comparator<Link>() {
            @Override
            public int compare(Link o1, Link o2) {
                return (int) (o2.totalLength - o1.totalLength);
            }
        });

        return junction.links.get(0).totalLength;
    }

    private Junction convertToJunctions(int[] fromJunction, int[] toJunction, int[] ductLength) {
        Junction[] result = new Junction[50];

        int maxJunctionId = 0;
        for (int i = 0; i < fromJunction.length; ++i) {
            int srcJunctionId = fromJunction[i];
            int dstJunctionId = toJunction[i];

            maxJunctionId = max(maxJunctionId, max(srcJunctionId, dstJunctionId));

            Junction srcJunction = result[srcJunctionId] == null ? new Junction() : result[srcJunctionId];
            Junction dstJunction = result[dstJunctionId] == null ? new Junction() : result[dstJunctionId];

            srcJunction.id = srcJunctionId;
            dstJunction.id = dstJunctionId;

            Link srcToDstLink = new Link();
            srcToDstLink.length = ductLength[i];
            srcToDstLink.src = srcJunction;
            srcToDstLink.dest = dstJunction;

            Link dstToSrcLink = new Link();
            dstToSrcLink.length = ductLength[i];
            dstToSrcLink.src = dstJunction;
            dstToSrcLink.dest = srcJunction;

            if (srcJunction.links == null)
                srcJunction.links = new ArrayList<Link>();

            if (dstJunction.links == null)
                dstJunction.links = new ArrayList<Link>();

            srcJunction.links.add(srcToDstLink);
            dstJunction.links.add(dstToSrcLink);

            result[srcJunctionId] = srcJunction;
            result[dstJunctionId] = dstJunction;
        }

        return result[0];
    }

    public static class Junction {
        public List<Link> links;
        public int id = -1;
        public boolean mark;

        @Override
        public String toString() {
            return "Junction{" +
                    "links=" + links.size() +
                    ",id=" + id +
                    '}';
        }
    }

    public static class Link {
        public int length;
        public Junction src;
        public Junction dest;
        public long totalLength;

        @Override
        public String toString() {
            return "Link{" +
                    "length=" + length +
                    ", src=" + src +
                    ", dest=" + dest +
                    '}';
        }
    }
}
