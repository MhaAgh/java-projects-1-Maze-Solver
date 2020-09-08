package mazeslover;

import static mazeslover.MazeSolver.*;

public class StateFinish extends State {

    public StateFinish(StateContext s) {
        state = s;
    }

    public void nextState() {

        System.out.println("##################################################### \n");
        System.out.println("You're now in the Finish state \n");
        System.out.println("#Select Finish# \n");
        if (!(maze.isThereFinish())) {
            inv.UserChoice(6);
            System.out.println("Pleaes enter the position:");

            System.out.print("X (Column):");
            wrongInType.cheackInput(0, input);
            xfinish = input.nextInt();
            xfinish = wrongInNum.cheackInput(xfinish, input);

            System.out.print("Y (row): ");
            wrongInType.cheackInput(0, input);
            yfinish = input.nextInt();
            yfinish = wrongInNum.cheackInput(yfinish, input);

            inv.UserChoice(1, xfinish + 1, yfinish + 1); // SelectFinish()

        } else {
            inv.UserChoice(6);
            System.out.println("You already select the Finish position.");
        }

        System.out.println("do you want to continue follwing the states (1) or go back to the menue(2) ");
        wrongInType.cheackInput(0, input);
        int user = input.nextInt();
        while (user < 1 || user > 2) {
            System.out.print("\nWRONG CHOICE!!!!!!   \nplease enter a number between (1-2).\n:");
            wrongInType.cheackInput(user, input); //wronginput
            user = input.nextInt();
        }
        if (user == 1) {
            System.out.println("if you want to: add specific obstical press(1) || generate randomly obsticals press (2) || calclate path press (3) ");
            wrongInType.cheackInput(0, input);
            int answer = input.nextInt();
            while (answer < 1 || answer > 3) {
                System.out.print("\nWRONG CHOICE!!!!!!   \nplease enter a number between (1-3).\n:");
                wrongInType.cheackInput(answer, input); //wronginput
                answer = input.nextInt();
            }

            switch (answer) {
                case 1:
                    state.setState(state.getAddObState());
                    state.nextState();
                    break;
                case 2:
                    state.setState(state.getRandomObState());
                    state.nextState();
                    break;
                case 3:
                    state.setState(state.getCalculatePathState());
                    state.nextState();
                    break;
                default:
                    break;
            }
        }
    }

}
