import java.util.Random;
// TODO: Auto-generated Javadoc

/**
 * The Class Gamemap1.
 */
public class Gamemap1{
//game map
/** The user. */
//private instance variables
private Player user;

/** The enemy. */
private Enemy enemy;

/** The player loc. */
private Location playerLoc = new Location(2, 2);

//private int xcoord; //not less than 0 or bigger than 1280 +/- width of avatar
//private int ycoord; //not less than not bigger than 720 +/- height of the avatar

/** The map. */
private static char[][] map = new char[][] {
    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}
};

/**
 * Instantiates a new gamemap 1.
 */
public Gamemap1(){
//creating intances of 2 objects, Player and Enemy
    user = new Player(playerLoc);
    enemy = new Enemy(10, 20);

//Spawning P at the location of player & E at the location of the enemy
    map[playerLoc.getY()][playerLoc.getX()] = 'P';
    map[enemy.getLocation().getX()][enemy.getLocation().getY()] = 'E';

}

/**
 * Gets the player.
 *
 * @return the player
 */
public Player getPlayer() {
	return user;
}

/**
 * Gets the enemy.
 *
 * @return the enemy
 */
public Enemy getEnemy() {
	return enemy;
}

/**
 * Sets the loot location.
 *
 * @param x the x
 * @param y the y
 */
//Spawns the loot
public void setLootLocation(int x, int y) {
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == '$') {
				map[row][col] = ' ';
			}
    }
	}
	map[y][x] = '$';
}

/**
 * Sets the enemy location.
 *
 * @param x the x
 * @param y the y
 */
public void setEnemyLocation(int x, int y) {
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'E') {
				map[row][col] = ' ';
			}
    }
	}
	map[y][x] = 'E';
}

/**
 * Sets the player location.
 *
 * @param x the x
 * @param y the y
 */
public void setPlayerLocation(int x, int y) {
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'P') {
				map[row][col] = ' ';
			}
    }
	}
	map[y][x] = 'P';
}
//CONSOLE BASED CONTROLS RENDERED OBSOLETE
//public void moving(Direction x, Location loc){
//	// sets start position
//	// replaces last spot with an empty spot
//	// sets new player spot too
//	char temp = map[loc.getY()][loc.getX()];
//	map[loc.getY()][loc.getX()] = ' ';
//
//
//	if (x == Direction.LEFT){
//		loc.setX(loc.getX()-1);
//	}
//	else if( x == Direction.DOWN){
//		loc.setY(loc.getY()+1);
//	}
//	else if (x == Direction.RIGHT){
//		loc.setX(loc.getX()+1);
//	}
//	else if( x == Direction.UP){
//		loc.setY(loc.getY()-1);
//	}
//	map[loc.getY()][loc.getX()] = temp;
//}

/**
 * Moving.
 *
 * @param i the i
 * @param whoMoves the who moves
 */
public void moving(Direction i, boolean whoMoves) {
	if (whoMoves) {
		int x = user.getLocation().getX();
		int y = user.getLocation().getY();

	  if (i == Direction.UP) {
				y--;
	      user.getLocation().setY(y);
	  }
	  else if (i==Direction.DOWN){
				y++;
	      user.getLocation().setY(y);
	  }
	  else if (i==Direction.LEFT){
				x--;
	      user.getLocation().setX(x);
	  }
	  else if (i==Direction.RIGHT){
				x++;
	      user.getLocation().setX(x);
	  }
		setPlayerLocation(x, y);
	} else {
		int x = enemy.getLocation().getX();
		int y = enemy.getLocation().getY();

	  if (i == Direction.UP) {
				y--;
	      enemy.getLocation().setY(y);
	  }
	  else if (i==Direction.DOWN){
				y++;
	      enemy.getLocation().setY(y);
	  }
	  else if (i==Direction.LEFT){
				x--;
	      enemy.getLocation().setX(x);
	  }
	  else if (i==Direction.RIGHT){
				x++;
	      enemy.getLocation().setX(x);
	  }
		setEnemyLocation(x, y);

		/*for (int row=0; row<  map.length; row++)
    {
        for(int col=0; col< map[row].length; col++){
            System.out.print(map[row][col] + "  ");
        }
        System.out.println();
    }
    System.out.println();*/
}
}




/**
 * Checks if is valid.
 *
 * @param loc the loc
 * @param x the x
 * @param whoMoves the who moves
 * @return the int
 */
public int isValid(Location loc, Direction x, boolean whoMoves){
    /*
     * checks if the direction inputed has a wall, or an object, if it does, returns 0
     */
		if (whoMoves) {
			if (x == Direction.LEFT){
	        if(map[loc.getY()][loc.getX()-1] == 'X'){
	            return 0;
	        }
	        else if(map[loc.getY()][loc.getX()-1] == '$'){
	            return 1;
	        }
					else if(map[loc.getY()][loc.getX()-1] == 'E'){
							return 3;
					}

	    }
	    if (x == Direction.RIGHT){
	        if(map[loc.getY()][loc.getX()+1] == 'X'){
	            return 0;
	        }
	        else if(map[loc.getY()][loc.getX()+1] == '$'){
	            return 1;
	        }
					else if(map[loc.getY()][loc.getX()+1] == 'E'){
							return 3;
					}

	    }
	    if (x == Direction.UP){
	        if(map[loc.getY()-1][loc.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[loc.getY()-1][loc.getX()] == '$'){
	            return 1;
	        }
					else if(map[loc.getY()-1][loc.getX()] == 'E'){
							return 3;
					}

	    }
	    if (x == Direction.DOWN){
	        if(map[loc.getY()+1][loc.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[loc.getY()+1][loc.getX()] == '$'){
	            return 1;
	        }
					else if(map[loc.getY()+1][loc.getX()] == 'E'){
							return 3;
					}

	    }

		}
		else {
			if (x == Direction.LEFT){
	        if(map[loc.getY()][loc.getX()-1] == 'X'){
	            return 0;
	        }
	        else if(map[loc.getY()][loc.getX()-1] == 'P'){
	            return 3;
	        }

	    }
	    if (x == Direction.RIGHT){
	        if(map[loc.getY()][loc.getX()+1] == 'X'){
	            return 0;
	        }
	        else if(map[loc.getY()][loc.getX()+1] == 'P'){
	            return 3;
	        }

	    }
	    if (x == Direction.UP){
	        if(map[loc.getY()-1][loc.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[loc.getY()-1][loc.getX()] == 'P'){
	            return 3;
	        }

	    }
	    if (x == Direction.DOWN){
	        if(map[loc.getY()+1][loc.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[loc.getY()+1][loc.getX()] == 'P'){
	            return 3;
	        }

	    }
		}
		return 2;
	}
}
