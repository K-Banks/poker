import models.Poker;

import java.util.ArrayList;
import java.util.List;

import static sun.misc.Version.println;

public class App {
    public static void main(String[] args) {
        List hand1 = new ArrayList<String>();
        List hand2 = new ArrayList<String>();
        Poker poker = new Poker();
        for (int i = 0; i<5; i++){
            hand1.add(poker.dealCard());
            hand2.add(poker.dealCard());
        }
        System.out.println("Hand 1:");

        System.out.println(poker.getHandValue(hand1));
        System.out.println("Hand 2:");
        System.out.println(poker.getHandValue(hand2));

        System.out.println("Hand 1:");
        System.out.println(poker.evaluateHand(hand1));
        System.out.println("Hand 2:");
        System.out.println(poker.evaluateHand(hand2));


    }

}

