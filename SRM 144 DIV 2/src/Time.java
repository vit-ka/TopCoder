public class Time {
	
	public String whatTime(int seconds) {
        return String.format("%s:%s:%s", seconds / 60 / 60, (seconds / 60) % 60, seconds % 60);
	}
}
