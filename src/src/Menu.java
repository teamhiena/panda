/**
 * A szkeleton program (use-case-eket tartalmaz) menujet kezelo osztalyly.
 */
public class Menu {
    public void show(){
        System.out.println("Az alabbi useCase-ekbol valaszthat:\n\n"
                +"1. Orangutan steps on Tile\n"
                +"2. Orangutan steps on WeakTile\n"
                +"3. Orangutan steps on BrokenTile\n"
                +"4. Orangutan cannot enter Tile\n"
                +"5. Orangutan catches its first panda\n"
                +"6. Orangutan catches panda, while it already has panda(s)\n"
                +"7. Orangutan enters wardrobe\n"
                +"8. Orangutan won(FinitTime mode)\n"
                +"9. Orangutan won(FinitPanda mode)\n"
                +"10. Orangutan takes the exit with panda(s)\n"
                +"11. TiredPanda enters fotel\n"
                +"12. AfraidPanda gets frightened\n"
                +"13. DiabeticPanda gets frightened\n"
                +"14. Panda enters wardrobe\n"
                +"15. Panda steps\n"
                +"16. Panda in row steps on BrokenTile\n"
                +"17. Panda in freeroam steps on BrokenTile\n"
                +"---\n"
                +"0. Kilepes\n"
                +"A valasztott UseCase: ");
    }

