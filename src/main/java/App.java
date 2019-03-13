import models.Poker;

import java.util.ArrayList;
import java.util.List;

import static sun.misc.Version.println;

public class App {
    public static void main(String[] args) {
        List hand1 = new ArrayList<String>();
        List hand2 = new ArrayList<String>();
        int hand1rank;
        int hand2rank;
        Poker poker = new Poker();
        for (int i = 0; i<5; i++){
            hand1.add(poker.dealCard());
            hand2.add(poker.dealCard());
        }
        hand1rank = poker.evaluateHand(hand1, 1);
        hand2rank = poker.evaluateHand(hand2, 2);
        System.out.println("Hand 1:");
        System.out.println(poker.getHandValue(hand1));
        System.out.println("Hand 2:");
        System.out.println(poker.getHandValue(hand2));

        System.out.println("------");
        System.out.println("------");


        if (hand1rank > hand2rank) {
            System.out.println("Hand 1 wins");
        } else if (hand1rank < hand2rank) {
            System.out.println("Hand 2 wins");
        } else {
            if (poker.hand1HighValue > poker.hand2HighValue) {
                System.out.println("Hand 1 wins");
            } else {
                System.out.println("Hand 2 wins");
            }
        }

    }

}

