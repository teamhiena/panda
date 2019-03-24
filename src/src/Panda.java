import java.util.ArrayList;

public abstract class Panda extends Animal{
	protected Animal following=null;
	protected ArrayList<Tile> subbedTiles=new ArrayList<Tile>();
	protected GameMap map; //todo:inicializálni
	protected String hatesEntity;
	
	
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
	
	@Override //hatesEntityket be kellene allitani
	public void step(Tile newTile) {
		clearSubbedTiles();
		tile.refreshSubs(this);
		Entity newTileEntity=newTile.getEntity();
		
		if(newTileEntity==null) {
			tile.releaseAnimal();
			newTile.recieveAnimal(this);
		}
		else {
			newTileEntity.stepIn(this);
		}
		
		for(Tile newTileNeighbor:newTile.getNeighbors()) {
			if(map.getSpecificTiles(hatesEntity).Contains(newTileNeighbor)) {
				addSubbedTile(newTileNeighbor);
				newTileNeighbor.addSubbedPanda(this);
			}
		}
	}
}
