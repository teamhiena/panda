
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class GameMap {
	private static GameMap instance = null;
	private GameMap() {
		//who knows
	}
	private HashMap<GameMap.Key,ArrayList<Tile>> listGetterMap=new HashMap<GameMap.Key,ArrayList<Tile>>();
	
	enum Key{
		WeakTile,
		Arcade,
		Automat,
		Fotel,
		Wardrobe,
		WardrobeExit
	}
	
	/*
	 * Ezzel kell példányt létrehozni
	 * GameMap gm = GameMap.instance();
	 */
	
	static public GameMap instance() {
		if (instance == null) instance = new GameMap();
		return instance;
	}
	
	public void finalize() {
		instance = null;
	}
	
	public Tile getRandomWardrobeExitTile() {//visszater egy random wardrobeExitTile-lal
		return(listGetterMap.get(Key.WardrobeExit).get(new Random().nextInt(listGetterMap.get(Key.WardrobeExit).size()-1)));
	}
	
	public Tile getExitTile() {
		
	}
	public Tile getEntryTile() {
		
	}
	
	
	public ArrayList<Tile> getSpecificTiles(GameMap.Key key){
		return listGetterMap.get(key);
	}
}
