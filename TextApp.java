package GameEngine;
import java.util.*;
import Movement.Location;
import Characters.Enemy;
import Characters.Player;


public class TextApp {

	private Direction playerDirection = Direction.NONE;
	private Location playerLocation;
	private Player user;
	private int counter = 0;
	private int isItValid = 0;
	private Gamemap1 gamemap;



	public void playgame(){
		System.out.println("Recover the treasure! It's our only hope of escaping the life of poor students everywhere! ");
		gamemap = new Gamemap1();
		gamemap.setLootLocation(11, 6);
		Enemy enemy = gamemap.getEnemy();




		boolean bigBoolean = true;

		while(bigBoolean){

			System.out.println("$: " + counter);
			gamemap.drawMap();

			while (playerDirection == Direction.NONE) {  //wait for player move
				playerDirection = gamemap.getPlayer().getDirection();
			}
			playerLocation = gamemap.getPlayer().getLocation();
			isItValid = gamemap.isValid(playerLocation, playerDirection, true);
			if (isItValid == 0) {
				System.out.println("That is an invalid move, please stay within the boundary. Try again: ");
				continue;
			} else if (isItValid == 1) {
				counter++;
				System.out.println("Congratulations! You recovered the treasure!");
				setStartConditions();
				continue;
			} else if (isItValid == 2) {
				gamemap.moving(playerDirection, true);
			}

			//get enemy move after player move
			if (playerDirection != Direction.NONE) {
				playerDirection = Direction.NONE;
				enemy = gamemap.getEnemy();
				Direction enemyMove = enemy.getMove(gamemap.getPlayer());
				isItValid = gamemap.isValid(enemy.getLocation(), enemyMove, false);

				if (isItValid == 2) {
					gamemap.moving(enemyMove, false);
				} else if (isItValid == 3) {
					System.out.println("Awww you got caught, try again next time.");
					bigBoolean = false;
				}

			}


		}
	}

	public Gamemap1 getGamemap() {
		return gamemap;
	}

	public void setStartConditions() {
		playerDirection = Direction.NONE;
		gamemap.setPlayerLocation(1, 1);
		gamemap.setEnemyLocation(20, 10);
		gamemap.setLootLocation(11, 6);
	}







}
