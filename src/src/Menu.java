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
        switch(chosenUseCase) {            //A válasznak megfelelő eset indítása
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
        }
    }
    //1.
    public void orangutanStepsOnTile(){

    }
    //2.
    public void orangutanStepsOnWeakTile(){
        //létrehozzuk a szükséges objektumokat
        Orangutan o = new Orangutan();
        Tile t1 = new Tile();
        WeakTile t2 = new WeakTile();

        //Loggerbe regisztrálás
        Logger.enable();;
        Logger.register(o, "Orangutan", "o");
        Logger.register(t1, "Tile", "t1");
        Logger.register(t2, "WeakTile", "t2");

    }
    //3.
    public void orangutanStepsOnBrokenTile(){

    }
    //4.
    public void orangutanCannotEnterTile(){

    }
    //5.
    public void orangutanCatchesItsFirstPanda(){

    }
    //6.
    public void orangutanCatches(){

    }
    //7.
    public void orangutanEntersWardrobe(){

    }
    //8.
    public void orangutanWon(){

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

    }
    //14.
    public void pandaSteps(){

    }
    //15.
    public void pandaInRowStepsOnBrokenTile(){

    }
    //16.
    public void pandaInFreeroamStepsOnBrokenTile(){

    }
}
