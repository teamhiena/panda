import java.util.ArrayList;

/**
 * Az ijedos pandat(AfraidPanda) megvalosito osztaly. Megijed a jatekgep csilingelsesetol es elengedi a mogotte allo
 * pandak mancsat, igy felbomlik a sor.
 */
public class AfraidPanda extends Panda {

	//KONSTRUKTOROK
	public AfraidPanda(GameMap gm){
		map = gm;
		hatesEntity=GameMap.Key.Arcade;
	}

	//METÓDUSOK

	/**
	 * A pandat megijeszti egy jatekgep.
	 */
    public void affectedBy(Arcade a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "affectedBy", par);
		//TODO
		Logger.exit(this, "affectedBy", null);

    }
}
 