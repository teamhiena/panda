import java.util.ArrayList;

public abstract class Animal implements Steppable{
    protected Tile tile;
    private Tile nextTile=null;
    private Animal followedBy=null;
    private Animal following=null;
    
    //KONSTRUKTOROK
    public Animal(Tile t) {
    	tile=t;
    }

    public Animal() {
    	tile=null;
    }
        
    //METODUSOK
    public void die(){
        Logger.enter(this, "die", new ArrayList<>());

        Logger.exit(this, "die", null);

    }
    
	public void setTile(Tile t) {
		tile=t;
	}
    
	public void setFollowing(Animal a) {
		following=a;
	}
	
    public boolean isFollowing() {
    	return following!=null;
    }
    
    public void setFollowedBy(Panda p) {
        ArrayList<Object> par = new ArrayList<>(); par.add(p);
        Logger.enter(this, "setFollowedBy", par);
        followedBy = p;
        Logger.exit(this, "setFollowedBy", null);
    }
    
    public boolean isFollowedBy() {
        Logger.enter(this, "isFollowedBy", new ArrayList<>());
        boolean ret = false;
        if(followedBy!=null) ret = true;
        Logger.exit(this, "isFollowedBy", ret);
    	return ret;
    }  

    
    public void releaseFollowerRecursively() {
        Logger.enter(this, "releaseFollowerRecursively", new ArrayList<>());

        Logger.exit(this, "releaseFollowerRecursively", null);
    }
    
    public boolean getCoughtBy(Panda p) {
    	return false;
    }
    
    public boolean getCoughtBy(Orangutan o) {
    	//MIKLOS
    }
}
