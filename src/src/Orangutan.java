import java.util.ArrayList;

public class Orangutan extends Animal {
    private int Score = 0;
    Tile tile;

    @Override
    public void Step(Tile t) {
         //paramétert hozzáadjuk a paramtéterlistához
        ArrayList<Object> par = new ArrayList<>();
        par.add(t);

        Logger.enter(this, "Step", par);
        tile.releaseAnimal();
        t.receiveAnimal(this);



    }
}
