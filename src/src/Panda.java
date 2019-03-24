import java.util.ArrayList;

public abstract class Panda extends Animal{
	protected Animal following=null;
	protected ArrayList<Tile> subbedTiles=new ArrayList<Tile>();
	protected Map map; //todo:inicializálni
	
	
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
	
}
