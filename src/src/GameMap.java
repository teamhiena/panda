
public class GameMap {
	private static GameMap instance = null;
	private GameMap() {}
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
	/*public ArrayList<Tile> getWeakTiles() {
		
	}
	public ArrayList<Tile> getAutomatTiles(){
		
	}
	public ArrayList<Tile> getFotelTiles(){
		
	}
	public ArrayList<Tile> getArcadeTiles(){
		
	}
	public ArrayList<Tile> getWardrobeTiles(){*/
		
	//}
	public Tile getExitTile() {
		
	}
	public Tile getEntryTile() {
		
	}
	private Map<String,ArrayList<Tile>> listGetterMap=new HashMap<String,ArrayList<Tile>>();
	
	public ArrayList<Tile> getSpecificTiles(String key){
		return listGetterMap.get(key);
	}
}
