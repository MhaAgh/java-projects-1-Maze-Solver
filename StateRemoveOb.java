package mazeslover;

public class StateRemoveOb extends State {

    public StateRemoveOb(StateContext s) {
        state = s;
    }

    public void nextState() {

        System.out.println("##################################################### \n");
        System.out.println("You're now in the remove obsticals state \n");

        System.out.println("#Remove Obstacle# \n");
        inv.UserChoice(6);
        if (maze.isThereObstcale()) {

            System.out.println("Pleaes enter the position:");

            System.out.print("X (Column):");
            wrongInType.cheackInput(0, input);
            int x = input.nextInt();
            x = wrongInNum.cheackInput(x, input);

            System.out.print("Y (row): ");
            wrongInType.cheackInput(0, input);
            int y = input.nextInt();
            y = wrongInNum.cheackInput(y, input);

            inv.UserChoice(3, x + 1, y + 1); // RemoveObstacle()
  
        } else {
            System.out.println("There is no obstcale to remove.");
            state.setState(state.getRemoveObState());
            state.nextState();
        }

        state.setState(state.getNewState());
        state.nextState();
    }

}
