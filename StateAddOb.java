package mazeslover;

public class StateAddOb extends State {

    public StateAddOb(StateContext s) {
        state = s;
    }

    public void nextState() {

        System.out.println("##################################################### \n");
        System.out.println("You're now in the Add specific obstical state \n");

        System.out.println("#Add Obstacle# \n");
        inv.UserChoice(6); // print maze

        System.out.println("Pleaes enter the position:");
        System.out.print("X (Column):");
        wrongInType.cheackInput(0, input); // strategy for check
        int x = input.nextInt();
        x = wrongInNum.cheackInput(x, input); // strategy to check the range

        System.out.print("Y (row): ");
        wrongInType.cheackInput(0, input);
        int y = input.nextInt();
        y = wrongInNum.cheackInput(y, input);

        inv.UserChoice(2, x + 1, y + 1); // AddObstacle()

        state.setState(state.getNewState());
        state.nextState();

    }
}
