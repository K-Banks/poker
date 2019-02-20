package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokerTest {






    // previous testing material for examples
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void pokerClassInstantiatesCorrectly_true() throws Exception {
        Poker poker = setNewPoker();
        assertEquals(true, poker instanceof Poker);
    }

    @Test
    public void pokerClassInstiatesDeckCorrecly_is52() throws Exception {
        Poker poker = setNewPoker();
        assertEquals(52, poker.getDeck().size());
    }

    @Test
    public void dealerHandInstantiatesCorrectly_is5() {
        Poker poker = setNewPoker();
        ArrayList<String> expected = new ArrayList<>();
        assertTrue(poker.getDealersHand().getClass() == expected.getClass());
    }

    @Test
    public void playersHandInstantiatesCorrectly_is5() {
        Poker poker = setNewPoker();
        ArrayList<String> expected = new ArrayList<>();
        assertTrue(poker.getPlayersHand().getClass() == expected.getClass());
    }

    @Test
    public void dealCard_addsCardToPlayerHand_5() {
        Poker poker = setNewPoker();
        poker.dealCard("player");
        poker.dealCard("player");
        poker.dealCard("player");
        poker.dealCard("player");
        poker.dealCard("player");
        System.out.println("player");
        System.out.println(poker.getPlayersHand().get(0));
        System.out.println(poker.getPlayersHand().get(1));
        System.out.println(poker.getPlayersHand().get(2));
        System.out.println(poker.getPlayersHand().get(3));
        System.out.println(poker.getPlayersHand().get(4));
        assertEquals(5, poker.getPlayersHand().size());
    }

    @After
    public void tearDown() throws Exception {
    }

    public static Poker setNewPoker() {
        return new Poker();
    }

    public static void dealHand(Poker poker) {
        int i = 0;
        while (i<5) {
            poker.dealCard("player");
            poker.dealCard("dealer");
            i++;
        }
    }
}