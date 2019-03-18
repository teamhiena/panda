import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        Scanner scanner = new Scanner(System.in);
        int chosenUseCase = 0;

        while (chosenUseCase != 15) {
            mainMenu.show();
            chosenUseCase = Integer.parseInt(scanner.nextLine());
            System.out.println(chosenUseCase);
        }
    }
}