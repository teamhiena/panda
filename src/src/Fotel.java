
public class Fotel extends Entity{
	private Tile enteredFrom=null;
	private long timeLeft=/*vitathato*/;
	

	public boolean stepIn(Orangutan o) {
		return false;
	}	
	public boolean stepIn(Panda p) {
		
	}
	
	public boolean isEmpty() {
		return tile.animal==null;
	}
	
	public void decrTimeLeft() {
		timeLeft--;
	}
	
	public void resetTime() {
		timeLeft=/*vitathato*/;
	}
	
    public Panda getRandomSubbedPanda(){
    	//full nem emlekszem ez mire jo (G)
    	Random vel=new Random();
    	return subbedPandas.get(vel.nextInt(subbedPandas.size()-1));    	
    } 
}
