import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player {


	/** The health. */
	private int health = 100;
	
	/** The location. */
	//private Item items;
	private Location location;

	/**
	 * Instantiates a new player.
	 *
	 * @param loc the loc
	 */
	public Player(Location loc) {
		location = new Location(loc.getX(), loc.getY());
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation(){
		return location;
	}
	
	/**
	 * Sets the loc.
	 *
	 * @param loc the new loc
	 */
	public void setLoc(Location loc){
		location = loc;
	}
/*
	public Direction getDirection() {

		//scanner takes in user input which can be assigned to variables
		// variable it gets assigned to, so it can be used in if statements
		//char move = input.next().charAt(0);
		//if statements to return direction based on move variable
		if(move=='w'){
			return Direction.UP;
		}
		if(move=='a'){
			return Direction.LEFT;
		}
		if(move=='s'){
			return Direction.DOWN;
		}
		if(move=='d'){
			return Direction.RIGHT;
		}
		else{
			System.out.println("Use the wasd keys to move");
			return Direction.NONE;
		}
	}*/

	/**
 * Gets the move.
 *
 * @param enemy the enemy
 * @return the move
 */
public AttackType getMove(Enemy enemy) {
		return AttackType.KICK;
	}





}
