import java.util.ArrayList;

public class AfraidPanda extends Panda {

	//KONSTRUKTOROK
	public AfraidPanda(GameMap gm){
		map = gm;
		hatesEntity=GameMap.Key.Arcade;
	}

	//METÓDUSOK
    public void affectedBy(Arcade a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "affectedBy", par);
		//TODO
		Logger.exit(this, "affectedBy", null);

    }
}
 