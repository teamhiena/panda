import java.util.ArrayList;

public class DiabeticPanda extends Panda {
	public DiabeticPanda() {
		hatesEntity="Fotel";
	}
    public void affectedBy(Automat a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "affectedBy", par);

		Logger.exit(this, "affectedBy", null);
    }
}
