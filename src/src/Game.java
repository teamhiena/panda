import java.util.ArrayList;

public class Game{
	private int numberofplayers;
	private GameMode selectedMode;
	private GameMap map;

	enum GameMode{
		FinitPanda,
		FinitTime
	}

	public void main() {
		Logger.enter(this, "main", new ArrayList<>());
		//TODO: Mit csinal ez???

		Logger.exit(this, "main", null);
	}
	public void exiting(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "exiting", par);

		int num = o.getPandaNum();
		if(num >= 5)
			this.reward();
		o.increaseScore(num);
		o.goToEntry();

		Logger.exit(this, "exiting", null);
	}
	public void reward() {
		Logger.enter(this, "reward", new ArrayList<>());

		this.weakTilesAddlife();
		if(selectedMode == GameMode.FinitPanda)
			Timer.instance().decreaseTime(5);
		if(selectedMode == GameMode.FinitTime)
			Timer.instance().increaseTime(5);

		Logger.exit(this, "reward", null);
	}
	public void SaveHighScore(int s) {
		ArrayList<Object> par = new ArrayList<>(); par.add(s);
		Logger.enter(this, "SaveHighScore", par);

		System.out.println("Current score: " + s);

		Logger.exit(this, "SaveHighScore", null);
	}
	public void gameOver() {
		Logger.enter(this, "gamaOver", new ArrayList<>());
		//TODO ez lep vissza a fomenube

		Logger.exit(this, "gameOver", null);
	}
	public void weakTilesAddlife() {
		Logger.enter(this, "weakTilesAddlife", new ArrayList<>());

		ArrayList<WeakTile> weakTiles = GameMap.instance().getWeakTiles();
		for (WeakTile tl: weakTiles) {
			tl.reduceNumOfSteps();
		}

		Logger.exit(this, "weakTilesAddlife", null);
	}

	public GameMode getSelectedMode() {
		return selectedMode;
	}

	public void setSelectedMode(GameMode selectedMode) {
		this.selectedMode = selectedMode;
	}
}
