import java.util.ArrayList;

public class Game{
	private int numberofplayers;
	public void main() {
		Logger.enter(this, "main", new ArrayList<>());
		//TODO: Mit csinál ez?
		Logger.exit(this, "main", null);
	}
	public void exiting(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "exiting", par);
		//TODO
		Logger.exit(this, "exiting", null);
	}
	public void reward() {
		Logger.enter(this, "reward", new ArrayList<>());
		//TODO
		Logger.exit(this, "reward", null);
	}
	public void SaveHighScore(int s) {
		ArrayList<Object> par = new ArrayList<>(); par.add(s);
		Logger.enter(this, "SaveHighScore", par);
		//TODO
		Logger.exit(this, "SaveHighScore", null);
	}
	public void gameOver() {
		Logger.enter(this, "gamaOver", new ArrayList<>());
		//TODO
		Logger.exit(this, "gameOver", null);
	}
	public void weakTilesAddlife() {
		Logger.enter(this, "weakTilesAddlife", new ArrayList<>());
		//TODO
		Logger.exit(this, "weakTilesAddlife", null);
	}
}
