import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu mainMenu = new Menu();
        Scanner scanner = new Scanner(System.in);
        int chosenUseCase = 0;

        System.out.println("Udv a tesztprogramunkban! Kilepes '15'-tel\n");

        do {
            mainMenu.show();
            chosenUseCase = Integer.parseInt(scanner.nextLine());
        } while (chosenUseCase != 0);
        scanner.close();
        System.out.println("Viszlat!");
        /**
         * Minden osztálynak van egy String name változója, melyben a saját nevét tárolja.
         */
    }
}