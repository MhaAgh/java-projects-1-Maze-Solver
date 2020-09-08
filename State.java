package mazeslover;

import java.util.Scanner;

public abstract class State {

    StateContext state;
    Strategy wrongInType = new StrategyWrongInput();
    Strategy wrongInNum = new StrategyWrongNum();
    Strategy wrongIn4Oper = new StrategyWrongNum4Oper();
    Scanner input = new Scanner(System.in);
    int xstart = 0;
    int ystart = 0;
    int xfinish = 0;
    int yfinish = 0;
    CommandInvoker inv = CommandInvoker.getInstance(); // get the commands
    CommandReceiver rec = CommandReceiver.getInstance(); // to sand the maze to the receiver

    Maze maze;


    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public abstract void nextState();

}
