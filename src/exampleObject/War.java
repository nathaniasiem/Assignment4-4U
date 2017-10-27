package exampleObject;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simon7323
 */
public class War {

    public static int winner(Card p1Card, Card p2Card) {
        //did a war happen?
        if (p1Card.getRank() == p2Card.getRank()) {
            //war code
            System.out.println("WAR");
            return 0;
            //check for the ACE
        } else if (p1Card.getRank() == 1 || p1Card.isBigger(p2Card) && p2Card.getRank() != 1) {
            //player 1 wins
            System.out.println("Player 1 wins!");
            return 1;
        } else {
            System.out.println("Player 2 wins!");
            //take both cards
            return 2;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create Deck of cards
        Deck deck = new Deck();
        //create some players
        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");

        //shuffle deck and deck cards
        deck.shuffle();
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                p1.takeCard(deck.dealCard());
            } else {
                p2.takeCard(deck.dealCard());

            }
        }
        //game time!
        //as long as players have cards 
        while (p1.getNumCards() > 0 && p2.getNumCards() > 0) {
            //player 1's card
            Card p1Card = p1.playCard();
            System.out.println("Player 1 plays " + p1Card);

            //player 2's card
            Card p2Card = p2.playCard();
            System.out.println("Player 2 plays " + p2Card);

            //who wins?
            int winner = winner(p1Card, p2Card);
            //did war happen?
            if (winner == 0) {
                //create a pile of cards
                ArrayList<Card> pile = new ArrayList<>();

                // keep playing until someone wins
                while (winner == 0) {
                    // make sure players have enough cards in hand
                    if (p1.getNumCards() < 4) {
                        System.out.println("Player 1 ran out of cards for a war");
                        // p1 loses, p2 wins!
                        winner = 2;
                        // get rid of cards
                        while (p1.getNumCards() > 0) {
                            p1.playCard();
                        }
                        break;
                    } else if (p2.getNumCards() < 4) {
                        System.out.println("Player 2 ran out of cards for a war");
                        // p2 loses, p1 wins!
                        winner = 1;
                        // get rid of cards
                        while (p2.getNumCards() > 0) {
                            p2.playCard();
                        }
                        break;
                    }
                    //declare war
                    System.out.println("WAR");
                    //add in already played cards
                    //to keep cards otherwise cards in hand will disappear
                    pile.add(p1Card);
                    pile.add(p2Card);
                    //draw 3 cards from
                    //each player to add to pile
                    Card[] p1Cards = p1.get3Cards();
                    Card[] p2Cards = p2.get3Cards();
                    for (int i = 0;
                            i < 3; i++) {
                        pile.add(p1Cards[i]);
                        pile.add(p2Cards[i]);
                    }
                    //draw new card to player
                    p1Card = p1.playCard();
                    p2Card = p2.playCard();

                    System.out.println(
                            "Player 1 plays " + p1Card);
                    System.out.println(
                            "Player 2 plays " + p2Card);
                    winner = winner(p1Card, p2Card);
                }
                //war is over
                //add pile to the victor
                if (winner == 1) {
                    //for each card in the pile
                    for (Card aCard : pile) {
                        p1.takeCard(aCard);
                    }
                } else {
                    //for each card in the pile
                    for (Card aCard : pile) {
                        p2.takeCard(aCard);
                    }
                }

            }
            //player1 wins
            if (winner == 1) {
                //takes both cards
                p1.takeCard(p2Card);
                p1.takeCard(p1Card);
                //player2 wins
            } else {
                //take both cards
                p2.takeCard(p1Card);
                p2.takeCard(p2Card);
            }
            //space to separate rounds
            System.out.println("P1:" + p1.getNumCards() + " P2: " + p2.getNumCards());
            System.out.println("");
        }
        //player 1 wins!
        if (p1.getNumCards() > 0) {
            System.out.println("Player 1 WINS!");
        } else {
            System.out.println("Player 2 WINS!");
        }
    }
}
