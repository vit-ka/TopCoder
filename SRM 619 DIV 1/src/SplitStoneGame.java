public class SplitStoneGame {
	
	public String winOrLose(int[] number) {

        if (number.length < 3)
            return "LOSE";

        int answer = 0;

        for (int num : number) {
            if (num > 1)
                answer++;
        }

        if (answer == 0 || number.length % 2 == 0)
            return "LOSE";

        return "WIN";
	}
}
