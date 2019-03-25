import java.util.ArrayList;

public class Orangutan extends Animal {
    private int score = 0;
    private Game game; //nem szep

    //METODUSOK
    /**
     *
     * @param t(Tile): Errre a mezore szeretnenk leptetni az orangutant.
     * @return Megadja, hogy sikerult-e a muvelet.
     */
    @Override
    public boolean step(Tile t) {
        ArrayList<Object> par = new ArrayList<>(); par.add(t);
    	Logger.enter(this, "step", par);
    	
    	boolean success=t.receiveAnimal(this);
    	if(success)
    	{
    		t.setAnimal(this);
			tile.setAnimal(null);
			tile=t;	
    	}
    	
    	Logger.exit(this, "step", null);
    	return success;
    }
    
    public void increaseScore(int p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "increaseScore", par);
        score += p;
        Logger.exit(this, "increaseScore", null);

        //Minden novelesnel megnezzuk, hogy elertuk-e a gyozelem szukseges pandaszamot
        if(score >= 25 && game.getSelectedMode() == Game.GameMode.FinitPanda){
            //Ha elértük, szólunk a játéknak hogy vége (viszont ehhez kell egy game referencia!)
            game.SaveHighScore(score);
            game.gameOver();
        }
    }
    
    public int getPandaNum() {
        Logger.enter(this, "getPandaNum", new ArrayList<>());
        //return mindfuck recursive fuggveny
        //TODO
        int ret = 0;
        Logger.exit(this, "getPandaNum", ret);
        return ret;
    }
    
    public void goToEntry() {
        Logger.enter(this, "goToEntry", new ArrayList<>());

        this.step(GameMap.instance().getEntryTile());

        Logger.exit(this, "goToEntry", new ArrayList<>());
    	
    }
    
    public int getScore() {
        Logger.enter(this, "getScore", new ArrayList<>());
        int ret = score;
        Logger.exit(this, "getScore", ret);
    	return ret;
    }

    @Override
    public boolean getCaughtBy(Orangutan o) {
        ArrayList<Object> par = new ArrayList<>(); par.add(o);
        Logger.enter(this, "getCaughtBy", par);
        Logger.exit(this, "getCaughtBy", false);
        return false;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
