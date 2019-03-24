
public class Wardrobe extends Entity {
	private Tile previousExitTile=null;
	private Tile entrance;
	private GameMap map; //todo init
	
	//KONSTRUKTOROK
	public Wardrobe(Tile e) {
		entrance=e;
	}
	 
	@Override
	public boolean stepIn(Orangutan o) {
		if(o.getTile()!=entrance)
			return false;
		do{
			//boolean success=o.step(map.getRandomWardrobeExitTile());
		}while
	}
	
	@Override
	public boolean stepIn(Panda p) {
		
	}
	
	public void setPreviousExitTile(Tile t) {
		previousExitTile=t;
	}
}
