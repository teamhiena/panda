import java.util.ArrayList;

public class AfraidPanda extends Panda {
	public AfraidPanda() {
		hatesEntity="Fotel";
	}
    public void affectedBy(Arcade a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "affectedBy", par);

		Logger.exit(this, "affectedBy", null);

    }
}
 