package mazeslover;

import static mazeslover.MazeSolver.*;

public class StateNew extends State {

    public StateNew(StateContext s) {
        state = s;
    }

    public void nextState() {

        if (!(maze.isThereStart())) {
            state.setState(state.getStartState());
        } else if (!(maze.isThereFinish())) {
            state.setState(state.getFinishState());
        } else {
            System.out.println("do you want to continue follwing the states (1) or go back to the menue(2) ");
            wrongInType.cheackInput(0, input);
            int user = input.nextInt();
            while (user < 1 || user > 2) {
                System.out.print("\nWRONG CHOICE!!!!!!   \nplease enter a number between (1-2).\n:");
                wrongInType.cheackInput(user, input); //wronginput
                user = input.nextInt();
            }
            if (user == 1) {
                System.out.println("If you want to:\nadd specific obstical press(1) || generate randomly obsticals press(2) || remove an obstical press(3) || calclate path press(4) ");
                wrongInType.cheackInput(0, input);
                int answer = input.nextInt();
                answer = wrongIn4Oper.cheackInput(answer, input);
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
                        state.setState(state.getRemoveObState());
                        state.nextState();
                        break;
                    case 4:
                        state.setState(state.getCalculatePathState());
                        state.nextState();
                        break;
                    default:
                        break;
                }
            } else if (user == 1) {

                System.out.println("If you want to:\nadd specific obstical press(1) || generate randomly obsticals press(2) || remove an obstical press(3) || calclate path press(4) ");
                wrongInType.cheackInput(0, input);
                int answer = input.nextInt();
                answer = wrongIn4Oper.cheackInput(answer, input);
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
                        state.setState(state.getRemoveObState());
                        state.nextState();
                        break;
                    case 4:
                        state.setState(state.getCalculatePathState());
                        state.nextState();
                        break;
                    default:
                        break;
                }
            }
        }

    }

}
