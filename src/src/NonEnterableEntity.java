
public abstract class NonEnterableEntity extends Entity{

	@Override
	public boolean stepIn(Orangutan o) {
		return false;
	}
	
	@Override
	public boolean stepIn(Panda p) {
		return false;
	}
	
	public abstract void makeEffect();
}
