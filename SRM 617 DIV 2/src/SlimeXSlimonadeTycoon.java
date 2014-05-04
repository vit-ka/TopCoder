import static java.lang.Math.*;

public class SlimeXSlimonadeTycoon {
	
	public int sell(int[] morning, int[] customers, int stale_limit) {

        int[] slimmonadesLeft = new int[morning.length];
        int sold = 0;

        for (int i = 0; i < morning.length; ++i) {
            if (i - stale_limit >= 0) {
                slimmonadesLeft[i - stale_limit] = 0;
            }

            slimmonadesLeft[i] = morning[i];

            int canBeSoldToday = customers[i];
            int indexToToday = max(i - stale_limit + 1, 0);

            while (canBeSoldToday > 0 && indexToToday <= i) {
                if (slimmonadesLeft[indexToToday] > canBeSoldToday) {
                    sold += canBeSoldToday;
                    slimmonadesLeft[indexToToday] -= canBeSoldToday;
                    canBeSoldToday = 0;
                } else {
                    sold += slimmonadesLeft[indexToToday];
                    canBeSoldToday -= slimmonadesLeft[indexToToday];
                    slimmonadesLeft[indexToToday] = 0;
                }

                ++indexToToday;
            }
        }

        return sold;
	}
}
