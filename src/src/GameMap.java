import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;


public class GameMap {
	private static GameMap instance = null;
	private HashMap<GameMap.Key,ArrayList<Tile>> listGetterMap=new HashMap<GameMap.Key,ArrayList<Tile>>();
	
	//KONSTRUKTOROK
	private GameMap() {
		listGetterMap.put(Key.WeakTile, new ArrayList<>());
		listGetterMap.put(Key.Arcade, new ArrayList<>());
		listGetterMap.put(Key.Automat, new ArrayList<>());
		listGetterMap.put(Key.Fotel, new ArrayList<>());
		listGetterMap.put(Key.Wardrobe, new ArrayList<>());
		listGetterMap.put(Key.WardrobeExit, new ArrayList<>());
	}
	
	static public GameMap instance() {
		if (instance == null) instance = new GameMap();
		return instance;
	}
	
	public void finalize() {
		instance = null;
	}
	
	enum Key{
		WeakTile,
		Arcade,
		Automat,
		Fotel,
		Wardrobe,
		WardrobeExit
	}

	//METÓDUSOK
	public Tile getRandomWardrobeExitTile() {
		Logger.enter(this, "getRandomWardrobeExitTile", new ArrayList<>());
		Tile t = listGetterMap.get(Key.WardrobeExit).get(new Random().nextInt(listGetterMap.get(Key.WardrobeExit).size()-1));
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
		Logger.exit(this, "getSpecificTiles", null); //Mivel egy listat adunk, ezt nagyon nehez abrazolni
		return ret;
	}
}
