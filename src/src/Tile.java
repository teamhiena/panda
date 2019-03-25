import java.util.ArrayList;
import java.util.Random;

public class Tile {
	//A Tile-on all-e valamilyen entitas (arcade, automat stb). Null eseten nem talalhato ilyen.
	protected Entity entity=null; 
	//A Tile-on all-e Orangutan/Panda, null esetén nincs rajta semmi.
	protected Animal animal=null;
	//A Tile szomszédos Tile-jait tároló lista
	private ArrayList<Tile> neighbors=new ArrayList<Tile>();
	//A Tile-ra feliratkozott pandák.
	private ArrayList<Panda> subbedPandas=new ArrayList<Panda>();

	//METODUSOK
	/*
	 * A Tile-rol elenged egy Animalt, azaz ezutan ures.
	 */
    public void releaseAnimal(){
    	Logger.enter(this, "releaseAnimal", new ArrayList<>());
    	animal=null;
    	Logger.exit(this, "releaseAnimal", null);
    }
    /*
     * Beallitja az Animal-t a Tile-ra.
     */
    public void setAnimal(Animal a) {
    	ArrayList<Object> par = new ArrayList<>(); par.add(a);
    	Logger.enter(this, "setAnimal", par);
    	animal=a;
    	Logger.exit(this, "setAnimal", null);
    }
    /*
     * Atveszi a Pandat
     * Ha az adott Tile-on all allat, akkor nem veszi at az allatot
     * Ha az adott Tile-on entitas all, akkor az entitastol fugg, mi tortenik ott
     * (Fotel es Wardrobe eseten atveszi)
     * Ha nincs rajta semmi, akkor atveszi
     */
    public boolean receiveAnimal(Panda p) {
    	ArrayList<Object> par = new ArrayList<>(); par.add(p);
		Logger.enter(this, "receiveAnimal", par);
		
		boolean success=false;
		if(animal!=null) { //ha van ott allat akk fix off
			Logger.exit(this, "receiveAnimal", false);
			return false;
		}
    	else if (entity!=null) { //ha van ott entity akkor attol fugg
    		success=entity.stepIn(p);		
    	}
    	Logger.exit(this, "receiveAnimal", success);
		return success;
    }
    /*
     * Atveszi a Orangutant
     * Ha az adott Tile-on all allat, akkor nem veszi at az allatot
     * Ha az adott Tile-on entitas all, akkor az entitastol fugg, mi tortenik ott
     * (Fotel es Wardrobe eseten atveszi)
     * Ha nincs rajta semmi, akkor atveszi
     */
    public boolean receiveAnimal(Orangutan o) {
    	ArrayList<Object> par = new ArrayList<>(); par.add(o);
		Logger.enter(this, "receiveAnimal", par);
		
		boolean success=false;
    	if(entity!=null)//ha van ott entiy akk megprobalok belelepni
    		success=entity.stepIn(o); //ha nem enterable vagy panda ul benne akk false
    	else if(animal!=null) {
    		success=animal.getCaughtBy(o);
    	}
    	//nincs ott allat de olyan entity van amibe (most) nem lehet belelepni
    	//pl nonenterableentity vagy egy hasznalatban levo fotel
    	Logger.exit(this, "receiveAnimal", success);
		return success;
    }
    // Eltavolitja a Pandat a Tile szomszedos Tile-jainak feliratkozoi kozul
    public void removePandaFromNeighborSubbedPandas(Panda p) {
    	for(Tile nt:neighbors)
    		nt.removeSubbedPanda(p);
    }
    // Panda feliratkozasa a Tile-ra
    public void addSubbedPanda(Panda p) {
    	subbedPandas.add(p);
    }
    // Eltavolitja a pandat a feliratkozoi kozul
    public void removeSubbedPanda(Panda p) {
    	subbedPandas.remove(p);
    }
    // Visszaadja az entitast ami rajta all.
    public Entity getEntity() {
    	return entity;
    } 
    // Visszaadja a szomszedos Tile-okat
    public ArrayList<Tile> getNeighbors(){
    	return neighbors;
    }
    // Visszaadja a feliratkozott pandakat
	public ArrayList<Panda> getSubbedPandas() {
		return subbedPandas;
	}
	// Visszaadja a Tile-on allo allatot.
	public Animal getAnimal() {
		return animal;
	}
}
