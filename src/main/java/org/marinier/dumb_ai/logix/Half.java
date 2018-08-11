package org.marinier.dumb_ai.logix;

public enum Half {

	GIRL_TOP,
	GIRL_BOTTOM,
	LADY_TOP,
	LADY_BOTTOM,
	CAKE_LEFT,
	CAKE_RIGHT,
	RIGHT_FACING_CAN_LEFT,
	RIGHT_FACING_CAN_RIGHT,
	LEFT_FACING_CAN_LEFT,
	LEFT_FACING_CAN_RIGHT;
	
	public Half getOpposite() {
		switch(this) {
			case GIRL_TOP: return GIRL_BOTTOM;
			case GIRL_BOTTOM: return GIRL_TOP;
			case LADY_TOP: return LADY_BOTTOM;
			case LADY_BOTTOM: return LADY_TOP;
			case CAKE_LEFT: return CAKE_RIGHT;
			case CAKE_RIGHT: return CAKE_LEFT;
			case RIGHT_FACING_CAN_LEFT: return RIGHT_FACING_CAN_RIGHT;
			case RIGHT_FACING_CAN_RIGHT: return RIGHT_FACING_CAN_LEFT;
			case LEFT_FACING_CAN_LEFT: return LEFT_FACING_CAN_RIGHT;
			case LEFT_FACING_CAN_RIGHT: return LEFT_FACING_CAN_LEFT;
		}
		System.err.println("Invalid half...?");
		return null;
	}
}
