import models.Poker;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List hand1 = new ArrayList<String>();
        List hand2 = new ArrayList<String>();
        Poker poker = new Poker();
        System.out.println(poker.dealCard());



    }

}

