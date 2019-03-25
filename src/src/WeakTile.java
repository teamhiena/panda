import java.util.ArrayList;

public class WeakTile extends Tile {
	private int numOfSteps=20;
	private boolean isBroken=false;

	//METODUSOK
	public void reduceNumOfSteps() {
		numOfSteps--;
		if(numOfSteps<=0)
			isBroken=true;
	}
	//este ranezek (G)
    public boolean receieveAnimal(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "receiveAnimal", par);

    	if(isBroken()) {
    		o.die();
    		Logger.exit(this, "receiveAnimal", false);
    		return false;    		
    	}
    	reduceNumOfSteps();
    	boolean success=false;
    	if(entity!=null)//ha van ott entiy akk megprobalok belelepni
    		success=entity.stepIn(o); //ha nem enterable vagy panda ul benne akk false
    	else if(animal!=null) {
    		success=animal.getCaughtBy(o);
    	}

		Logger.exit(this, "receiveAnimal", success);
    	return false;
    }
    
    public boolean isBroken() {
    	return isBroken;
    }


    public boolean recieveAnimal(Panda p) {
		ArrayList<Object> par = new ArrayList<>(); par.add(p);
		Logger.enter(this, "receiveAnimal", par);
		
    	if(isBroken()) {
    		p.die();
    		Logger.exit(this, "receiveAnimal", false);
    		return false;
    	}
    	reduceNumOfSteps();
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
}
