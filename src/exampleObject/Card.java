/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exampleObject;

/**
 *
 * @author simon7323
 */
public class Card {
    // suit constants
    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int SPADES = 2;
    public static final int HEARTS = 3;
    
    // instance variables
    private int rank;
    private int suit;
    
    // constructor
    /**
     * The constructor for a single playing card
     * @param rank the rank of the card (1-13)
     * @param suit the suit of the card
     */
    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * get the suit of the card
     * @return the suit of the card
     */
    public int getSuit(){
        return this.suit;
    }
    
    /**
     * gets the rank of the card
     * @return the rank of the card
     */
    public int getRank(){
        return this.rank;
    }
    
    /**
     * Determines if this card is bigger than another card
     * @param c the card to check against
     * @return true if the card is bigger than Card c
     */
    public boolean isBigger(Card c){
        // is this card bigger than the one passed in
        if(this.rank > c.rank){
            return true;
        }else{
            return false;
        }
    }
    
}