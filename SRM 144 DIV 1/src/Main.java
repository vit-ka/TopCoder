import java.util.Arrays;

public class Main {

    private static void runLottery() {
        Lottery lottery = new Lottery();
        System.out.println(Arrays.toString(lottery.sortByOdds(new String[]
                {
                        "PICK ANY TWO: 10 2 F F"
                        , "PICK TWO IN ORDER: 10 2 T F"
                        , "PICK TWO DIFFERENT: 10 2 F T"
                        , "PICK TWO LIMITED: 10 2 T T"
                })));

        System.out.println(Arrays.toString(lottery.sortByOdds(new String[]
                {
                        "PICK ANY THREE: 10 3 F F"
                        , "PICK THREE IN ORDER: 10 3 T F"
                        , "PICK THREE DIFFERENT: 10 3 F T"
                        , "PICK THREE LIMITED: 10 3 T T"
                })));

        System.out.println(Arrays.toString(lottery.sortByOdds(new String[]
                {
                        "INDIGO: 93 8 T F",
                        "ORANGE: 29 8 F T",
                        "VIOLET: 76 6 F F",
                        "BLUE: 100 8 T T",
                        "RED: 99 8 T T",
                        "GREEN: 78 6 F T",
                        "YELLOW: 75 6 F F"
                })));

        System.out.println(Arrays.toString(lottery.sortByOdds(new String[]
                {

                })));
    }

    public static void main(String[] args) {
        runLottery();
    }
}
