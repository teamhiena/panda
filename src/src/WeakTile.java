import java.util.ArrayList;

public class WeakTile extends Tile {
	private int numOfSteps=20;
	private boolean isBroken=false;

	//METÓDUSOK
	public void reduceNumOfSteps() {
		numOfSteps--;
		if(numOfSteps<=0)
			isBroken=true;
	}
    public boolean receieveAnimal(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "receiveAnimal", par);

    	if(animal!=null && animal.getCaughtBy(o))
    	if(animal.getCaughtBy(o))
	    	{
	    		
	    	}

		Logger.exit(this, "receiveAnimal", true);
    	return false; //csak tesztelés miatt
    }
    
    public boolean isBroken() {
    	return isBroken;
    }

	//Ezt nem igazan vagom mi tortenik, de ebbe meg kene hivni a reducenumofsteps()-et
    public boolean recieveAnimal(Panda p) {
		ArrayList<Object> par = new ArrayList<>(); par.add(p);
		Logger.enter(this, "receiveAnimal", par);

    	if(animal!=null) //ha van ott allat akk fix off
		{
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
		return true; //csak tesztelés miatt
    }
}
