package mazeslover;

public class StateContext {
State init;
    State newState;
    State startState;
    State finishState;
    State randomObState;
    State addObState;
    State removeObState;
    State calcuPathState;
    State state;

    public StateContext() {
        init = new StateInit(this);
        newState = new StateNew(this);
        startState = new StateStart(this);
        finishState = new StateFinish(this);
        randomObState = new StateRandomOb(this);
        removeObState = new StateRemoveOb(this);
        addObState = new StateAddOb(this);
        calcuPathState = new StateCalculatePath(this);
        state = init;
    }

        public void setMaze(Maze maze) {
        init.setMaze(maze);
        newState.setMaze(maze);
        startState.setMaze(maze);
        finishState.setMaze(maze);
        randomObState.setMaze(maze);
        removeObState.setMaze(maze);
        addObState.setMaze(maze);
        calcuPathState.setMaze(maze);
        
    }
    public void nextState() {
        state.nextState();
    }

    public void setState(State s) {
        state = s;

    }

    public State getState() {
        return state;
    }

    public State getCurrentState() {
        return state;
    }
    
    public State getInit() {
        return init;
    }

    public State getNewState() {
        return newState;
    }

    public State getStartState() {
        return startState;
    }

    public State getFinishState() {
        return finishState;
    }

    public State getRandomObState() {
        return randomObState;
    }

    public State getRemoveObState() {
        return removeObState;
    }

    public State getAddObState() {
        return addObState;
    }

    public State getCalculatePathState() {
        return calcuPathState;
    }

}
