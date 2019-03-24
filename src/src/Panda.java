import java.util.ArrayList;

public abstract class Panda extends Animal{
	//private Animal following=null;
	private ArrayList<Tile> subbedTiles=new ArrayList<Tile>();
	protected GameMap map; //TODO:inicializalni
	protected GameMap.Key hatesEntity;

	//METODUSOK
	public void affectedBy(Entity e) {
		//el tudom lepzelni hogy ennek ssemmi ertelme mert ugyis csak ugyanolyan parameterrel lehet overrideolni (G)
	}
	
	public void addSubbedTile(Tile t) {
		subbedTiles.add(t);
	}
	
	public void clearSubbedTiles() {
		subbedTiles.clear();
	}
	
	public Tile getTile() {
		return tile;
	}
		
	@Override
	public boolean step(Tile newTile) {
		ArrayList<Object> par = new ArrayList<>(); par.add(newTile);
		Logger.enter(this, "step", par);

		boolean success=newTile.receiveAnimal(this);
		if(success) {
			tile.removePandaFromNeighborSubbedPandas(this); //panda eltavolitasa a szomszedokrol
			subbedTiles.clear(); //panda feliratkozasainak torlese
			for(Tile newTileNeighbor:newTile.getNeighbors()) { 
				if(map.getSpecificTiles(hatesEntity).contains(newTileNeighbor)) {
					addSubbedTile(newTileNeighbor); //az uj helyen szomszedok felirasa pandara
					newTileNeighbor.addSubbedPanda(this); //az uj helyen szomszedokra feliratkozasok					
				}			
			}
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

		o.tile.setAnimal(this);
		tile.setAnimal(o);
		setIsFollowing(true);
		if(o.isFollowedBy()){
			setIsFollowedBy(true);
			setFollowedBy(o.followedBy);
		}

		Logger.exit(this, "getCaughtBy", true);
		return true;
	}
}
