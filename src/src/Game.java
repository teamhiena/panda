import java.util.ArrayList;

public class Game{
	private int numberofplayers = 1;
	private GameMode selectedMode;
	private GameMap map;

	//a jatekmodok
	enum GameMode{
		FinitPanda,
		FinitTime
	}

 	/*
	public void main() {
		Logger.enter(this, "main", new ArrayList<>());
		//TODO

		Logger.exit(this, "main", null);
	}*/

	//kezeli az orangutan kilepeset
	public void exiting(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "exiting", par);

		int num = o.getPandaNum(); //az orangutant koveto pandak szama
		if(num >= 5) 			   //ha tobb mint 5
			this.reward();
		o.increaseScore(num); 	   //noveli az orangutan pontjait
		o.goToEntry(); 		  	   //a bejarathoz helyezi az orangutant

		Logger.exit(this, "exiting", null);
	}

	//kezeli a jutalmat 5 kivitt panda utan
	public void reward() {
		Logger.enter(this, "reward", new ArrayList<>());

		this.weakTilesAddlife(); 				  //noveli a gyenge csempek eleterejet

		//jatekmodtol fuggoen vagy csokkenti, vagy noveli az idot
		if(selectedMode == GameMode.FinitPanda)
			Timer.instance().decreaseTime(5);
		if(selectedMode == GameMode.FinitTime)
			Timer.instance().increaseTime(5);

		Logger.exit(this, "reward", null);
	}

	//az elert pontszamot menti el
	public void SaveHighScore(int s) {
		ArrayList<Object> par = new ArrayList<>(); par.add(s);
		Logger.enter(this, "SaveHighScore", par);

		//itt meg csak kiirja a pontszamot
		System.out.println("Current score: " + s);

		Logger.exit(this, "SaveHighScore", null);
	}

	//a jatek vege, visszalep a fomenube
	public void gameOver() {
		Logger.enter(this, "gamaOver", new ArrayList<>());
		//TODO

		Logger.exit(this, "gameOver", null);
	}

	//noveli a gyenge csempek eleterejet
	public void weakTilesAddlife() {
		Logger.enter(this, "weakTilesAddlife", new ArrayList<>());

		ArrayList<WeakTile> weakTiles = GameMap.instance().getWeakTiles();
		for (WeakTile tl: weakTiles) {
			tl.reduceNumOfSteps();
		}

		Logger.exit(this, "weakTilesAddlife", null);
	}

	//visszaadja a valasztott jatekmodot
	public GameMode getSelectedMode() {
		return selectedMode;
	}

	//beallitja a valaszott jatekmodot
	public void setSelectedMode(GameMode selectedMode) {
		this.selectedMode = selectedMode;
	}
}
