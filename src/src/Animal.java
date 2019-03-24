public abstract class Animal implements Steppable{
    private String name; //ezmi
    protected boolean isFollowedBy;
    protected boolean isFollowing;
    protected Tile tile;
    protected Tile nextTile=null;
    protected Panda followedBy=null;
    
    //KONSTRUKTOROK
    public Animal(Tile t, String n) {
    	tile=t;
    	name=n;
    }
    
    public Animal() {
    	tile=null;
    	name="";
    }
        
    //METODUSOK
    public void setName(String name){
        this.name = name;
    }
    
    public void die(){

    }
    
    public void setFollowedBy(Panda p) {
    	
    }
    
    public boolean isFollowedBy() {
    	return isFollowedBy;
    }
    
    public boolean isFollowing() {
    	return isFollowing;
    }
    
    public void releaseFollowerRecursively() {
    	
    }
}
