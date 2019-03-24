public class DiabeticPanda extends Panda {
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
			if(map.getAutomatTiles().Contains(newTileNeighbor)) {
				addSubbedTile(newTileNeighbor);
				newTileNeighbor.addSubbedPanda(this);
			}
		}
	}
    
    public void affectedBy(Automat a) {
    	
    }
}
