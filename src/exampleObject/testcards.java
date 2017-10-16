package exampleObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simon7323
 */
public class testcards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.printDeck();
        System.out.println("");
        System.out.println("");
        Card c = deck.dealCard();
        System.out.println("Card: " + c);
        c = deck.dealCard();
        System.out.println("Card: " + c);
        c = deck.dealCard();
        System.out.println("Card: " + c);

    }
}
