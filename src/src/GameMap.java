
import java.util.ArrayList;
import java.util.HashMap;


public class GameMap {
	private static GameMap instance = null;
	private GameMap() {
		//who knows
	}
	
	enum Key{
		WeakTile,
		Arcade,
		Automat,
		Fotel,
		Wardrobe		
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
	
	public Tile getRandomWardrobeExitTile() {
		
	}
	
	public Tile getExitTile() {
		
	}
	public Tile getEntryTile() {
		
	}
	
	private HashMap<GameMap.Key,ArrayList<Tile>> listGetterMap=new HashMap<GameMap.Key,ArrayList<Tile>>();
	
	public ArrayList<Tile> getSpecificTiles(GameMap.Key key){
		return listGetterMap.get(key);
	}
}
