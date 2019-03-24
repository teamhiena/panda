import java.util.ArrayList;

public abstract class Panda extends Animal{
	protected Animal following=null;
	protected ArrayList<Tile> subbedTiles=new ArrayList<Tile>();
	protected GameMap map; //TODO:inicializalni
	protected GameMap.Key hatesEntity;	
	
	//METODUSOK
	public abstract void affectedBy(Entity e);
	
	public void addSubbedTile(Tile t) {
		ArrayList<Object> par = new ArrayList<>(); par.add(t);
		Logger.enter(this, "addSubbedTile", par);
		subbedTiles.add(t);
		Logger.exit(this, "addSubbedTile", null);
	}
	
	public void clearSubbedTiles() {
		Logger.enter(this, "clearSubbedTiles", new ArrayList<>());
		subbedTiles.clear();
		Logger.exit(this, "clearSubbedTiles", null);
	}
	
	public void setTile(Tile t) {
		ArrayList<Object> par = new ArrayList<>(); par.add(t);
		Logger.enter(this, "setTile", par);
		tile=t;
		Logger.exit(this, "setTile", null);
	}
	
	public void setFollowing(Animal a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "setTile", par);
		following=a;
		Logger.exit(this, "setTile", null);
	}
	
    public boolean isFollowing() {
		Logger.enter(this, "isFollowing", new ArrayList<>());
		boolean ret = false;
		if(following != null) ret = true;
		Logger.exit(this, "isFollowing", ret);
		return ret;
    }
	
	@Override
	public void step(Tile newTile) {
		ArrayList<Object> par = new ArrayList<>(); par.add(newTile);
		Logger.enter(this, "Panda::step", par);

		if(newTile.recieveAnimal(this)) {
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

		Logger.exit(this, "Panda::step", null);
	}


}
