import java.util.ArrayList;

/**
 * A szekrenyt(Wardrobe) megvalosito osztaly.
 */
public class Wardrobe extends Entity {
	private Tile previousExitTile=null;
	private Tile entrance;
	private GameMap map; //TODO: inicializalni
	 
	public Wardrobe(Tile e, GameMap gm) {
		entrance=e;
		map = gm;
	}

	/**
	 * A parameterben megadott orangutan belep a szekrenybe.
	 */
	@Override
	public boolean stepIn(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "stepIn", par);

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

		Logger.exit(this, "stepIn", success);
		return success;
	}

	/**
	 * Egy panda belep a szekrenybe.
	 */
	@Override
	public boolean stepIn(Panda p) {
		ArrayList<Object> par = new ArrayList<>(); par.add(p);
		Logger.enter(this, "stepIn", par);

		if(p.getTile()!=entrance)
			return false;
		boolean success;
		do {
			if(p.isFollowing())
				success=p.step(previousExitTile);
			else
				success=p.step(map.getRandomWardrobeExitTile());
		}while(!success);

		Logger.exit(this, "stepIn", success);
		return true;
	}

	/**
	 * A previousExitTile adattag setter fuggvenye.
	 */
	public void setPreviousExitTile(Tile t) {
		previousExitTile=t;
	}
}