    public void manageUseCase(int chosenUseCase){
    	Logger.disable();
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
            case 8: orangutanWon_FinitTime();
                break;
            case 9: orangutanWon_FinitPanda();
                break;
            case 10: orangutanTakesTheExit();
                break;
            case 11: tiredPandaEntersFotel();
                break;
            case 12: afraidPandaGetsFrightened();
                break;
            case 13: diabeticPandaGetsFrightened();
                break;
            case 14: pandaEntersWardrobe();
                break;
            case 15: pandaSteps();
                break;
            case 16: pandaInRowStepsOnBrokenTile();
                break;
            case 17: pandaInFreeroamStepsOnBrokenTile();
                break;
            default: System.out.println("Ervenytelen szamot adott meg!");
                break;
        }
    }
    //1.
    public void orangutanStepsOnTile(){
        //Letrehozzuk a szukseges objektumokat.
        Orangutan o = new Orangutan();
        Tile t1 = new Tile(); //Itt van most az orangutan.
        Tile t2 = new Tile(); //Ide akarjuk leptetni.

        //Inicializalas
        o.setTile(t1);
        t1.setAnimal(o);

        //Loggerbe regisztralas
        Logger.enable();;
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");

        //Metodus meghivasa
        o.step(t2);
    }
    //2.
    public void orangutanStepsOnWeakTile(){
        //letrehozzuk a szukseges objektumokat
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        WeakTile t2 = new WeakTile();

        //Inicializalas
        t1.setAnimal(o);
        o.setTile(t1);

        //Loggerbe regisztralas
        Logger.enable();;
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "WeakTile", "t2");

        //Metodus meghivasa
        o.step(t2);

    }
    //3.
    public void orangutanStepsOnBrokenTile(){
        //Letrehozzuk a szukseges objektumokat
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        WeakTile t2 = new WeakTile();

        //Inicializalas
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

        //Metodus meghivasa
        o.step(t2);
    }
    //4.
    public void orangutanCannotEnterTile(){
        //Letrehozzuk a szukseges objektumokat
        Orangutan o = new Orangutan();
        Arcade a = new Arcade(); 
        Tile t1=new Tile();
        Tile t2 = new Tile();

        //Inicializalas
        t1.setAnimal(o);
        o.setTile(t1);
        t2.setEntity(a);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(o, "Orangutan", "o");
        Logger.register(a, "Entity", "a");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");

        //Metodus meghivasa
        o.step(t2);
    }
    //5.
    public void orangutanCatchesItsFirstPanda(){
        //Letrehozzuk a szukseges objektumokat
    	GameMap gm = GameMap.instance();
        Orangutan o = new Orangutan();
        AfraidPanda p = new AfraidPanda(gm);
        Tile t1 = new Tile();
        Tile t2 = new Tile();

        //Inicializalas
        t1.setAnimal(o);
        o.setTile(t1);
        t2.setAnimal(p);
        p.setTile(t2);
        
        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(p, "AfraidPanda", "p");

        //Metodus meghivasa
        o.step(t2);
    }
    //6.
    public void orangutanCatches(){
        //Letrehozzuk a szukseges objektumokat
    	Orangutan o=new Orangutan();
    	Tile t1=new Tile();
    	Tile t2=new Tile();
    	Tile t3=new Tile();
    	GameMap gm = GameMap.instance();
    	DiabeticPanda p1=new DiabeticPanda(gm);
    	AfraidPanda p2=new AfraidPanda(gm);

    	//Inicializalas
    	t1.setAnimal(o);
    	o.setTile(t1);
    	t2.setAnimal(p1);
    	p1.setTile(t2);
    	t3.setAnimal(p2);
    	p2.setTile(t3);

    	//Loggerbe regisztralas
    	Logger.enable();
        Logger.register(gm, "GameMap", "gm");
    	Logger.register(o, "Orangutan", "o");
    	Logger.register(p1, "DiabeticPanda", "p1");
    	Logger.register(p2, "AfraidPanda", "p2");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(t3, "Tile", "t3");

        //Metodus(ok) meghivasa
        o.step(t2);
        o.step(t3);
    }
    //7.
    public void orangutanEntersWardrobe(){
        //Letrehozzuk a szukseges objektumokat
    	GameMap gm = GameMap.instance();
        Orangutan o = new Orangutan();
        Tile entrance = new Tile();
        Tile t2=new Tile(); //WardrobeTile
        Tile exit=new Tile();
        Wardrobe w=new Wardrobe(entrance,gm);

        //Inicializalas
        entrance.setAnimal(o);
        o.setTile(entrance);
        t2.setEntity(w);
        w.setTile(t2);
        gm.addSpecificTile(exit, GameMap.Key.WardrobeExit);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
    	Logger.register(o, "Orangutan", "o");
        Logger.register(entrance, "Tile", "entrance");
        Logger.register(t2, "Tile", "t2");
        Logger.register(exit, "Tile", "exit");
        Logger.register(w, "Wardrobe", "w");
        Logger.register(entrance, "Tile", "entrance");

        //Metodus meghivasa
        o.step(t2);
    }
    //8.
    //TODO
    public void orangutanWon_FinitTime(){
        //Letrehozzuk a szukseges objektumokat
        Game g = new Game();
        GameMap gameMap = GameMap.instance();

        //Inicializalas
        g.setSelectedMode(Game.GameMode.FinitTime);
        Timer t = Timer.instance();
        t.setGamemap(gameMap);
        t.setGame(g);
        //Time is over, megnezzuk ki nyert, es mennyivel.
        t.increaseTime(60);

        //Init
        g.setSelectedMode(Game.GameMode.FinitPanda);
        Orangutan o = new Orangutan();
        o.setGame(g);
        
        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(g, "Game", "g");
        Logger.register(gameMap, "GameMap", "gameMap");
        Logger.register(o, "Orangutan", "o");
        
        //Az egyik orangutannal meglepjuk FinitPanda mode-ban a gyozelemhez szukseges limitet TODO: Loggerkedes
        o.increaseScore(25);
    }
    //9.
    //TODO
    public void orangutanWon_FinitPanda(){
        //Letrehozzuk a szukseges objektumokat
        Game g = new Game();
        GameMap gamemap = GameMap.instance();

        //Inicializalas
        g.setSelectedMode(Game.GameMode.FinitPanda);
        Timer t = Timer.instance();
        t.setGamemap(gamemap);
        t.setGame(g);


        
        //loggerbe TODO
    }
    //10.
    //TODO: folyamatban van
    public void orangutanTakesTheExit(){
        Game g = new Game();
        GameMap gm = GameMap.instance();
        g.setSelectedMode(Game.GameMode.FinitTime); // ez persze lehet FinitPanda mod is
        Timer t = Timer.instance();
        t.setGamemap(gm);
        t.setGame(g);

        Orangutan o = new Orangutan();
        Tile exitTile = new ExitTile();
        exitTile.setAnimal(o);
        o.setTile(exitTile);

        AfraidPanda p1 = new AfraidPanda(gm);
        DiabeticPanda p2 = new DiabeticPanda(gm);
        TiredPanda p3 = new TiredPanda(gm);

        boolean p1Caught = false;
        boolean p2Caught = false;
        boolean p3Caught = false;

        while(p1Caught == false)
            p1Caught = p1.getCaughtBy(o);
        while(p2Caught == false)
            p2Caught = p2.getCaughtBy(o);
        while(p3Caught == false)
            p3Caught = p3.getCaughtBy(o);


    }
    //11.
    public void tiredPandaEntersFotel(){
    	//Letrehozzuk a szukseges objektumokat
    	GameMap gm=GameMap.instance();
    	TiredPanda ap=new TiredPanda(gm);
    	Tile t1=new Tile();
    	Fotel f=new Fotel();
    	Tile t2=new Tile();
    	TiredPanda bp=new TiredPanda(gm);
    	Tile t3=new Tile();
    	
    	//Inicializalas
    	t1.addNeighbor(t2);
    	t2.addNeighbor(t1);
    	t1.addNeighbor(t3);
    	t3.addNeighbor(t1);
    	t1.setEntity(f);
    	f.setTile(t1);    	
    	t2.setAnimal(ap);
    	ap.setTile(t2);
    	t3.setAnimal(bp);
    	bp.setTile(t3);
    	t1.addSubbedPanda(ap);
    	t1.addSubbedPanda(bp);
    	ap.addSubbedTile(t1);
    	bp.addSubbedTile(t1);
    	
    	//Logger
    	Logger.enable();
    	Logger.register(t1, "Tile", "t1");
    	Logger.register(t2, "Tile", "t2");
    	Logger.register(t3, "Tile", "t3");
    	Logger.register(f, "Fotel", "f");
    	Logger.register(ap, "TiredPanda", "ap");
    	Logger.register(bp, "TiredPanda", "bp");
    	Logger.register(gm, "GameMap", "gm");
    	
    	//Metodus meghivasa
    	f.makeEffect();    	
    }
    //12.
    public void afraidPandaGetsFrightened(){
		//Letrehozzuk a szukseges objektumokat
    	GameMap gm=GameMap.instance();
    	AfraidPanda ap=new AfraidPanda(gm);
    	Tile t1=new Tile();
    	Arcade a=new Arcade();
    	Tile t2=new Tile();
    	
    	//Inicializalas
    	t1.addNeighbor(t2);
    	t2.addNeighbor(t1);    	
    	t1.setEntity(a);
    	a.setTile(t1);    	
    	t2.setAnimal(ap);
    	ap.setTile(t2);
    	t1.addSubbedPanda(ap);
    	ap.addSubbedTile(t1);
    	
    	//Logger
    	Logger.enable();
    	Logger.register(t1, "Tile", "t1");
    	Logger.register(t2, "Tile", "t2");
    	Logger.register(a, "Arcade", "a");
    	Logger.register(ap, "AfraidPanda", "ap");
    	Logger.register(gm, "GameMap", "gm");
    	
    	//Metodus meghivasa
    	a.makeEffect();    	
    }
    //13.
    public void diabeticPandaGetsFrightened(){
    	//Letrehozzuk a szukseges objektumokat
    	GameMap gm=GameMap.instance();
    	DiabeticPanda dp=new DiabeticPanda(gm);
    	Tile t1=new Tile();
    	Automat a=new Automat();
    	Tile t2=new Tile();
    	
    	//Inicializalas
    	t1.addNeighbor(t2);
    	t2.addNeighbor(t1);    	
    	t1.setEntity(a);
    	a.setTile(t1);    	
    	t2.setAnimal(dp);
    	dp.setTile(t2);
    	t1.addSubbedPanda(dp);
    	dp.addSubbedTile(t1);
    	
    	//Loggerbe rergisztralas
    	Logger.enable();
    	Logger.register(t1, "Tile", "t1");
    	Logger.register(t2, "Tile", "t2");
    	Logger.register(a, "Automat", "a");
    	Logger.register(dp, "AfraidPanda", "ap");
    	Logger.register(gm, "GameMap", "gm");
    	
    	//Metodus meghivasa
    	a.makeEffect();    	
    }
    //14.
    public void pandaEntersWardrobe(){
        //Letrehozzuk a szukseges objektumokat
    	GameMap gm = GameMap.instance();
        DiabeticPanda p = new DiabeticPanda(gm);
        Tile entrance = new Tile();
        Tile t1=new Tile();
        Tile t2=new Tile(); //WardrobeTile
        Tile exit=new Tile();

        //Inicializalas
        t1.setAnimal(p);
        p.setTile(t1);
        Wardrobe w=new Wardrobe(entrance,gm);
        t2.setEntity(w);
        w.setTile(t2);
        gm.addSpecificTile(exit, GameMap.Key.WardrobeExit);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
    	Logger.register(p, "Orangutan", "p");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "Tile", "t2");
        Logger.register(exit, "Tile", "exit");
        Logger.register(w, "Wardrobe", "w");
        Logger.register(entrance, "Tile", "entrance");

        //Metodus meghivasa
        p.step(t2);
    }
    //15.
    public void pandaSteps(){
        //Letrehozzuk a szukseges objektumokat
        GameMap gm = GameMap.instance();
        AfraidPanda p = new AfraidPanda(gm);
        Tile oldt = new Tile(); //Itt all most
        Tile newt = new Tile(); //Ide lep
        Tile nt = new Tile();
        Tile newnt = new Tile();

        //Inicializalas
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
    //16.
    public void pandaInRowStepsOnBrokenTile(){

    }
    //17.
    public void pandaInFreeroamStepsOnBrokenTile(){
        //Letrehozzuk a szukeseges objektumokat
        GameMap gm = GameMap.instance();
        AfraidPanda p = new AfraidPanda(gm);
        Tile t1 = new Tile();
        WeakTile t2 = new WeakTile();

        //Inicializalas
        /*for(int i = 30; i >= 0; i--)
            t2.reduceNumOfSteps();*/        

        while(!t2.isBroken())
        	t2.reduceNumOfSteps();
        
        t1.setAnimal(p);
        p.setTile(t1);

        //Loggerbe regisztralas
        Logger.enable();
        Logger.register(gm, "GameMap", "gm");
        Logger.register(p, "AfraidPanda", "p");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "WeakTile", "t2");

        //Metodus meghivasa
        p.step(t2);
    }
}
