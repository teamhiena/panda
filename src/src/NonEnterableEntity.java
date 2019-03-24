
public abstract class NonEnterableEntity extends Entity{

	public boolean stepIn(Animal a) {
		return false;
	}
	
	public abstract void makeEffect();
}
