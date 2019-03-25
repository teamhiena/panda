import java.util.ArrayList;

public class Timer{
	ArrayList<NonEnterableEntity> Entities = new ArrayList<>();
	ArrayList<Steppable> Steppable = new ArrayList<>();
	private static Timer instance = null;
	private int elapsedTime = 0;

	static public Timer instance() {
		if (instance == null) instance = new Timer();
		return instance;
	}

	public void finalize() {
		instance = null;
	}

	public void Tick() {

		elapsedTime++;
	}
	public int getTime() {
		return elapsedTime;
	}
	public void addSteppable(Steppable s) {
		Steppable.add(s);
	}
	public void removeSteppable(Steppable s) {
		Steppable.remove(s);
	}
	public void addEntity(Entity e) {
		Entities.add(e);
	}
	public void decreaseTime(int t) {
		if(elapsedTime < t)
			elapsedTime = 0;
		else
			elapsedTime -= t;
	}
	public void increaseTime(int t) {
		elapsedTime+=t;
	}
	public ArrayList<NonEnterableEntity> getEntities(){
		return Entities;
	}
	public ArrayList<Steppable> getSteppables(){ return Steppable; }
}
