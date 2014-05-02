import java.util.Arrays;

public class Roundabout {

	public int clearUpTime(String north, String east, String south, String west) {

        int carsNumber = getCarsCount(north) + getCarsCount(east) + getCarsCount(south) + getCarsCount(west);
        int leavedCars = 0;
        int currentTime = 0;
        char[] roundaboutState = new char[] {'-', '-', '-', '-'}; //NESW
        String[] queues = new String[]{"", "", "", ""}; //NESW

        while (leavedCars != carsNumber) {
            // Processing one step.
            char[] prevRoundAbout = Arrays.copyOf(roundaboutState, roundaboutState.length);
            String[] prevQueues = new String[]{queues[0], queues[1], queues[2], queues[3]}; //NESW

            for (int i = 0; i < roundaboutState.length; ++i) {
                if (roundaboutState[i] == "NESW".charAt(i)) {
                    leavedCars++;
                    roundaboutState[i] = '-';
                }
            }

            // Rotates roundabout.
            char temp = roundaboutState[0];
            for (int i = 0; i + 1 < roundaboutState.length; ++i) {
                roundaboutState[i] = roundaboutState[i + 1];
            }
            roundaboutState[roundaboutState.length - 1] = temp;

            // Enters on roundabout.
            boolean waitingOnAll = true;
            for (int i = 0; i < 4; ++i) {
                int prevSide = (i + 1) % 4;

                waitingOnAll &= prevQueues[prevSide].length() != 0;

                if (queues[i].length() > 0 && prevQueues[prevSide].length() == 0
                        && prevRoundAbout[prevSide] == '-' && (prevRoundAbout[i] == '-' || roundaboutState[i] == '-')) {
                    char car = queues[i].charAt(0);
                    queues[i] = queues[i].substring(1);
                    roundaboutState[i] = car;
                }
            }

            // Special case.
            if (waitingOnAll) {
                if (queues[0].length() > 0 && prevRoundAbout[1] == '-' && (prevRoundAbout[0] == '-' || roundaboutState[0] == '-')) {
                    char car = queues[0].charAt(0);
                    queues[0] = queues[0].substring(1);
                    roundaboutState[0] = car;
                }
            }

            queues[0] = checkCarAndAddToQueue(north, queues[0], currentTime);
            queues[1] = checkCarAndAddToQueue(east, queues[1], currentTime);
            queues[2] = checkCarAndAddToQueue(south, queues[2], currentTime);
            queues[3] = checkCarAndAddToQueue(west, queues[3], currentTime);

            currentTime++;
        }

        return carsNumber == 0 ? 0 : currentTime - 1;
	}

    private String checkCarAndAddToQueue(String arrivingQueue, String queue, int currentTime) {
        if (arrivingQueue.length() > currentTime && arrivingQueue.charAt(currentTime) != '-')
            queue += arrivingQueue.charAt(currentTime);
        return queue;
    }

    private int getCarsCount(String queue) {
        int result = 0;
        for (char ch : queue.toCharArray()) {
            if (ch != '-')
                ++result;
        }

        return result;
    }
}
