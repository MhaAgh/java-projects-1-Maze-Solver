package mazeslover;

import java.util.ArrayList;

public class CommandInvoker {

    private CommandInvoker() {
    }

    private static CommandInvoker instance = new CommandInvoker();

    public static CommandInvoker getInstance() {
        return instance;
    }

    private Command command;
    private ArrayList<Command> commList = new ArrayList<Command>();

    public void setCommand(Command comm) {

        this.command = comm;
        commList.add(command);

    }

    public void UserChoice(int i) {
        commList.get(i).execute();

    }

    public void UserChoice(int i, int x, int y) {
        commList.get(i).execute(x, y);

    }

}
