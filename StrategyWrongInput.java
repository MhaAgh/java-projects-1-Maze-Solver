package mazeslover;

import java.util.Scanner;

public class StrategyWrongInput implements Strategy {

    public int cheackInput(int num, Scanner input) {
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("\nWRONG INPUT!!!  Please enter a number. \n:");
        }
        return num;
    }
}
