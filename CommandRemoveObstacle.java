package mazeslover;

public class CommandRemoveObstacle extends Command {

    @Override
    public void execute(int x, int y) {
        rece.removeObstacle(x, y);
    }

    public void execute() {
    }

}
