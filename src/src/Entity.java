
public abstract class Entity {
	protected Tile tile;
	public abstract boolean stepIn(Orangutan o);
	public abstract boolean stepIn(Panda p);
	//protected abstract boolean stepIn(Animal a); ennek mi értelme van? (M)
}