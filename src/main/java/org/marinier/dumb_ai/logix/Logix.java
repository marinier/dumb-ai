package org.marinier.dumb_ai.logix;

import org.marinier.dumb_ai.Puzzle;

public class Logix implements Puzzle {
	
	private Board board = new Board();
	private int cardsPlaced = 0;
	
	/**
	 * The approach is super simple: we place a random valid card in each slot until we have either solved the game or there are no valid cards left
	 */
	@Override
	public boolean playOnce()
    {
    	board.reset();
    	cardsPlaced = 0;
    	Deck deck = new Deck();
    	boolean solved = placeAllCards(board, deck);
        
        return solved;
    }
        
    private boolean placeAllCards(Board board, Deck deck) {
    	for(int row = 0; row < 3; row++) {
        	for(int col = 0; col < 3; col++) {
        		boolean cardPlaced = false;
        		for(Card card : deck.getCards()) {
        			if(board.setCard(row, col, card)) {
        				deck.getCards().remove(card);
        				cardPlaced = true;
        				cardsPlaced++;
        				break;
        			}
        		}
        		if(!cardPlaced) {
        			return false;
        		}
        	}
        }
    	
    	return true;
    }
    
    @Override
	public double getSolutionQuality() {
		return cardsPlaced / 9.0;
	}
    
    @Override
    public String toString() {
    	return board.toString();
    }

}
