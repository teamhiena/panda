public class Wardrobe extends Entity {
	// 
	private Tile previousExitTile=null;
	private Tile entrance;
	private GameMap map; //todo init
	 
	public Wardrobe(Tile e, GameMap gm) {
		entrance=e;
		map = gm;
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
		return success;
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
