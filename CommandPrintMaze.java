package mazeslover;

public class CommandPrintMaze extends Command {
    public void execute() {
        rece.printMaze();

    }

    @Override
    public void execute(int x, int y) {
    }

}
