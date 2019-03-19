import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu mainMenu = new Menu();
        Scanner scanner = new Scanner(System.in);
        int chosenUseCase = 0;

        System.out.println("Üdv a tesztprogramunkban! Kilépés '15'-tel\n");

        while (chosenUseCase != 15) {
            mainMenu.show();
            chosenUseCase = Integer.parseInt(scanner.nextLine());
            System.out.println(chosenUseCase);
        }
        System.out.println("Viszlát!");
        /**
         * Minden osztálynak van egy String name változója, melyben a saját nevét tárolja.
         */
    }
}