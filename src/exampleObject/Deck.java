/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleObject;

/**
 *
 * @author simon7323
 */
public class Deck {
 // instance variables
    private Card[] cards;
    private int numCards;
    private boolean isShuffled;
    
    public Deck(){
        this.numCards = 52;
        this.isShuffled = false;
        
        this.cards = new Card[52];
        // put cards into the deck
        int i = 0;
        for(int rank = 1; rank <= 13; rank++){
            for(int suit = 0; suit < 4; suit++){
                Card c = new Card(rank,suit);
                this.cards[i] = c;
                i++;
            }
        }
    }
    
    public void shuffle(){
        //Knuth Shuffle algorithm
        for(int i = 0; i < numCards; i++){
            //generate random spot to swap with
            int spot = (int)(Math.random()*(numCards - i) + i);
            // swap cards
            Card temp = cards[i];
            cards[i] = cards[spot];
            cards[spot] = temp;
        }
        //set shuffled to be true
        isShuffled=true;
    }
    
    public boolean isShuffled(){
        return this.isShuffled;
    }
    
    public int getNumberCardsLeft(){
        return this.numCards;
    }
    
    public Card dealCard(){
        this.numCards--;
        //deal out a card
        return this.cards[this.numCards];
    }
    
    public void reset(){
        this.numCards = 52;
        this.isShuffled = false;
        this.cards = new Card[52];
        
        //put cards into deck
        int i=0;
        for(int rank=1;rank<=13;rank++){
        for(int suit=0;suit<4;suit++){
            Card c = new Card(rank,suit);
            this.cards[i]=c;
            i++;
        }
    }
    
    }
    
    public void printDeck(){
        for(int i=numCards-1;i>=0;i--){
            System.out.println(cards[i]);
        }
    }
}