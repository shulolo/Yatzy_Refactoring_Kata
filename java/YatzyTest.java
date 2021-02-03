import org.junit.*;
import static org.junit.Assert.*;

/**
 * Yatzy test class
 */
public class YatzyTest {

    @Test
    public void testChance() {
        int expected = 15;
        int actual = new Yatzy(2,3,4,5,1).chance();
        assertEquals(expected, actual);
        assertEquals(16, new Yatzy(3,3,4,5,1).chance());
    }

    @Test public void testYatzy() {
        int expected = 50;
        int actual = new Yatzy(4,4,4,4,4).yatzy();
        assertEquals(expected, actual);
        assertEquals(50, new Yatzy(6,6,6,6,6).yatzy());
        assertEquals(0, new Yatzy(6,6,6,6,3).yatzy());
    }

    @Test public void testOnes() {
        assertTrue(new Yatzy(1,2,3,4,5).ones() == 1);
        assertEquals(2, new Yatzy(1,2,1,4,5).ones());
        assertEquals(0, new Yatzy(6,2,2,4,5).ones());
        assertEquals(4, new Yatzy(1,2,1,1,1).ones());
    }

    @Test
    public void testTwos() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twos());
        assertEquals(10, new Yatzy(2,2,2,2,2).twos());
    }

    @Test
    public void testThrees() {
        assertEquals(6, new Yatzy(1,2,3,2,3).threes());
        assertEquals(12, new Yatzy(2,3,3,3,3).threes());
    }

    @Test
    public void testFours()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void testFives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void testSixes() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void testOnePair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).scorePair());
        assertEquals(10, new Yatzy(5,3,3,3,5).scorePair());
        assertEquals(12, new Yatzy(5,3,6,6,5).scorePair());
    }

    @Test
    public void testTwoPair() {
        assertEquals(16, new Yatzy(3,3,5,4,5).twoPair());
        assertEquals(16, new Yatzy(3,3,5,5,5).twoPair());
    }

    @Test
    public void testThreeOfAKind()
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).threeOfAKind());
        assertEquals(15, new Yatzy(5,3,5,4,5).threeOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,5).threeOfAKind());
    }

    @Test
    public void testFourOfAKind() {
        assertEquals(12, new Yatzy(3,3,3,3,5).fourOfAKind());
        assertEquals(20, new Yatzy(5,5,5,4,5).fourOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,3).threeOfAKind());
    }

    @Test
    public void testSmallStraight() {
        assertEquals(15, new Yatzy(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yatzy(2,3,4,5,1).smallStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).smallStraight());
    }

    @Test
    public void testLargeStraight() {
        assertEquals(20, new Yatzy(6,2,3,4,5).largeStraight());
        assertEquals(20, new Yatzy(2,3,4,5,6).largeStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).largeStraight());
    }

    @Test
    public void testFullHouse() {
        assertEquals(18, new Yatzy(6,2,2,2,6).fullHouse());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());
        assertEquals(0, new Yatzy(6,2,2,1,6).fullHouse());
    }
}
