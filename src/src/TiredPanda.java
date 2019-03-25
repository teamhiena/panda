import java.util.ArrayList;

/**
 * A faradekony pandat(TiredPanda) megvalosito osztaly.
 */
public class TiredPanda extends Panda {

	//KONSTRUKTOROK
	public TiredPanda(GameMap gm) {
		hatesEntity=GameMap.Key.Fotel;
		map = gm;
	}

	//METODUSOK

	/**
	 * A Panda egy f Fotel hatasa ala kerul.
	 */
    public void affectedBy(Fotel f) {
		ArrayList<Object> par = new ArrayList<>(); par.add(f);
    	Logger.enter(this, "affectedBy", par);
    	//TODO
		Logger.exit(this, "affectedBy", null);
    }
}
