package mazeslover;

public class CommandSelectFinish extends Command {


    @Override
    public void execute(int x, int y) {
        rece.setFinish(x, y);
    }

    public void execute() {
    }

}
