import java.util.ArrayList;

public abstract class Panda extends Animal{
	private ArrayList<Tile> subbedTiles=new ArrayList<Tile>();
	protected GameMap map; //TODO:inicializalni
	protected GameMap.Key hatesEntity;

	//METODUSOK
	public void affectedBy(Entity e) {
		//el tudom lepzelni hogy ennek ssemmi ertelme mert ugyis csak ugyanolyan parameterrel lehet overrideolni (G)
	}

	/**
	 * Hozzaad egy csempet a panda subbedTiles listajahoz.
	 */
	public void addSubbedTile(Tile t) {
		ArrayList<Object> par = new ArrayList<>(); par.add(t);
		Logger.enter(this, "addSubbedTile", par);
		subbedTiles.add(t);
		Logger.exit(this, "addSubbedTile", null);
	}

	/**
	 * Kitorli a feliratkozott csempek listajat.
	 */
	public void clearSubbedTiles() {
		Logger.enter(this, "clearSubbedTiles", new ArrayList<>());
		subbedTiles.clear();
		Logger.exit(this, "clearSubbedTiles", null);
	}

	/**
	 * A tile adattag getter fuggvenye.
	 */
	public Tile getTile() {
		Logger.enter(this, "getTile", new ArrayList<>());
		Logger.exit(this, "getTile", tile);
		return tile;
	}
		
	@Override
	public boolean step(Tile newTile) {
		ArrayList<Object> par = new ArrayList<>(); par.add(newTile);
		Logger.enter(this, "step", par);

		boolean success = newTile.receiveAnimal(this);
		if(success) {
			tile.removePandaFromNeighborSubbedPandas(this); //Panda eltavolitasa a szomszedokrol.
			subbedTiles.clear(); //panda feliratkozasainak torlese
			for(Tile newTileNeighbor:newTile.getNeighbors()) { 
				if(map.getSpecificTiles(hatesEntity).contains(newTileNeighbor)) {
					addSubbedTile(newTileNeighbor); //az uj helyen szomszedok felirasa pandara
					newTileNeighbor.addSubbedPanda(this); //az uj helyen szomszedokra feliratkozasok					
				}			
			}
			newTile.setAnimal(this);
			tile.setAnimal(null);
			tile=newTile;			
		}

		Logger.exit(this, "step", success);
		return success;
	}

	@Override
	public boolean getCaughtBy(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "getCaughtBy", par);
		
		if(isFollowing()) //mar elkapott pandat nem kapunk el
		{
			Logger.exit(this, "getCaughtBy", false);
			return false;
		}
		
		
		setIsFollowing(true);
		setFollowing(o);
		if(o.isFollowedBy()){
			setIsFollowedBy(true);
			setFollowedBy(o.followedBy);
			followedBy.setFollowing(this);			
		}
		o.setFollowedBy(this);
		o.setIsFollowedBy(true);
		
		Logger.exit(this, "getCaughtBy", true);
		return true;
	}
}
