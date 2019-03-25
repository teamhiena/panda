import java.util.ArrayList;

public class Orangutan extends Animal {
    private int score = 0;

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
    	return success; //csak teszteleshez
    }
    
    public void increaseScore(int p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "increaseScore", par);
        score += p;
        Logger.exit(this, "increaseScore", null);
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
        //TODO
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
}
