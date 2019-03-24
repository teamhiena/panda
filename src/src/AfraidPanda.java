public class AfraidPanda extends Panda {
  
    public void affectedBy(Arcade a) {
    	
    }
    
    @Override
	public void step(Tile newTile) {
		clearSubbedTiles();
		tile.refreshSubs(this);
		Entity newTileEntity=newTile.getEntity();
		
		if(newTileEntity==null) {
			tile.releaseAnimal();
			newTile.recieveAnimal(this);
		}
		else {
			newTileEntity.stepIn(this);
		}
		
		for(Tile newTileNeighbor:newTile.getNeighbors()) {
			if(map.getArcadeTiles().Contains(newTileNeighbor)) {
				addSubbedTile(newTileNeighbor);
				newTileNeighbor.addSubbedPanda(this);
			}
		}
	}
}
