public class WeakTile extends Tile {
	private int numOfSteps=20;
	private boolean isBroke=false;
	public void reduceNumOfSteps() {
		numOfSteps--;
	}
	@Override
    public boolean recieveAnimal(Orangutan o) {
    	if(animal!=null && animal.getCaughtBy(o))
    	if(animal.getCaughtBy(o))
    	{
    		
    	}
    	return false; //csak tesztelés miatt
    }
	//Ezt nem igaz�n v�gom mi t�rt�nik, de ebbe meg k�ne h�vni a reducenumofsteps()-et
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
}
