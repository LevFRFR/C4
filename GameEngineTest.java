
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;


public class GameEngineTest {
	
@Test
public void testSettingPlayerLocation(){
	Gamemap1 test = new Gamemap1();
	Gamemap1 test2 = new Gamemap1();
	Gamemap1 test3 = new Gamemap1();
	
	Location loc1 = new Location(7,4);
	Player player1 = new Player(loc1);
	
	Location loc2 = new Location(12,6);
	Player player2 = new Player(loc2);
	
	Location loc3 = new Location(9,2);
	Player player3 = new Player(loc3);
			
	
	Integer var4 = new Integer(4);
	Integer var7 = new Integer(7);
	test.setPlayerLocation(var7,var4);
	
	Integer var12 = new Integer(12);
	Integer var6 = new Integer(6);
	test2.setPlayerLocation(var12,var6);
	
	Integer var9 = new Integer(9);
	Integer var2 = new Integer(2);
	test3.setPlayerLocation(var9,var2);
	
	assertEquals("Player Must be at X value 7", test.getPlayer().getLocation().getX(), player1.getLocation().getX());
	assertEquals("Player Must be at Y value 4", test.getPlayer().getLocation().getY(), player1.getLocation().getY());
	assertEquals("Player Must be at X value 12", test2.getPlayer().getLocation().getX(), player2.getLocation().getX());
	assertEquals("Player Must be at Y value 6", test2.getPlayer().getLocation().getY(), player2.getLocation().getY());
	assertEquals("Player Must be at X value 9", test3.getPlayer().getLocation().getX(), player3.getLocation().getX());
	assertEquals("Player Must be at Y value 2", test3.getPlayer().getLocation().getY(), player3.getLocation().getY());
	
}

@Test
public void testValidMove() {
	Gamemap1 test1 = new Gamemap1();
	
	Location loc1 = new Location(4,4);
	Location loc2 = new Location(1,4);
	Location loc3 = new Location(7,7);
	test1.setEnemyLocation(4,5);
	test1.setLootLocation(8,7);
	test1.setPlayerLocation(4,3);
	
	//player test
	assertEquals("The game should've registered you hitting an enemy at 4,5", test1.isValid(loc1, Direction.DOWN, true), 3);
	assertEquals("The game should've registered you hitting the wall at 0,4", test1.isValid(loc2, Direction.LEFT, true), 0);
	assertEquals("The game should've registered you picking up the loot at 8,7", test1.isValid(loc3, Direction.RIGHT, true), 1);
	
	//enemy test
	assertEquals("The game should've registered you hitting an enemy at 4,5", test1.isValid(loc1, Direction.UP, false), 3);
	assertEquals("The game should've registered you hitting the wall at 0,4", test1.isValid(loc2, Direction.LEFT, false), 0);

}
@Test
public void testSettingEnemyLocation() {
	Gamemap1 test1 = new Gamemap1();
	test1.setEnemyLocation(1,2);
	
	Enemy enemy1 = new Enemy(1,2);
	
	assertEquals("Player Must be at X value 7", test1.getEnemy().getLocation().getX(), enemy1.getLocation().getX());
	assertEquals("Player Must be at Y value 4", test1.getEnemy().getLocation().getY(), enemy1.getLocation().getY());
}
@Test
public void testSettingLootLocation() {
	Gamemap1 test1 = new Gamemap1();
	test1.setLootLocation(9,6);
	test1.setEnemyLocation(4,5);
	String lootTest = String.valueOf(test1.getMap()[4][5]);
	
	System.out.println(lootTest);
	
	assertEquals("Loot must be at location 9,6", lootTest, "$");
	
}
@Test
public void testPlayerMoving() {
	Gamemap1 test1 = new Gamemap1();
	Gamemap1 test2 = new Gamemap1();
	
	Location loc1 = new Location(10,10);
	Player player1 = new Player(loc1);
	
	Location loc2 = new Location(6,2);
	Player player2 = new Player(loc2);
	
	Integer var10 = new Integer(10);
	Integer var9 = new Integer(9);
	test1.setPlayerLocation(var10,var9);
	test1.moving(Direction.DOWN, true);
	
	Integer var5 = new Integer(5);
	Integer var2 = new Integer(2);
	test2.setPlayerLocation(var5,var2);
	test2.moving(Direction.RIGHT, true);
	
	
	//System.out.println(test1.getPlayer().getLocation().getY());
	//System.out.println(test2.getPlayer().getLocation().getX());
	assertEquals("Player Must be at Y value 10", test1.getPlayer().getLocation().getY(), player1.getLocation().getY());
	assertEquals("Player Must be at X value 6", test2.getPlayer().getLocation().getX(), player2.getLocation().getX());
	
}
@Test
public void testEnemyMoving() {
	Gamemap1 test1 = new Gamemap1();
	Gamemap1 test2 = new Gamemap1();
	
	Enemy enemy1 = new Enemy(4,4);
	Enemy enemy2 = new Enemy(14,2);
	
	test1.setEnemyLocation(4,5);
	test1.moving(Direction.UP, false);
	test2.setEnemyLocation(15,2);
	test2.moving(Direction.LEFT, false);

	
	assertEquals("Enemy Must be at Y value 5", test1.getEnemy().getLocation().getY(), enemy1.getLocation().getY());
	assertEquals("Enemy Must be at X value 13", test2.getEnemy().getLocation().getX(), enemy2.getLocation().getX());
	
}

@Test
public void testMapMaker() {
	Gamemap1 test1 = new Gamemap1();
	
	test1.setPlayerLocation(1,1);
	test1.setEnemyLocation(1,2);
	test1.setLootLocation(1,3);
	
	Gamemap1 test2 = new Gamemap1();
	
	test2.setPlayerLocation(1,1);
	test2.setEnemyLocation(1,2);
	test2.setLootLocation(1,3);
	
	String map1=String.valueOf(test1.getMap());
	String map2=String.valueOf(test2.getMap()); 
	
	
	assertEquals("The map does not get initialized properly", map2, map1);

}














}
