package Characters;
import Movement.Location;
import GameEngine.Direction;
 // TODO: Auto-generated Javadoc
/**
  * The Class Enemy.
  */
 public class Enemy {

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
		enemyLoc = new Location(x, y);
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return enemyLoc;
	}

	/**
	 * Gets the move.
	 *
	 * @param user the user
	 * @return the move
	 */
	public Direction getMove(Player user) {
		Location playerLoc = user.getLocation();
		int playerX = playerLoc.getX();
		int playerY = playerLoc.getY();
		if (playerX > enemyLoc.getX()) {
			if (playerY < enemyLoc.getY()) {
				return Direction.UP;
			} else {
				return Direction.RIGHT;
			}
		} else if (playerX < enemyLoc.getX()){
			if (playerY < enemyLoc.getY()) {
				return Direction.UP;
			} else {
				return Direction.LEFT;
			}
		} else if (playerY > enemyLoc.getY()) {
			return Direction.DOWN;
		} else {
			return Direction.NONE;
		}


	}


}
