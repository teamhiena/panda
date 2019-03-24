import java.util.ArrayList;

public class DiabeticPanda extends Panda {

	//KONSTRUKTOROK
	public DiabeticPanda(GameMap gm) {
		map = gm;
		hatesEntity=GameMap.Key.Automat;
	}

	//METÓDUSOK
    public void affectedBy(Automat a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "affectedBy", par);

		Logger.exit(this, "affectedBy", null);
    }
}
