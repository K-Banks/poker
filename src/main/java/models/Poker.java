package models;
import java.util.*;

public class Poker {
    private Map deck = new HashMap();
    private List cardKeys = new ArrayList<String>();

    public Poker() {
        this.buildDeck();
    }

    private int randomNumber() {
        return (int)(Math.random() * (cardKeys.size()));
    }

    public String dealCard() {
        String cardKey = cardKeys.get(randomNumber()).toString();
        cardKeys.remove(cardKey);
        return cardKey;
    }

    public String getCardValue(String key) {
        return this.deck.get(key).toString();
    }

    public String getHandValue(List<String> hand){
        String handValue = "";
        for(String card : hand) {
            handValue += (this.getCardValue(card) + ", ");
        }
        return handValue;
    }

    public String evaluateHand(List<String> hand) {
        List<String> suits = new ArrayList<String>();
        List<String> numbers = new ArrayList<String>();
        for (String card : hand){
            String[] cardSplit = card.split("-");
            suits.add(cardSplit[0]);
            numbers.add(cardSplit[1]);
        }
        Map<String,Integer> numberCounts = getNumberCounts(numbers);



        }

    private boolean checkStraight(List<String> numbers) {

    }

    private Map<String,Integer> getNumberCounts(List<String> numbers) {
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            if (!counts.containsKey(numbers.get(i))) {
                int numberCount = 1;
                for (int x = i+1; x < 5; x++) {
                    if (numbers.get(i) == numbers.get(x)) {
                        numberCount ++;
                    }
                }
                counts.put(numbers.get(i), numberCount);
            }
        }
        return counts;
    }

    private void buildDeck() {
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
        for(String suit: suits.keySet()) {
            for (String rank: ranks.keySet()) {
                String cardKey = rank + suit;
                String cardValue = ranks.get(rank) + " of " + suits.get(suit);
                this.deck.put(cardKey, cardValue);
                cardKeys.add(cardKey);
            }
        }
    }
}
