
public class Wardrobe extends Entity {
	private Tile previousExitTile=null;
	private Tile entrance;
	private Map map; //todo init
	
	//KONSTRUKTOROK
	public Wardrobe(Tile e) {
		entrance=e;
	}
	
	/* overrideolni kell a stepIn(Animal)-t, de itt kette kene agaznia, stepIn(Panda), stepIn(Orangutan)
	 * nem tudom overrideolni csak ugyanolyan parameterrel, ha meg nem override akkor sir h 
	 * overrideolatlan methodus van es implementaljam
	 * szedjuk kette az absztrakt osztalyban?
	 * */
	 

	public boolean stepIn(Orangutan o) {
		
	}
	
	public boolean stepIn(Panda p) {
		
	}
	
	public void setPreviousExitTile(Tile t) {
		previousExitTile=t;
	}
}
