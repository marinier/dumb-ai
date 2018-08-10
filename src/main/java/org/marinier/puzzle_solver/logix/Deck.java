package org.marinier.puzzle_solver.logix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<>(9);
	
	public Deck() {
		cards.add(new Card(Half.LEFT_FACING_CAN_RIGHT, Half.CAKE_RIGHT, Half.GIRL_BOTTOM, Half.LADY_TOP));
		cards.add(new Card(Half.CAKE_RIGHT, Half.LADY_BOTTOM, Half.LEFT_FACING_CAN_LEFT, Half.GIRL_TOP));
		cards.add(new Card(Half.GIRL_BOTTOM, Half.RIGHT_FACING_CAN_LEFT, Half.LADY_TOP, Half.CAKE_RIGHT));
		cards.add(new Card(Half.LADY_BOTTOM, Half.CAKE_LEFT, Half.GIRL_TOP, Half.LEFT_FACING_CAN_RIGHT));
		cards.add(new Card(Half.LADY_BOTTOM, Half.LEFT_FACING_CAN_LEFT, Half.CAKE_RIGHT, Half.GIRL_TOP));
		cards.add(new Card(Half.LEFT_FACING_CAN_LEFT, Half.GIRL_TOP, Half.LADY_TOP, Half.CAKE_RIGHT));
		cards.add(new Card(Half.GIRL_BOTTOM, Half.CAKE_LEFT, Half.LADY_TOP, Half.LEFT_FACING_CAN_RIGHT));
		cards.add(new Card(Half.GIRL_BOTTOM, Half.LEFT_FACING_CAN_LEFT, Half.LADY_TOP, Half.CAKE_RIGHT));
		cards.add(new Card(Half.LEFT_FACING_CAN_RIGHT, Half.CAKE_LEFT, Half.LADY_TOP, Half.GIRL_TOP));
		
		this.shuffle();
	}
	
	public List<Card> getCards() { return cards; }
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
}
