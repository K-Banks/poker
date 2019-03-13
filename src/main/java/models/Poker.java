package models;
import java.util.*;

public class Poker {
    private Map deck = new HashMap();
    private List cardKeys = new ArrayList<String>();
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "1", "J", "Q", "K", "A"};
    public int hand1HighValue = 0;
    public int hand2HighValue = 0;

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

    public int evaluateHand(List<String> hand, int handNumber) {
        List<String> suits = new ArrayList<String>();
        List<String> numbers = new ArrayList<String>();
        int highValue = 0;
        for (String card : hand){
            String[] cardSplit = card.split("");
            suits.add(cardSplit[1]);
            numbers.add(cardSplit[0]);
        }
        Map<String,Integer> numberCounts = getNumberCounts(numbers);
        Integer pairCount = 0;
        boolean hasTriple = numberCounts.containsValue(3);
        boolean hasQuad = numberCounts.containsValue(4);
        for(String key : numberCounts.keySet()) {
            if(numberCounts.get(key) == 2) {
                pairCount ++;
                if (highValue < this.getIndexOfRank(key)) {
                    highValue = this.getIndexOfRank(key);
                }
            } else if (numberCounts.get(key) == 3){
                highValue = this.getIndexOfRank(key);
            } else if (numberCounts.get(key) == 4){
                highValue = this.getIndexOfRank(key);
            }
        }

        if (!hasTriple && !hasQuad && pairCount == 0) {
            for (String number : numbers) {
                if (highValue < this.getIndexOfRank(number)) {
                    highValue = this.getIndexOfRank(number);
                }
            }
        }

        int handRank = 1;
        if(hasQuad){
            handRank = 8;
        } else if (hasTriple && pairCount == 1) {
            handRank = 7;
        } else if (hasTriple) {
            handRank=4;
        } else if (pairCount == 2) {
            handRank=3;
        } else if (pairCount == 1) {
            handRank=2;
        } else {
            boolean hasStraight = checkStraight(numbers);
            boolean hasFlush = checkFlush(suits);
            if (hasStraight && hasFlush) {
                handRank = 9;
            } else if (hasFlush) {
                handRank= 6;
            } else if (hasStraight){
                handRank = 5;
            }
        }
        if( handNumber == 1 ) {
            this.hand1HighValue = highValue;
        } else {
            this.hand2HighValue = highValue;
        }
        return handRank;
        }

    private boolean checkStraight(List<String> numbers) {
        for (int i = 0; i < 10; i++) {
            if (numbers.contains(ranks[i]) && numbers.contains(ranks[i+1]) && numbers.contains(ranks[i+2]) && numbers.contains(ranks[i+3]) && numbers.contains(ranks[i+4])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkFlush(List<String> suits) {
        for(int i = 1; i<5; i++) {
            if(!suits.get(0).equals(suits.get(i))) {
                return false;
            }
        }
        return true;
    }

    private Map<String,Integer> getNumberCounts(List<String> numbers) {
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            if (!counts.containsKey(numbers.get(i))) {
                int numberCount = 1;
                for (int x = i+1; x < 5; x++) {
                    if (numbers.get(i).equals(numbers.get(x))) {
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

    private int getIndexOfRank(String rank) {
        String[] ranksValue = {"2", "3", "4", "5", "6", "7", "8", "9", "1", "J", "Q", "K", "A"};
        for (int i = 0; i < ranksValue.length; i++) {
            if (rank.equals(ranksValue[i])) {
                return i;
            }
        }
        return -1;
    }
}
