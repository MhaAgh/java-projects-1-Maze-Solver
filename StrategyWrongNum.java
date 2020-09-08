package mazeslover;

import java.util.Scanner;

public class StrategyWrongNum implements Strategy {

    StrategyWrongInput w = new StrategyWrongInput();
    int n;

    public int cheackInput(int num, Scanner input) {

        while (num > 9 || num < 0) {
            System.out.print("\nWRONG CHOICE!!!!!!   \nplease enter a number between (0-9).\n:");
            w.cheackInput(num, input); //wronginput
            num = input.nextInt();

        }

        return num;
    }
}
