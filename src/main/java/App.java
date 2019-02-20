import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class App {
    public static void main(String[] args) {
       Map<String, String> suits = new HashMap<String,String>();
       suits.put("H","Hearts");
       suits.put("D","Diamonds");
       suits.put("C","Clubs");
       suits.put("S","Spades");
       Map<String, String> ranks = new HashMap<String,String>();
       ranks.put("A", "Ace");
       ranks.put("2", "Two");
       ranks.put("3", "Three");
       ranks.put("4", "Four");
       ranks.put("5", "Five");
       ranks.put("6", "Six");
       ranks.put("7", "Seven");
       ranks.put("8", "Eight");
       ranks.put("9", "Nine");
       ranks.put("1", "Ten");
       ranks.put("J", "Jack");
       ranks.put("Q", "Queen");
       ranks.put("K", "King");
       Map<String, String> deck = new HashMap<String, String>();
       List cardKeys = new ArrayList<String>();
       for(String suit: suits.keySet()) {
           for (String rank: ranks.keySet()) {
               String cardKey = rank + suit;
               String cardValue = ranks.get(rank) + " of " + suits.get(suit);
               deck.put(cardKey, cardValue);
               cardKeys.add(cardKey);
           }
       }


    }

}

