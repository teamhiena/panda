import java.util.ArrayList;
import java.util.Random;

public class Tile {
    /**
     * Kilépteti a rajta található állatot.
     */
	private Entity entity=null;
	protected Animal animal=null;
	protected ArrayList<Tile> neighbors=new ArrayList<Tile>();
	protected ArrayList<Panda> subbedPandas=new ArrayList<Panda>();
	
    public void releaseAnimal(){
    	animal=null;
    }
    
    public void setAnimal(Animal a) {
    	animal=a;
    }
    
    public boolean recieveAnimal(Animal a) {
    	if(animal!=null) //ha van ott allat akk fix off
    		return false;
    	else if (entity!=null) { //ha van ott entity akkor attol fugg
    		if (entity.stepIn(a)) { //bele lehet lepni
				animal=a;
				return true;   
			} 		
    	}
    	//nincs ott allat de olyan entity van amibe (most) nem lehet belelepni
    	//pl nonenterableentity vagy egy hasznalatban levo fotel
    	return false;
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
}
