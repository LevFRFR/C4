package GameEngine;
import java.util.*;

import Movement.Location;
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

/** The loot location. */
private Location lootLocation;

//private int xcoord; //not less than 0 or bigger than 1280 +/- width of avatar
//private int ycoord; //not less than not bigger than 720 +/- height of the avatar

/** The map. */
private static char[][] map; 

/**
  * Instantiates a new gamemap 1.
  */
 public Gamemap1(){
			map = new char[][] {
			    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
			    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ','O',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ','O',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}
			};
//creating instances of 2 objects, Player and Enemy
    user = new Player(1, 1);
    enemy = new Enemy(20, 10);

//Spawning P at the location of player & E at the location of the enemy
    map[user.getY()][user.getX()] = 'P';
    map[enemy.getY()][enemy.getX()] = 'E';

}

/**
 * Instantiates a new gamemap 1.
 *
 * @param after10 the after 10
 */
public Gamemap1(boolean after10) {
	map = new char[][] {
	    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
	    {'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
	    {'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
	    {'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','S',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
	    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
	    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','S',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
	    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}
	};
	//creating instances of 2 objects, Player and Enemy
	    user = new Player(1, 1);
	    enemy = new Enemy(20, 10);

	//Spawning P at the location of player & E at the location of the enemy
	    map[user.getY()][user.getX()] = 'P';
	    map[enemy.getY()][enemy.getX()] = 'E';
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
 * Gets the map.
 *
 * @return the map
 */
public char[][] getMap(){
	return map;
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
	lootLocation = new Location(x, y);
	map[y][x] = '$';
}

/**
 * Gets the loot location.
 *
 * @return the loot location
 */
public Location getLootLocation() {
	return lootLocation;
}



/**
 * Sets the enemy location.
 *
 * @param x the x
 * @param y the y
 */
public void setEnemyLocation(int x, int y) {
	enemy.setX(x);
	enemy.setY(y);
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
	user.setX(x);
	user.setY(y);
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'P') {
				map[row][col] = ' ';
			}
    }
	}
	map[y][x] = 'P';
}


/**
 * Stop.
 */
public void stop() {
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'P' || map[row][col] == 'E') {
				map[row][col] = ' ';
			}
    }
	}
}

/**
 * Draw map.
 */
public void drawMap() {
	Location lootLocation = getLootLocation();
	for (int row=0; row<  map.length; row++)
	{
			for(int col=0; col< map[row].length; col++){
				if (col == lootLocation.getX() && row == lootLocation.getY())
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = '$';
					}
				} else if (row == 1 && col == 10)
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = 'O';
					}
				} else if (row == 10 && col == 10)
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = 'O';
					}
				}
					System.out.print(map[row][col] + "  ");
			}
			System.out.println();
	}
	System.out.println();
}

/**
 * Map checker.
 */
public void mapChecker() {
	Location lootLocation = getLootLocation();
	for (int row=0; row<  map.length; row++)
	{
			for(int col=0; col< map[row].length; col++){
				if (col == lootLocation.getX() && row == lootLocation.getY())
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = '$';
					}
				} else if (row == 1 && col == 10)
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = 'O';
					}
				} else if (row == 10 && col == 10)
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = 'O';
					}
				}
			}
	}
}

/**
 * Moving.
 *
 * @param i the i
 * @param whoMoves the who moves
 */
public void moving(Direction i, boolean whoMoves) {
	if (whoMoves) {
		int x = user.getX();
		int y = user.getY();


	  if (i == Direction.UP) {
				y--;
	      user.setY(y);
	  }
	  else if (i==Direction.DOWN){
				y++;
	      user.setY(y);
	  }
	  else if (i==Direction.LEFT){
				x--;
	      user.setX(x);
	  }
	  else if (i==Direction.RIGHT){
				x++;
	      user.setX(x);
	  }

		setPlayerLocation(x, y);
	} else {
		int x = enemy.getX();
		int y = enemy.getY();

	  if (i == Direction.UP) {
				y--;
	      enemy.setY(y);
	  }
	  else if (i==Direction.DOWN){
				y++;
	      enemy.setY(y);
	  }
	  else if (i==Direction.LEFT){
				x--;
	      enemy.setX(x);
	  }
	  else if (i==Direction.RIGHT){
				x++;
	      enemy.setX(x);
	  }

		setEnemyLocation(x, y);


}
}




/**
 * Checks if is player valid.
 *
 * @param player the player
 * @param x the x
 * @return the int
 */
public int isPlayerValid(Player player, Direction x){
    /*
     * checks if the direction inputed has a wall, or an object, if it does, returns an appropriate integer
     */
			if (x == Direction.LEFT){
	        if(map[player.getY()][player.getX()-1] == 'X'){
	            return 0;
	        }
	        else if(map[player.getY()][player.getX()-1] == '$'){
	            return 1;
	        }
					else if(map[player.getY()][player.getX()-1] == 'E'){
							return 3;
					}
					else if(map[player.getY()][player.getX()-1] == 'O'){
							return 4;
					}
					else if(map[player.getY()][player.getX()-1] == 'S'){
							return 5;
					}

	    }
	    if (x == Direction.RIGHT){
	        if(map[player.getY()][player.getX()+1] == 'X'){
	            return 0;
	        }
	        else if(map[player.getY()][player.getX()+1] == '$'){
	            return 1;
	        }
					else if(map[player.getY()][player.getX()+1] == 'E'){
							return 3;
					}
					else if(map[player.getY()][player.getX()+1] == 'O'){
							return 4;
					}
					else if(map[player.getY()][player.getX()+1] == 'S'){
							return 5;
					}

	    }
	    if (x == Direction.UP){
	        if(map[player.getY()-1][player.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[player.getY()-1][player.getX()] == '$'){
	            return 1;
	        }
					else if(map[player.getY()-1][player.getX()] == 'E'){
							return 3;
					}
					else if(map[player.getY()-1][player.getX()] == 'O'){
							return 4;
					}
					else if(map[player.getY()-1][player.getX()] == 'S'){
							return 5;
					}

	    }
	    if (x == Direction.DOWN){
	        if(map[player.getY()+1][player.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[player.getY()+1][player.getX()] == '$'){
	            return 1;
	        }
					else if(map[player.getY()+1][player.getX()] == 'E'){
							return 3;
					}
					else if(map[player.getY()+1][player.getX()] == 'O'){
							return 4;
					}
					else if(map[player.getY()+1][player.getX()] == 'S'){
							return 5;
					}
	    }
			return 2;
		}




		/**
		 * Checks if is enemy valid.
		 *
		 * @param enemy the enemy
		 * @param x the x
		 * @return the int
		 */
		public int isEnemyValid(Enemy enemy, Direction x){
			if (x == Direction.LEFT){
	        if(map[enemy.getY()][enemy.getX()-1] == 'X'){
	            return 0;
	        }
	        else if(map[enemy.getY()][enemy.getX()-1] == 'P'){
	            return 3;
	        }

	    }
	    if (x == Direction.RIGHT){
	        if(map[enemy.getY()][enemy.getX()+1] == 'X'){
	            return 0;
	        }
	        else if(map[enemy.getY()][enemy.getX()+1] == 'P'){
	            return 3;
	        }

	    }
	    if (x == Direction.UP){
	        if(map[enemy.getY()-1][enemy.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[enemy.getY()-1][enemy.getX()] == 'P'){
	            return 3;
	        }

	    }
	    if (x == Direction.DOWN){
	        if(map[enemy.getY()+1][enemy.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[enemy.getY()+1][enemy.getX()] == 'P'){
	            return 3;
	        }

	    }
		return 2;
	}
}
