import java.util.ArrayList;

public class AfraidPanda extends Panda {
	public AfraidPanda() {
		hatesEntity=GameMap.Key.Arcade;
	}

	//KONSTRUKTOROK
	public AfraidPanda(GameMap gm){
		map = gm;
	}

	//METÓDUSOK
    public void affectedBy(Arcade a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "affectedBy", par);
		//TODO
		Logger.exit(this, "affectedBy", null);

    }
}
 