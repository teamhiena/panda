import java.util.ArrayList;

public abstract class Animal implements Steppable{
    protected Tile tile;
    private Tile nextTile=null;
    protected Animal followedBy=null;
    private Animal following=null;
    private  boolean isFollowedBy = false;
    private boolean isFollowing = false;
    
    //KONSTRUKTOROK
    public Animal(Tile t) {
    	tile=t;
    }

    public Animal() {
    	tile=null;
    }
        
    //METODUSOKK
    public void die(){
        Logger.enter(this, "die", new ArrayList<>());

        Logger.exit(this, "die", null);

    }
    
	public void setTile(Tile t) {
		tile=t;
	}
	
	public Tile getTile() {
		return tile;
	}
    
	public void setFollowing(Animal a) {
		following=a;
	}
	
    public boolean isFollowing() {
    	return following!=null;
    }

    public void setIsFollowing(boolean f){
        isFollowing = f;
    }
    
    public void setFollowedBy(Animal a) {
        ArrayList<Object> par = new ArrayList<>(); par.add(a);
        Logger.enter(this, "setFollowedBy", par);
        followedBy = a;
        Logger.exit(this, "setFollowedBy", null);
    }
    
    public boolean isFollowedBy() {
        Logger.enter(this, "isFollowedBy", new ArrayList<>());
        boolean ret = false;
        if(followedBy!=null) ret = true;
        Logger.exit(this, "isFollowedBy", ret);
    	return ret;
    }

    public void setIsFollowedBy(boolean f){
        isFollowedBy = f;
    }

    
    public void releaseFollowerRecursively() {
        Logger.enter(this, "releaseFollowerRecursively", new ArrayList<>());

        Logger.exit(this, "releaseFollowerRecursively", null);
    }
    
    public boolean getCaughtBy(Panda p){
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "getCaughtBy", par);
        Logger.exit(this, "getCaughtBy", false);
        return false;
    }
    public abstract boolean getCaughtBy(Orangutan o);
}
