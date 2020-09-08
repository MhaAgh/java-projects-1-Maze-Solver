package mazeslover;

import java.util.Scanner;

public class MazeSolver {

    static Maze maze = new Maze();
    static MementoOriginator originator = new MementoOriginator();

    public static void PrintOptionList() {
        if (maze.isTherePath()) {
            System.out.println("\n 2-Print maze" + "\n 3-Start new game" + "\n 4-Exit");
        } else {
            System.out.println("\n 1-Follow States" + "\n 2-Print maze" + "\n 3-Start new game" + "\n 4-Exit");
        }

    }

    public static void main(String[] args) {
        Strategy wrongInType = new StrategyWrongInput();
        Strategy wrongInNum = new StrategyWrongNum();
        Strategy wrongIn4Oper = new StrategyWrongNum4Oper();

        int xstart = 0;
        int ystart = 0;
        int xfinish = 0;
        int yfinish = 0;
        CommandInvoker inv = CommandInvoker.getInstance(); // to set the commands 
        CommandReceiver rec = CommandReceiver.getInstance(); // to sand the maze to the receiver

        StateContext context = new StateContext(); // init state
        originator.set(context.getState()); // restore state
        Memento memento = originator.saveToMemento();

        rec.setMaze(maze); // the reciver need the maze
        context.setMaze(maze);

        ////// fill the list by the commands //////////
        inv.setCommand(new CommandSelectStart()); // 0
        inv.setCommand(new CommandSelectFinish()); // 1
        inv.setCommand(new CommandAddObstacle()); // 2
        inv.setCommand(new CommandRemoveObstacle()); // 3
        inv.setCommand(new CommandGenerate10Obstacle()); // 4
        inv.setCommand(new CommandShortestPath()); //5
        inv.setCommand(new CommandPrintMaze()); //6

        System.out.println("Hello! Welcome to Maze Slover :)");
        System.out.println("");
        context.nextState();

        while (true) {
            System.out.println("\n#####################################################");
            System.out.println("Pleaes enter the number of opration you want to do!");
            PrintOptionList();
            Scanner input = new Scanner(System.in);
            System.out.print("\nOperation:");
            wrongInType.cheackInput(0, input); // strategy to check if the input is an integer
            int optionNum = input.nextInt();
            if (maze.isTherePath()) {
                while (optionNum > 4 || optionNum < 2) {
                    System.out.print("\nWRONG CHOICE!!!!!!   \nplease enter a number between (2-4).\n:");
                    wrongInType.cheackInput(optionNum, input); //wronginput
                    optionNum = input.nextInt();
                }
            } else {
                optionNum = wrongIn4Oper.cheackInput(optionNum, input); // strategy to check if the number in the range
            }
            System.out.println("#####################################################\n");
            switch (optionNum) {
                case 1: {
                    context.nextState();

                    break;

                }
                case 2:
                    System.out.println("#Print Maze# \n");
                    inv.UserChoice(6); //PrintMaze()
                    break;
                case 3:
                    context.setState(originator.restoreFromMemento(memento));
                    context.nextState();
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }

    }

}
