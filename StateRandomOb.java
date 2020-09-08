package mazeslover;

public class StateRandomOb extends State {

    public StateRandomOb(StateContext s) {
        state = s;
    }

    public void nextState() {

        System.out.println("##################################################### \n");
        System.out.println("you're now in generate random obsticals state");
        inv.UserChoice(4); // Generate10Obstacle()


        state.setState(state.getNewState());
        state.nextState();

    }

}
