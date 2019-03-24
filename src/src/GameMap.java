package src.src;

public class GameMap {
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
		
	}
	public Tile getExitTile() {
		
	}
	public Tile getEntryTile() {
		
	}
	private Map<String,ArrayList<Tile>> listGetterMap=new HashMap<String,ArrayList<Tile>>();
	
	public ArrayList<Tile> getSpecificTiles(String key){
		return listGetterMap.get(key);
	}
}
