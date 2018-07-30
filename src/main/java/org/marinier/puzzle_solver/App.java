package org.marinier.puzzle_solver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Board board = new Board();
        
        boolean solved = false;
        long startTime = System.currentTimeMillis();
        
        long numTries = 0;
        do {
        	
        	numTries++;
        	
	        // the approach is super simple: we place a random valid card in each slot until we have either solved the game or there are no valid cards left
	        // if there are no valid cards, reset
        	board.reset();
        	Deck deck = new Deck();
        	solved = placeAllCards(board, deck);
	        
        } while(!solved);
        
        long totalTime = System.currentTimeMillis() - startTime;
        
        System.out.println(board);
        
        System.out.println(numTries + " tries in " + totalTime + " ms");
    }
        
    public static boolean placeAllCards(Board board, Deck deck) {
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
}
