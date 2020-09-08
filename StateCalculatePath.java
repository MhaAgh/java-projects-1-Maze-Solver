package mazeslover;

public class StateCalculatePath extends State {

    public StateCalculatePath(StateContext s) {
        state = s;
    }

    public void nextState() {
        System.out.println("##################################################### \n");
        System.out.println("You're now in the calculating path state \n");

        System.out.println("#Calculate shortest Path# \n");
        if (!(maze.isThereFinish())) {
            System.out.println("You need to choose a start point \n");
        } else if (!(maze.isThereFinish())) {
            System.out.println("You need to choose a finish point \n");
        } else if (maze.checkPosition(xstart + 1, ystart + 1) && maze.checkPosition(xfinish + 1, yfinish + 1)) {
            inv.UserChoice(5); // ShortestPath()


        }
        inv.UserChoice(6); //PrintMaze()
        state.setState(state.getNewState());
    }

}
