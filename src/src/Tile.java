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
		
		boolean success=false;
		if(animal!=null) { //ha van ott allat akk fix off
			Logger.exit(this, "receiveAnimal", false);
			return false;
		}
    	else if (entity!=null) { //ha van ott entity akkor attol fugg
    		success=entity.stepIn(p);		
    	}
    	Logger.exit(this, "receiveAnimal", success);
		return success;
    }

    
    public boolean receiveAnimal(Orangutan o) {
    	ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "receiveAnimal", par);
		
		boolean success=false;
    	if(entity!=null)//ha van ott entiy akk megprobalok belelepni
    		success=entity.stepIn(o); //ha nem enterable vagy panda ul benne akk false
    	else if(animal!=null) {
    		success=animal.getCaughtBy(o);
    	}
    	//nincs ott allat de olyan entity van amibe (most) nem lehet belelepni
    	//pl nonenterableentity vagy egy hasznalatban levo fotel
    	Logger.exit(this, "receiveAnimal", success);
		return success;
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
