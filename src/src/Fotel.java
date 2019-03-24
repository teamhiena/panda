
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
}
