import java.util.ArrayList;

public abstract class Panda extends Animal{
	protected Animal following=null;
	protected ArrayList<Tile> subbedTiles=new ArrayList<Tile>();
	protected GameMap map; //TODO:inicializalni
	protected GameMap.Key hatesEntity;	
	
	//METODUSOK
	public void affectedBy(Entity e) {
		//el tudom lepzelni hogy ennek semmi ertelme mert ugyis csak ugyanolyan parameterrel lehet overrideolni (G)
	}
	
	public void addSubbedTile(Tile t) {
		subbedTiles.add(t);
	}
	
	public void clearSubbedTiles() {
		subbedTiles.clear();
	}
	
	public void setTile(Tile t) {
		tile=t;
	}
	
	public void setFollowing(Animal a) {
		following=a;
	}
	
    public boolean isFollowing() {
    	return following!=null;
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
