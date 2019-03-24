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
    	//a visszateresi erteke prfect lehet false ha van itt valami
    }
    
    public void refreshSubs(Panda p) {
    	
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
