public class Orangutan extends Animal {
    private int score = 0;
    //private Tile tile; szerintem ez nem kell (G)
   

    @Override
    public void step(Tile t) {
    	
    }
    
    public void increaseScore(int p) {
    	score+=p;
    }
    
    public void catchPanda(Panda p) {
    	
    }
    
    public int getPandaNum() {
    	//return mindfuck recursive fuggveny
    }
    
    public void goToEntry() {
    	
    }
    
    public int getScore() {
    	return score;
    }
}
