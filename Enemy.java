package GameEngine;
import java.util.*;

import Movement.Location;

/**
  * The Class Enemy.
  */
 public class Enemy extends Location{

	/** The enemy loc. */
	private Location enemyLoc;
	
	/** The user. */
	private Player user;
	
	/** The health. */
	private int health = 100;

	/**
	 * Instantiates a new enemy.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Enemy(int x, int y) {
		super(x, y);
	}

	/* (non-Javadoc)
	 * @see Location#getX()
	 */
	@Override
	public int getX(){
			return super.getX();
	}

	/* (non-Javadoc)
	 * @see Location#getY()
	 */
	@Override
	public int getY(){
			return super.getY();
	}

	/**
	 * Gets the move.
	 *
	 * @param user the user
	 * @return the move
	 */
	public Direction getMove(Player user) {
		int playerX = user.getX();
		int playerY = user.getY();
		if (playerX > getX()) {
			if (playerY < getY()) {
				return Direction.UP;
			} else {
				return Direction.RIGHT;
			}
		} else if (playerX < getX()){
			if (playerY < getY()) {
				return Direction.UP;
			} else {
				return Direction.LEFT;
			}
		} else if (playerY > getY()) {
			return Direction.DOWN;
		} else {
			return Direction.NONE;
		}


	}


}
