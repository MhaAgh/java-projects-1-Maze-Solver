package mazeslover;

import java.util.Scanner;

public class StrategyWrongNum4Oper implements Strategy {

    StrategyWrongInput w = new StrategyWrongInput();
    int n;

    public int cheackInput(int num, Scanner input) {

        while (num > 4 || num < 1) {
            System.out.print("\nWRONG CHOICE!!!!!!   \nplease enter a number between (1-4).\n:");
            w.cheackInput(num, input); //wronginput
            num = input.nextInt();

        }

        return num;
    }

}
