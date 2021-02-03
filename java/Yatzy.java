import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * Yatzy class
 */
public class Yatzy {

    /** Dices array */
    private int[] dices;

    /** Array of occurences, which is used for some categories */
    private int[] occurences;

    public Yatzy(int... dices) {
        this.dices = dices;

        this.occurences = manageOccurences();
    }

    public int chance() {
        return Arrays.stream(dices)
                .sum();
    }

    public int yatzy() {
        if(Arrays.stream(dices)
                .allMatch(i -> i == dices[0])) {
            return 50;
        }
        return 0;
    }

    public int ones() {
        return sumByNumber(1, dices);
    }

    public int twos() {
        return sumByNumber(2, dices);
    }

    public int threes() {
        return sumByNumber(3, dices);
    }

    public int fours() {
        return sumByNumber(4, dices);
    }

    public int fives() {
        return sumByNumber(5, dices);
    }

    public int sixes() {
        return sumByNumber(6, dices);
    }

    public int scorePair() {
        return (filterByOccurences(2)
                .max().getAsInt() + 1) * 2;
    }

    public int twoPair() {
        return filterByOccurences(2)
                .map(m -> (m + 1) * 2).sum();
    }

    public int fourOfAKind() {
        return filterByOccurences(4)
                .map(m -> (m + 1) * 4).sum();
    }

    public int threeOfAKind() {
        return filterByOccurences(3)
                .map(m -> (m + 1) * 3).sum();
    }

    public int smallStraight() {
        if (Arrays.stream(occurences)
                .limit(5)
                .allMatch(i -> i == 1)) {
            return 15;
        }
        return 0;

    }

    public int largeStraight() {
        if(Arrays.stream(occurences)
                .skip(1)
                .allMatch(i -> i == 1)){
            return 20;
        }
        return 0;
    }

    public int fullHouse() {
        if(IntStream.range(0, occurences.length).anyMatch(o -> occurences[o] == 3)
                && IntStream.range(0, occurences.length).anyMatch(o -> occurences[o] == 2)) {
            return IntStream.range(0, occurences.length).filter(o -> occurences[o] >= 2 )
                    .map(m -> (m + 1) * occurences[m])
                    .sum();
        }
        return 0;
    }

    /**
     * Sum the dice corresponding to a number
     * @param number the number
     * @param dices the dices
     * @return the sum
     */
    private int sumByNumber(int number, int... dices) {
        return Arrays.stream(dices)
                .filter(i -> i == number)
                .sum();
    }

    /**
     * Create an array of roll occurences
     * @return the occurences
     */
    private int[] manageOccurences() {
        int[] occurences = new int[6];
        Arrays.stream(dices).forEach(i -> {
            occurences[i-1] += 1;
        });

        return occurences;
    }

    /**
     * Filter by occurences
     * @param occurencesNb Occurences number
     * @return an IntStream
     */
    private IntStream filterByOccurences(int occurencesNb) {
        return IntStream.range(0, occurences.length)
                .filter(o -> occurences[o] >= occurencesNb);
    }
}



