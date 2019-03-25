/**
 * A szkeleton program (use-case-eket tartalmazó) menüjét kezelő osztály.
 */
public class Menu {
    public void show(){
        System.out.println("Az alábbi use-case-ekből választhat:\n\n"
                +"1. Orangutan steps on Tile\n"
                +"2. Orangutan steps on WeakTile\n"
                +"3. Orangutan steps on BrokenTile\n"
                +"4. Orangutan cannot enter Tile\n"
                +"5. Orangutan catches its first panda\n"
                +"6. Orangutan catches panda, while it already has panda(s)\n"
                +"7. Orangutan enters wardrobe\n"
                +"8. Orangutan won\n"
                +"9. Orangutan takes the exit with panda(s)\n"
                +"10. TiredPanda enters fotel\n"
                +"11. AfraidPanda gets frightened\n"
                +"12. DiabeticPanda gets frightened\n"
                +"13. Panda enters wardrobe\n"
                +"14. Panda steps\n"
                +"15. Panda in row steps on BrokenTile\n"
                +"16. Panda in freeroam steps on BrokenTile\n"
                +"---\n"
                +"0. Kilépés\n"
                +"A választott UseCase: ");
    }

    public void manageUseCase(int chosenUseCase){
        switch(chosenUseCase) {            //A valasznak megfelelo eset inditasa
            case 1: orangutanStepsOnTile();
                break;
            case 2: orangutanStepsOnWeakTile();
                break;
            case 3: orangutanStepsOnBrokenTile();
                break;
            case 4: orangutanCannotEnterTile();
                break;
            case 5: orangutanCatchesItsFirstPanda();
                break;
            case 6: orangutanCatches();
                break;
            case 7: orangutanEntersWardrobe();
                break;
            case 8: orangutanWon();
                break;
            case 9: orangutanTakesTheExit();
                break;
            case 10: tiredPandaEntersFotel();
                break;
            case 11: afraidPandaGetsFrightened();
                break;
            case 12: diabeticPandaGetsFrightened();
                break;
            case 13: pandaEntersWardrobe();
                break;
            case 14: pandaSteps();
                break;
            case 15: pandaInRowStepsOnBrokenTile();
                break;
            case 16: pandaInFreeroamStepsOnBrokenTile();
                break;
            default: System.out.println("Érvénytelen számot adott meg!");
                break;
        }
    }
    //1.
    public void orangutanStepsOnTile(){

        //letrehozzuk a szukseges objektumokat
        //Letrehozzuk a szukseges objektumokat.
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        o.setTile(t1);
        t1.setAnimal(o);
        o.step(t2);

        //Loggerbe regisztralas
        Logger.enable();;
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");

    }
    //2.
    public void orangutanStepsOnWeakTile(){
        //letrehozzuk a szukseges objektumokat
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        WeakTile t2 = new WeakTile();
        t1.setAnimal(o);
        o.setTile(t1);
        
        o.step(t2);
        

        //Loggerbe regisztralas
        Logger.enable();;
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "WeakTile", "t2");

    }
    //3.
    public void orangutanStepsOnBrokenTile(){
        //letrehozzuk a szukseges objektumokat
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        WeakTile t2 = new WeakTile();
        
        t1.setAnimal(o);
        o.setTile(t1);
        while(!t2.isBroken())
        	t2.reduceNumOfSteps();
        o.step(t2);

        //Loggerbe regisztralas
        Logger.enable();;
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "WeakTile", "t2");
        
        o.step(t2);
    }
    //4.
    public void orangutanCannotEnterTile(){
        //letrehozzuk a szukseges objektumokat
        Orangutan o = new Orangutan();
        Arcade a = new Arcade(); 
        Tile t1=new Tile();
        t1.setAnimal(o);
        o.setTile(t1);
        Tile t2 = new Tile();
        t2.setEntity(a);
        o.step(t2);
        
        

        //Loggerbe regisztralas
        Logger.enable();
        
        Logger.register(o, "Orangutan", "o");
        Logger.register(a, "Entity", "a");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
    }
    //5.
    public void orangutanCatchesItsFirstPanda(){
        //letrehozzuk a szukseges objektumokat
    	GameMap gm = GameMap.instance();
        Orangutan o = new Orangutan();
        AfraidPanda p = new AfraidPanda(gm);        
        
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        t1.setAnimal(o);
        o.setTile(t1);
        t2.setAnimal(p);
        p.setTile(t2);
        
        o.step(t2);
        
        
        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(p, "AfraidPanda", "p");
    }
    //6.
    public void orangutanCatches(){
    	Orangutan o=new Orangutan();
    	Tile t1=new Tile();
    	Tile t2=new Tile();
    	Tile t3=new Tile();
    	GameMap gm = GameMap.instance();
    	DiabeticPanda p1=new DiabeticPanda(gm);
    	AfraidPanda p2=new AfraidPanda(gm);
    	t1.setAnimal(o);
    	o.setTile(t1);
    	t2.setAnimal(p1);
    	p1.setTile(t2);
    	t3.setAnimal(p2);
    	p2.setTile(t3);
    	
    	o.step(t2);
    	o.step(t3);
    	
    	Logger.enable();
        Logger.register(gm, "GameMap", "gm");
    	Logger.register(o, "Orangutan", "o");
    	Logger.register(p1, "DiabeticPanda", "p1");
    	Logger.register(p2, "AfraidPanda", "p2");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(t3, "Tile", "t3");
    }
    //7.
    public void orangutanEntersWardrobe(){
    	GameMap gm = GameMap.instance();
        Orangutan o = new Orangutan();
        Tile entrance = new Tile();
        Tile t1=new Tile();
        Tile t2=new Tile();
        Tile exit=new Tile();
        
        t1.setAnimal(o);
        o.setTile(t1);
        Wardrobe w=new Wardrobe(entrance,gm);
        t2.setEntity(w);
        w.setTile(t2);
        gm.addSpecificTile(exit, GameMap.Key.WardrobeExit);
        o.step(t2);
        
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
    	Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(exit, "Tile", "exit");
        Logger.register(w, "Wardrobe", "w");
        Logger.register(entrance, "Tile", "entrance");
        Tile wt = new Tile(); //WardrobeTile
        Wardrobe w1 = new Wardrobe(wt,gm);
        
        Logger.register(o, "Orangutan", "o");
        Logger.register(gm, "GameMap", "gm");
        Logger.register(wt, "Tile", "wt");
        Logger.register(w1, "Wardrobe", "w1");
        
        
    }
    //8.
    public void orangutanWon(){
        //Init
        Game g = new Game();
        GameMap gamemap = GameMap.instance();

        //$FinitTime mode
        System.out.println("FinitTime mode:");
        //Init
        g.setSelectedMode(Game.GameMode.FinitTime);
        Timer t = Timer.instance(); t.setGamemap(gamemap); t.setGame(g);
        //Time is over, megnézzük ki nyert, és mennyivel.TODO: Loggerkedés
        t.increaseTime(60);

        //$FinitPanda mode
        System.out.println("\nFinitPanda mode:");
        //Init
        g.setSelectedMode(Game.GameMode.FinitPanda);
        Orangutan o = new Orangutan();
        o.setGame(g);
        //Az egyik orangutannal meglepjuk FinitPanda mode-ban a gyozelemhez szukseges limitet TODO: Loggerkedés
        o.increaseScore(25);
    }
    //9.
    public void orangutanTakesTheExit(){

    }
    //10.
    public void tiredPandaEntersFotel(){

    }
    //11.
    public void afraidPandaGetsFrightened(){

    }
    //12.
    public void diabeticPandaGetsFrightened(){

    }
    //13.
    public void pandaEntersWardrobe(){
    	GameMap gm = GameMap.instance();
        DiabeticPanda p = new DiabeticPanda(gm);
        Tile entrance = new Tile();
        Tile t1=new Tile();
        Tile t2=new Tile();
        Tile exit=new Tile();
        
        t1.setAnimal(p);
        p.setTile(t1);
        Wardrobe w=new Wardrobe(entrance,gm);
        t2.setEntity(w);
        w.setTile(t2);
        gm.addSpecificTile(exit, GameMap.Key.WardrobeExit);
        p.step(t2);
        
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
    	Logger.register(p, "Orangutan", "p");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(exit, "Tile", "exit");
        Logger.register(w, "Wardrobe", "w");
        Logger.register(entrance, "Tile", "entrance");
        Orangutan o = new Orangutan();
        Tile wt = new Tile(); //WardrobeTile
        Wardrobe w1 = new Wardrobe(wt,gm);
        
        Logger.register(o, "Orangutan", "o");
        Logger.register(gm, "GameMap", "gm");
        Logger.register(wt, "Tile", "wt");
        Logger.register(w1, "Wardrobe", "w1");
    }
    //14.
    public void pandaSteps(){
        //Letrehozzuk a szukseges objektumokat
        GameMap gm = GameMap.instance();
        AfraidPanda p = new AfraidPanda(gm);
        Tile oldt = new Tile(); //Itt all most
        Tile newt = new Tile(); //Ide lep
        Tile nt = new Tile();
        Tile newnt = new Tile();

        //Inicializálás
        p.setTile(oldt);
        oldt.getNeighbors().add(nt);
        newt.getNeighbors().add(newnt);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
        Logger.register(p, "AfraidPanda", "p");
        Logger.register(oldt, "Tile", "oldt");
        Logger.register(newt, "Tile", "newt");
        Logger.register(nt, "Tile", "nt");
        Logger.register(newnt, "Tile", "newnt");

        //Metodus meghivasa
        p.step(newt);

    }
    //15.
    public void pandaInRowStepsOnBrokenTile(){

    }
    //16.
    public void pandaInFreeroamStepsOnBrokenTile(){

    }
}
