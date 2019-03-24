
import java.util.ArrayList;
import java.util.HashMap;


public class GameMap {
	private static GameMap instance = null;
	private HashMap<GameMap.Key,ArrayList<Tile>> listGetterMap=new HashMap<GameMap.Key,ArrayList<Tile>>();
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
	 * Ezzel kell peldanyt letrehozni
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
		Logger.enter(this, "getRandomWardrobeExitTile", new ArrayList<>());
		Tile t = null;
		//TODO
		Logger.exit(this, "getRandomWardrobeExitTile", t);
		return t;
	}
	
	public Tile getExitTile() {
		Logger.enter(this, "getExitTile", new ArrayList<>());
		Tile t = null;
		//TODO
		Logger.exit(this, "getExitTile", t);
		return t;
	}
	public Tile getEntryTile() {
		Logger.enter(this, "getEntryTile", new ArrayList<>());
		Tile t = null;
		//TODO
		Logger.exit(this, "getEntryTile", t);
		return t;
	}

	public ArrayList<Tile> getSpecificTiles(GameMap.Key key){
		ArrayList<Object> par = new ArrayList<>(); par.add(key);
		Logger.enter(this, "getSpecificTiles", par);
		ArrayList<Tile> ret = listGetterMap.get(key);
		Logger.exit(this, "getSpecificTiles", ret);
		return ret;
	}
}
