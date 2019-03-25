import java.util.ArrayList;

public class Timer {
	ArrayList<NonEnterableEntity> Entities = new ArrayList<>();
	ArrayList<Steppable> Steppable = new ArrayList<>();
	private static Timer instance = null;
	private int elapsedTime = 0;
	private Game game;
	private GameMap gamemap;

	static public Timer instance() {
		if (instance == null) instance = new Timer();
		return instance;
	}

	public void finalize() {
		instance = null;
	}

	public void Tick() {
		Logger.enter(this, "Tick", new ArrayList<>());
		//TODO
		elapsedTime++;
		Logger.exit(this, "Tick", null);
	}

	public int getTime() {
		Logger.enter(this, "getTime", new ArrayList<>());
		Logger.exit(this, "getTime", null);
		return elapsedTime;
	}

	public void addSteppable(Steppable s) {
		Steppable.add(s);
	}

	public void removeSteppable(Steppable s) {
		Steppable.remove(s);
	}

	public void addEntity(NonEnterableEntity e) {
		Entities.add(e);
	}

	//Csokkenti az idot parameterkent kapott masodperccel.
	public void decreaseTime(int t) {
		if (elapsedTime < t)
			elapsedTime = 0;
		else
			elapsedTime -= t;
	}

	//Noveli az idot parameterkent kapott masodperccel.
	public void increaseTime(int t) {
		ArrayList<Object> par = new ArrayList<>(); par.add(t);
		Logger.enter(this,"increaseTime", par);

		elapsedTime += t;

		//Minden eltelt Tick-re pollingoljuk, hogy lejart-e az ido és hogy nyert-e az Orangutan
		if (elapsedTime >= 60 && game.getSelectedMode() == Game.GameMode.FinitTime) {
			//Orangutanok kinyerese
			ArrayList<Tile> orangutantiles = gamemap.getSpecificTiles(GameMap.Key.Orangutan);
			ArrayList<Orangutan> orangutans = new ArrayList<>();
			for (Tile item : orangutantiles) {
				orangutans.add((Orangutan) item.getAnimal());
			}

			//Attol fuggoen hogy hany jatekos modban vagyunk allitjuk be a HighScore-t
			Orangutan[] oarray = new Orangutan[2];
			if (orangutans.size() == 2) {
				oarray[0] = orangutans.get(0);
				oarray[1] = orangutans.get(1);

				game.SaveHighScore((oarray[0].getScore() > oarray[1].getScore()) ? oarray[0].getScore() : oarray[1].getScore());
			} else {
				game.SaveHighScore(orangutans.get(0).getScore());
			}

			//Es vegul lejart az ido, game-over.
			game.gameOver();
		}

		Logger.exit(this, "increaseTime", null);
	}

	//Visszaadja a NonEnterableEntity interfeszu entitasokat
	public ArrayList<NonEnterableEntity> getEntities() {
		return Entities;
	}

	//Visszaadja a steppable interfeszu entitasokat
	public ArrayList<Steppable> getSteppables() {
		return Steppable;
	}

	/**
	 * A gamemap valtozo setter illetve getter fuggvenyei.
	 */
	public void setGamemap(GameMap gamemap) {
		this.gamemap = gamemap;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}
