/**
 * Egy entitast megvalosito absztrakt ososztaly.
 */
public abstract class Entity {
	protected Tile tile;
	public abstract boolean stepIn(Orangutan a);
	public abstract boolean stepIn(Panda p);
	
	public void setTile(Tile t) {
		tile=t;
	}
}