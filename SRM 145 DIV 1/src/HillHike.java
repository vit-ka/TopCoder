import java.util.HashMap;
import java.util.Map;

public class HillHike {

    private int maxHeight;
    private int[] landmarks;
    private int distance;

    public long numPaths(int distance, int maxHeight, int[] landmarks) {
        this.maxHeight = maxHeight;
        this.landmarks = landmarks;
        this.distance = distance;

        return evalPathNumbers(0, distance, this.landmarks.length - 1, true);
	}

    private Map<Key, Long> cache = new HashMap<Key, Long>();

    public long evalPathNumbers(int currentHeight, int currentDistance, int currentLandmarkIndex, boolean hasMaxHeightPassed) {
        if (currentHeight < 0 || currentDistance < 0)
            return 0;

        if (currentDistance != 0 && currentDistance != distance && currentHeight == 0)
            return 0;

        if (currentHeight == 0 && currentDistance == 0 && currentLandmarkIndex == -1 && !hasMaxHeightPassed) {
            return 1;
        }

        Key cacheKey = new Key();
        cacheKey.distance = currentDistance;
        cacheKey.height = currentHeight;
        cacheKey.landmarkIndex = currentLandmarkIndex;
        cacheKey.maxHeightPassed = hasMaxHeightPassed;

        if (cache.containsKey(cacheKey))
            return cache.get(cacheKey);

        int currentLandmarkHeight = currentLandmarkIndex >= landmarks.length || currentLandmarkIndex < 0 ? -1 : landmarks[currentLandmarkIndex];

        if (currentHeight == maxHeight) {
            if (currentLandmarkHeight == currentHeight) {
                if (!hasMaxHeightPassed)
                    return 0;

                long result = (currentHeight > 0 ? evalPathNumbers(currentHeight, currentDistance - 1, currentLandmarkIndex - 1, true) : 0)
                       + evalPathNumbers(currentHeight - 1, currentDistance - 1, currentLandmarkIndex - 1, true)
                       + evalPathNumbers(currentHeight - 1, currentDistance - 1, currentLandmarkIndex - 1, false);

                cache.put(cacheKey, result);

                //System.out.println(String.format("f(%s,%s,%s,%s)=%s", currentHeight, currentDistance, currentLandmarkIndex, hasMaxHeightPassed, result));
                return result;
            } else {
                if (!hasMaxHeightPassed) {
                    return 0;
                }

                long result = (currentHeight > 0 ? evalPathNumbers(currentHeight, currentDistance - 1, currentLandmarkIndex, true) : 0)
                        + evalPathNumbers(currentHeight - 1, currentDistance - 1, currentLandmarkIndex, true)
                        + evalPathNumbers(currentHeight - 1, currentDistance - 1, currentLandmarkIndex, false);

                cache.put(cacheKey, result);

                //System.out.println(String.format("f(%s,%s,%s,%s)=%s", currentHeight, currentDistance, currentLandmarkIndex, hasMaxHeightPassed, result));
                return result;
            }
        } else {
            if (currentLandmarkHeight == currentHeight) {
                long result = evalPathNumbers(currentHeight + 1, currentDistance - 1, currentLandmarkIndex - 1, hasMaxHeightPassed)
                       + (currentHeight > 0 ? evalPathNumbers(currentHeight, currentDistance - 1, currentLandmarkIndex - 1, hasMaxHeightPassed) : 0)
                       + evalPathNumbers(currentHeight - 1, currentDistance - 1, currentLandmarkIndex - 1, hasMaxHeightPassed);

                cache.put(cacheKey, result);

                //System.out.println(String.format("f(%s,%s,%s,%s)=%s", currentHeight, currentDistance, currentLandmarkIndex, hasMaxHeightPassed, result));
                return result;
            } else {
                long result = evalPathNumbers(currentHeight + 1, currentDistance - 1, currentLandmarkIndex, hasMaxHeightPassed)
                        + (currentHeight > 0 ? evalPathNumbers(currentHeight, currentDistance - 1, currentLandmarkIndex, hasMaxHeightPassed) : 0)
                        + evalPathNumbers(currentHeight - 1, currentDistance - 1, currentLandmarkIndex, hasMaxHeightPassed);

                cache.put(cacheKey, result);

                //System.out.println(String.format("f(%s,%s,%s,%s)=%s", currentHeight, currentDistance, currentLandmarkIndex, hasMaxHeightPassed, result));
                return result;
            }
        }
    }

    private class Key {
        public int height;
        public int distance;
        public int landmarkIndex;
        public boolean maxHeightPassed;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (distance != key.distance) return false;
            if (height != key.height) return false;
            if (landmarkIndex != key.landmarkIndex) return false;
            if (maxHeightPassed != key.maxHeightPassed) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = height;
            result = 31 * result + distance;
            result = 31 * result + landmarkIndex;
            result = 31 * result + (maxHeightPassed ? 1 : 0);
            return result;
        }
    }
}
