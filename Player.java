import java.util.*;


/**
 * The Class Player.
 */
public class Player extends Location{


	/** The health. */
	private int health = 100;

	/** The move. */
	private char move = 'k';

	/**
	 * Instantiates a new player.
	 *
	 * @param X the x
	 * @param Y the y
	 */
	public Player(int X, int Y) {

        super(X, Y);
	}

    /* 
     * @see Location#getX()
     */
    @Override
    public int getX(){
        return super.getX();
    }

    /* 
     * @see Location#getY()
     */
    @Override
    public int getY(){
        return super.getY();
    }

	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public Direction getDirection() {

		//scanner takes in user input which can be assigned to variables

		Scanner input = new Scanner(System.in);
		// variable it gets assigned to, so it can be used in if statements
		move = input.next().charAt(0);
		//if statements to return direction based on move variable
		if(move=='w'){
			return Direction.UP;
		} else if(move=='a'){
			return Direction.LEFT;
		} else if(move=='s'){
			return Direction.DOWN;
		} else if(move=='d'){
			return Direction.RIGHT;
		} else {
			System.out.println("Use the wasd keys to move");
			return Direction.NONE;
		}
	}



}
