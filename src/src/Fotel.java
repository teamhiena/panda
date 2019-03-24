import java.util.ArrayList;
import java.util.Random;

public class Fotel extends Entity{
	private Tile enteredFrom=null;
	private long timeLeft=100; //vitathato(mennyi legyen?)

	public boolean stepIn(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "stepIn", par);
		Logger.exit(this, "stepIn", false);
		return false;
	}	
	public boolean stepIn(Panda p) {
		ArrayList<Object> par = new ArrayList<>(); par.add(p);
		Logger.enter(this, "stepIn", par);
		boolean ret = false;
		//TODO
		Logger.exit(this, "stepIn", ret);
		return ret;
	}
	
	public boolean isEmpty() {
		Logger.enter(this, "stepIn", new ArrayList<>());
		boolean ret = false;
		if(tile.animal == null) ret = true;
		Logger.exit(this, "stepIn", ret);
		return ret;
	}
	
	public void decrTimeLeft() {
		Logger.enter(this, "decrTimeLeft", new ArrayList<>());
		timeLeft--;
		Logger.exit(this, "decrTimeLeft", null);
	}
	
	public void resetTime() {
		Logger.enter(this, "resetTime", new ArrayList<>());
		timeLeft=100;
		Logger.exit(this, "resetTime", null);
	}
	
    public Panda getRandomSubbedPanda(){
    	//full nem emlekszem ez mire jo (G)
		Logger.enter(this, "getRandomSubbedPanda", new ArrayList<>());
    	Random vel=new Random();

    	return tile.subbedPandas.get(vel.nextInt(tile.subbedPandas.size()-1));
    } 
}

