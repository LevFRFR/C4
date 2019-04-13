package Movement;
import java.util.*;

/**
 * The Class Location.
 */
//Gamemap1  & char[] [] = map
public class Location {

	/** The xcoord. */
	private int xcoord;
	
	/** The ycoord. */
	private int ycoord;

	/**
	 * Instantiates a new location.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Location(int x, int y) {
        setX(x);
        setY(y);
        // xcoord = x;
		// ycoord = y;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return xcoord;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return ycoord;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x){
		if (x > 0 && x <= 20) {
			xcoord = x;
		}

	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y){
		if (y > 0 && y <= 10) {
			ycoord = y;
		}
	}

    /*public Location getLocation(){
        return ;
    } */

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString(){
        String str = "(X: " + this.getX() + ", Y: " + this.getY() + ")";
				return str;
    }

}
