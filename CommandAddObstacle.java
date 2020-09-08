package mazeslover;

public class CommandAddObstacle extends Command {

    @Override
    public void execute(int x, int y) {
        rece.setObstacle(x, y);
    }
    public void execute() {
    }
}
