package GameEngine;
import java.util.*;
import Movement.Location;
import Characters.Enemy;
import Characters.Player;

public class Gamemap1{
//game map
//private instance variables
private Player user;
private Enemy enemy;
private Location playerLoc = new Location(1, 1);

//private int xcoord; //not less than 0 or bigger than 1280 +/- width of avatar
//private int ycoord; //not less than not bigger than 720 +/- height of the avatar

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

public Gamemap1(){
//creating intances of 2 objects, Player and Enemy
    user = new Player(playerLoc);
    enemy = new Enemy(20, 10);

//Spawning P at the location of player & E at the location of the enemy
    map[playerLoc.getY()][playerLoc.getX()] = 'P';
    map[enemy.getLocation().getY()][enemy.getLocation().getX()] = 'E';

}
public Player getPlayer() {
	return user;
}
public Enemy getEnemy() {
	return enemy;
}
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



public void setEnemyLocation(int x, int y) {
	enemy.getLocation().setX(x);
	enemy.getLocation().setY(y);
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'E') {
				map[row][col] = ' ';
			}
    }
	}
	map[y][x] = 'E';
}

public void setPlayerLocation(int x, int y) {
	user.getLocation().setX(x);
	user.getLocation().setY(y);
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'P') {
				map[row][col] = ' ';
			}
    }
	}
	map[y][x] = 'P';
}


public void stop() {
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'P' || map[row][col] == 'E') {
				map[row][col] = ' ';
			}
    }
	}
}

public void drawMap() {
	for (int row=0; row<  map.length; row++)
	{
			for(int col=0; col< map[row].length; col++){
					System.out.print(map[row][col] + "  ");
			}
			System.out.println();
	}
	System.out.println();
}

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


}
}




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
