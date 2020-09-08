package mazeslover;

import static mazeslover.MazeSolver.*;

public class StateStart extends State {

    public StateStart(StateContext s) {
        state = s;
    }

    public void nextState() {

        System.out.println("You're now in the start state \n");
        System.out.println("#Select Start# \n");
        if (!(maze.isThereStart())) {
            inv.UserChoice(6);

            System.out.println("Pleaes enter the position:");

            System.out.print("X (Column):");
            wrongInType.cheackInput(0, input);
            xstart = input.nextInt();
            xstart = wrongInNum.cheackInput(xstart, input);

            System.out.print("Y (row): ");
            wrongInType.cheackInput(0, input);
            ystart = input.nextInt();
            ystart = wrongInNum.cheackInput(ystart, input);

            inv.UserChoice(0, xstart + 1, ystart + 1); // SelectStart()

        } else {
            inv.UserChoice(6);
            System.out.println("You already select the Start position.");
        }

        System.out.println("If you want to continue follwing the states press(1) or if you want to go back to the menue press(2) ");
        wrongInType.cheackInput(0, input);
        int user = input.nextInt();
        while (user < 1 || user > 2) {
            System.out.print("\nWRONG CHOICE!!!!!!   \nplease enter a number between (1-2).\n:");
            wrongInType.cheackInput(user, input); //wronginput
            user = input.nextInt();
        }
        if (user == 1) {
            state.setState(state.getFinishState());
            state.nextState();
        }
    }
}
