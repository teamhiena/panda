
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
		
	}
	
	@Override
	public boolean stepIn(Panda p) {
		
	}
	
	public void setPreviousExitTile(Tile t) {
		previousExitTile=t;
	}
}
