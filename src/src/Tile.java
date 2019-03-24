import java.util.ArrayList;
import java.util.Random;

public class Tile {
	protected Entity entity=null;
	protected Animal animal=null;
	private ArrayList<Tile> neighbors=new ArrayList<Tile>();
	private ArrayList<Panda> subbedPandas=new ArrayList<Panda>();

	//METODUSOK
    public void releaseAnimal(){
    	Logger.enter(this, "releaseAnimal", new ArrayList<>());
    	animal=null;
    	Logger.exit(this, "releaseAnimal", null);
    }
    
    public void setAnimal(Animal a) {
    	ArrayList<Object> par = new ArrayList<>(); par.add(a);
    	Logger.enter(this, "setAnimal", par);
    	animal=a;
    	Logger.exit(this, "setAnimal", null);
    }
    
    public boolean receiveAnimal(Panda p) {
    	ArrayList<Object> par = new ArrayList<>(); par.add(p);
		Logger.enter(this, "receiveAnimal", par);

		if(animal!=null) { //ha van ott allat akk fix off
			Logger.exit(this, "receiveAnimal", false);
			return false;
		}
    	else if (entity!=null) { //ha van ott entity akkor attol fugg
    		if (entity.stepIn(p)) { //bele lehet lepni
				animal=p;
			} 		
    	}
    	//nincs ott allat de olyan entity van amibe (most) nem lehet belelepni
    	//pl nonenterableentity vagy egy hasznalatban levo fotel
    	Logger.exit(this, "receiveAnimal", true);
		return true;
    }
    
    public boolean receiveAnimal(Orangutan o) {
    	if(animal!=null && animal.getCaughtBy(o))
    	if(animal.getCaughtBy(o))
    	{
    		
    	}
    	return false; //csak tesztelés miatt
    }
    
    public void removePandaFromNeighborSubbedPandas(Panda p) {
    	for(Tile nt:neighbors)
    		nt.removeSubbedPanda(p);
    }
    
    public void addSubbedPanda(Panda p) {
    	subbedPandas.add(p);
    }
    
    public void removeSubbedPanda(Panda p) {
    	subbedPandas.remove(p);
    }
    
    public Entity getEntity() {
    	return entity;
    } 
    
    public ArrayList<Tile> getNeighbors(){
    	return neighbors;
    }

	public ArrayList<Panda> getSubbedPandas() {
		return subbedPandas;
	}

	public Animal getAnimal() {
		return animal;
	}
}
