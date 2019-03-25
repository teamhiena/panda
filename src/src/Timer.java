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

	public void addEntity(NonEnterableEntity e) {
		Entities.add(e);
	}

	public void decreaseTime(int t) {
		if (elapsedTime < t)
			elapsedTime = 0;
		else
			elapsedTime -= t;
	}

	public void increaseTime(int t) {
		elapsedTime += t;

		//Minden eltelt Tick-re pollingoljuk, hogy lejárt-e az idő és hogy nyert-e az Orangutan
		if (elapsedTime >= 60 && game.getSelectedMode() == Game.GameMode.FinitTime) {
			//Orangutánok kinyerése
			ArrayList<Tile> orangutantiles = gamemap.getSpecificTiles(GameMap.Key.Orangutan);
			ArrayList<Orangutan> orangutans = new ArrayList<>();
			for (Tile item : orangutantiles) {
				orangutans.add((Orangutan) item.getAnimal());
			}

			//Attól függően hogy hány játékos módban vagyunk állítjuk be a HighScore-t
			Orangutan[] oarray = new Orangutan[2];
			if (orangutans.size() == 2) {
				oarray[0] = orangutans.get(0);
				oarray[1] = orangutans.get(1);

				game.SaveHighScore((oarray[0].getScore() > oarray[1].getScore()) ? oarray[0].getScore() : oarray[1].getScore());
			} else {
				game.SaveHighScore(orangutans.get(0).getScore());
			}

			//És végül lejárt az idő, game-over.
			game.gameOver();
		}
	}

	public ArrayList<NonEnterableEntity> getEntities() {
		return Entities;
	}

	public ArrayList<Steppable> getSteppables() {
		return Steppable;
	}

	public void setGamemap(GameMap gamemap) {
		this.gamemap = gamemap;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
