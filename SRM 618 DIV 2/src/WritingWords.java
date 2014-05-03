public class WritingWords {
	
	public int write(String word) {

        int sum = 0;

        for (char c : word.toCharArray()) {
            sum += c - 'A' + 1;
        }

        return sum;
	}
}
