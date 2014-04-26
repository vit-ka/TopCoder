public class SpamChecker {
	
	public String spamCheck(String judgeLog, int good, int bad) {

        int sum = 0;
        for (char c : judgeLog.toCharArray()) {
            if (c == 'o') {
                sum += good;
            } else {
                sum -= bad;
            }

            if (sum < 0)
                return "SPAM";
        }

        return "NOT SPAM";
	}
}
