package mazeslover;

public abstract class Command {

    CommandReceiver rece =CommandReceiver.getInstance();

    public abstract void execute(int x, int y);

    public abstract void execute();
}
