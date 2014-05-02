
public class ExerciseMachine {
	
	public int getPercentages(String time) {
		int hours = Integer.valueOf(time.substring(0, 2));
		int minutes = Integer.valueOf(time.substring(3, 5));
		int seconds = Integer.valueOf(time.substring(6));

        int totalSeconds = hours * 60 * 60 + minutes * 60 + seconds;

        int result = 0;

        for (int i = 1; i < totalSeconds; ++i) {
            if ((i * 100) % totalSeconds == 0)
                ++result;
        }

        return result;
	}
}
