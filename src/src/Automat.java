import java.util.ArrayList;

public class Automat extends NonEnterableEntity{
	@Override
	public void makeEffect() {
		Logger.enter(this, "makeEffect", new ArrayList<>());
		
		for(Panda sp: tile.getSubbedPandas())
			sp.affectedBy(this);		
		
		Logger.exit(this, "makeEffect", null);
	}	
}
