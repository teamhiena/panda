import java.util.ArrayList;
import java.util.Random;

/**
 * A fotelt megvalosito osztaly. Ha egy faradekony panda elhalad mellette, akkor leul.
 */
public class Fotel extends Entity{
	private Tile enteredFrom=null; //Errol a mezorol lehet belepni a fotelre.
	private long timeLeft=100; //Ennyi ido van meg hatra.(eddig ul meg ott a panda)

	//METODUSOK

	/**
	 * Egy orangutan megprobal belepni a fotelbe. Ez termeszetesen nem lehetseges.
	 * @param o
	 * @return
	 */
	public boolean stepIn(Orangutan o) {
		ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "stepIn", par);
		Logger.exit(this, "stepIn", false);
		return false;
	}

	/**
	 * Egy panda megprobal belepni a fotelbe.
	 * @param p
	 * @return
	 */
	public boolean stepIn(Panda p) {
		if (tile.getAnimal()!=null) return false; //Nem valoszinu, hogy szukseges.
		enteredFrom=p.getTile();
		resetTimeLeft();
		p.affectedBy(this);
		return true;		
	}

	/**
	 * Megmondja, hogy van-e valaki a fotelban.
	 */
	public boolean isEmpty() {
		Logger.enter(this, "isEmpty", new ArrayList<>());
		boolean ret = false;
		if(tile.getAnimal() == null) ret = true;
		Logger.exit(this, "isEmpty", ret);
		return ret;
	}

	/**
	 * Csokkenti a hatra levo idot.
	 */
	public void decrTimeLeft() {
		Logger.enter(this, "decrTimeLeft", new ArrayList<>());
		timeLeft--;
		Logger.exit(this, "decrTimeLeft", null);
	}
	/**
	 * Ujrainditja az ido szamlalojat.
	 */
	public void resetTimeLeft() {
		Logger.enter(this, "resetTimeLeft", new ArrayList<>());
		timeLeft=100;
		Logger.exit(this, "resetTimeLeft", null);
		}

	/**
	 * Nem biztos hogy van funkcioja.
	 */
    public Panda getRandomSubbedPanda(){
    	Random vel=new Random();
    	return tile.getSubbedPandas().get(vel.nextInt(tile.getSubbedPandas().size()-1));    	
    } 
}

