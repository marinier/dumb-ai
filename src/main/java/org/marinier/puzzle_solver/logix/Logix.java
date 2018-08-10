package org.marinier.puzzle_solver.logix;

import org.marinier.puzzle_solver.Puzzle;

public class Logix implements Puzzle {
	
	private Board board = new Board();
	
	/**
	 * The approach is super simple: we place a random valid card in each slot until we have either solved the game or there are no valid cards left
	 */
	@Override
	public boolean playOnce()
    {
    	board.reset();
    	Deck deck = new Deck();
    	boolean solved = placeAllCards(board, deck);
        
        return solved;
    }
        
    public boolean placeAllCards(Board board, Deck deck) {
    	for(int row = 0; row < 3; row++) {
        	for(int col = 0; col < 3; col++) {
        		boolean cardPlaced = false;
        		for(Card card : deck.getCards()) {
        			if(board.setCard(row, col, card)) {
        				deck.getCards().remove(card);
        				cardPlaced = true;
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
    public String toString() {
    	return board.toString();
    }
}
