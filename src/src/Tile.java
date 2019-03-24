import java.util.ArrayList;
import java.util.Random;

public class Tile {
    /**
     * Kilépteti a rajta található állatot.
     */
	private Entity entity=null;
	protected Animal animal=null;
	private ArrayList<Tile> neighbors=new ArrayList<Tile>();
	private ArrayList<Panda> subbedPandas=new ArrayList<Panda>();
	
    public void releaseAnimal(){
    	animal=null;
    }
    
    public void setAnimal(Animal a) {
    	animal=a;
    }
    
    public boolean recieveAnimal(Panda p) {
    	if(animal!=null) //ha van ott allat akk fix off
    		return false;
    	else if (entity!=null) { //ha van ott entity akkor attol fugg
    		if (entity.stepIn(p)) { //bele lehet lepni
				animal=p;
				return true;   
			} 		
    	}
    	//nincs ott allat de olyan entity van amibe (most) nem lehet belelepni
    	//pl nonenterableentity vagy egy hasznalatban levo fotel
    	return false;
    }
    
    public boolean recieveAnimal(Orangutan o) {
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
