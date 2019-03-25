import java.util.ArrayList;

public class TiredPanda extends Panda {

	//KONSTRUKTOROK
	public TiredPanda(GameMap gm) {
		hatesEntity=GameMap.Key.Fotel;
		map = gm;
	}

	//METÓDUSOK
    public void affectedBy(Fotel f) {
		ArrayList<Object> par = new ArrayList<>(); par.add(f);
    	Logger.enter(this, "affectedBy", par);
    	//TODO
		Logger.exit(this, "affectedBy", null);
    }
}
