import java.util.ArrayList;

public abstract class Animal implements Steppable{
    protected Tile tile; //Ezen all az allat.
    private Tile nextTile=null; //Ez lesz a kovetkezo mezo, amire lepni fog.
    protected Animal followedBy=null; //Ez az allat koveti.
    private Animal following=null; //Ezt az allatot koveti.
    private  boolean isFollowedBy = false; //Megadja, hogy koveti-e valakit.
    private boolean isFollowing = false; //Megadja, hogy kovet-e valakit.
    
    //KONSTRUKTOROK
    public Animal(Tile t) {
    	tile=t;
    }
    public Animal() {
    	tile=null;
    }
        
<<<<<<< HEAD
    //METODUSOKK
    public void die(){
        Logger.enter(this, "die", new ArrayList<>());

        Logger.exit(this, "die", null);

    }
    
=======
    //METODUSOK
    /**
     * Tile adattag getter/setter fuggvenye.
     */
>>>>>>> branch 'master' of https://github.com/teamhiena/panda_szkeleton.git
	public void setTile(Tile t) {
        ArrayList<Object> par = new ArrayList<>(); par.add(t);
        Logger.enter(this, "setTile", par);
		tile=t;
		Logger.exit(this, "setTile", null);
	}
	public Tile getTile() {
		return tile;
	}
    /**
    * Following adattag setter fuggvenye.
    */
	public void setFollowing(Animal a) {
        ArrayList<Object> par = new ArrayList<>(); par.add(a);
        Logger.enter(this, "setFollowing", par);
		following=a;
        Logger.exit(this, "setFollowing", null);
	}

    /**
     * isFollowing adattag getter/setter fuggvenye.
     */
    public boolean isFollowing() {
        Logger.enter(this, "isFollowing", new ArrayList<>());
        boolean ret = false;
        if(following != null) ret = true;
        Logger.exit(this, "isFollowing", ret);
        return ret;
    }
    public void setIsFollowing(boolean f){
        ArrayList<Object> par = new ArrayList<>(); par.add(a);
        Logger.enter(this, "setFollowing", par);
        isFollowing = f;
    }

    /**
     * FollowedBy adattag setter fuggvenye.
     */
    public void setFollowedBy(Animal a) {
        ArrayList<Object> par = new ArrayList<>(); par.add(a);
        Logger.enter(this, "setFollowedBy", par);
        followedBy = a;
        Logger.exit(this, "setFollowedBy", null);
    }

    /**
     * isFollowedBy adattag getter/setter fuggvenye.
     */
    public boolean isFollowedBy() {
        Logger.enter(this, "isFollowedBy", new ArrayList<>());
        boolean ret = false;
        if(followedBy!=null) ret = true;
        Logger.exit(this, "isFollowedBy", ret);
    	return ret;
    }
    public void setIsFollowedBy(boolean f){
        ArrayList<Object> par = new ArrayList<>(); par.add(f);
        Logger.enter(this, "setFollowedBy", par);
        isFollowedBy = f;
        Logger.exit(this, "setFollowedBy", null);
    }

    /**
     *
     */
    public void releaseFollowerRecursively() {
        Logger.enter(this, "releaseFollowerRecursively", new ArrayList<>());
        //TODO
        Logger.exit(this, "releaseFollowerRecursively", null);
    }

    /**
     * Az allatot elkapja egy Panda. Valojaban lehetetlen esemeny, de muszaj megvalositani.
     * @param p
     */
    public boolean getCaughtBy(Panda p){
        return false;
    }

    /**
     * Akkor hivodik meg, amikor az allat meghal.
     */
    public void die(){
        Logger.enter(this, "die", new ArrayList<>());
        //TODO
        Logger.exit(this, "die", null);
    }

    /**
     * Az allatot elkapja egy orangutan. Leszarmazottakban felulirando.
     */
    public abstract boolean getCaughtBy(Orangutan o);
}
