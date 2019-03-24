
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
		boolean success;
		do{
			Tile exit=map.getRandomWardrobeExitTile();
			success=o.step(exit);
			if(success) {
				previousExitTile=exit;				
			}
				
		}while(!success);
		return true;
	}
	
	@Override
	public boolean stepIn(Panda p) {
		if(p.getTile()!=entrance)
			return false;
		boolean success;
		do {
			if(p.isFollowing())
				success=p.step(previousExitTile);
			else
				success=p.step(map.getRandomWardrobeExitTile());
		}while(!success);
		return true;
	}
	
	public void setPreviousExitTile(Tile t) {
		previousExitTile=t;
	}
}
