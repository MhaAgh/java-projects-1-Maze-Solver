package mazeslover;

import java.util.Random;

public class CommandReceiver {

    Maze maze; // maze 
   
    private CommandReceiver() {
    }

    private static CommandReceiver instance = new CommandReceiver();

    public static CommandReceiver getInstance() {
        return instance;
    }

    public void setMaze(Maze maze) { // don't forget to call it for every change in the maze
        this.maze = maze;
    }

    public Maze getMaze() {
        return maze;
    }

    StateContext context = new StateContext(); // state 

    int startx;
    int starty;


    public void setStart(int x, int y) {
        if (maze.cells[y][x] == '-') {//empty!
            maze.cells[y][x] = 'S';
            maze.solvingMaze[y][x] = 'S';
            maze.startX = x;
            startx = x;
            maze.startY = y;
            starty = y;
        } else {
            System.out.println();
            System.out.println("!!!!!!!!\nThe position in this cell is already taken.");
            context.setMaze(maze);
            context.setState(context.getStartState());
            context.nextState();
        }

        System.out.println("");
        printMaze();
    }

    public void setFinish(int x, int y) {
        if (maze.cells[y][x] == '-') {//empty!
            maze.cells[y][x] = 'F';
            maze.solvingMaze[y][x] = 'F';
        } else {
            System.out.println();
            System.out.println("!!!!!!!!\nThe position in this cell is already taken.");
            context.setMaze(maze);
            context.setState(context.getFinishState());
            context.nextState();
        }

        System.out.println("");
        printMaze();
    }

    public void setObstacle(int x, int y) {
        if (maze.cells[y][x] == '-') {//empty!
            maze.cells[y][x] = 'O';
        } else {
            System.out.println();
            System.out.println("!!!!!!!!\nThe position in this cell is already taken.");
            context.setMaze(maze);
            context.setState(context.getAddObState());
            context.nextState();
        }

        System.out.println("");
        printMaze();
    }

    public void removeObstacle(int x, int y) {
        if (maze.cells[y][x] == 'O') {
            maze.cells[y][x] = '-';
            // printMaze();
        } else {
            System.out.println("\n#This cell is not an Obstcale#");
        }

        System.out.println("");
        printMaze();

    }

    public void Randomly10Obstacles() {
        Random rand = new Random();
        int randomNumX;
        int randomNumY;
        int i = 0;
        while (i < 10) { //10 Obstacles

            randomNumX = (int) (rand.nextInt(Integer.MAX_VALUE) % 10);
            randomNumY = (int) (rand.nextInt(Integer.MAX_VALUE) % 10);
            if (maze.cells[randomNumX][randomNumY] == '-') { //empty!!
                maze.cells[randomNumX][randomNumY] = 'O';
                i++;
            }

        }

        System.out.println("");
        printMaze();
    }

    public void printMaze() {
        for (int x = 0; x < 11; x++) {
            if (x == 0) {
                System.out.print("#   ");
            } else {
                System.out.print(x - 1 + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < maze.cells.length - 1; i++) {

            for (int j = 0; j <= maze.cells.length; j++) {
                if (j == 0) {
                    if (!(i == 10)) {
                        System.out.print(i + " ");
                    }

                } else {
                    System.out.print(maze.cells[i + 1][j - 1] + " ");
                }
            }

            System.out.println();
        }

    }

    public void calculatePath() {
        int col = maze.startX;
        int row = maze.startY;

        myPath(row, col, 0);
        //copy maze.solvingMaze array into maze.cells array after solving it:
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                maze.cells[x][y] = maze.solvingMaze[x][y];
            }
        }
        maze.solvingMaze[row][col] = 'S';
        maze.cells[row][col] = 'S';
    }

    public int myPath(int x, int y, int counter) {

        // wrong way
        if (maze.cells[x][y] == 'O') {
            return maze.steps;
        } // wrong way
        else if (maze.cells[x][y] == ' ') {
            return maze.steps;
        } // wrong way
        else if (maze.cells[x][y] == '*') {
            return maze.steps;
        } // found the finish point
        else if (maze.cells[x][y] == 'F') {
            //copy maze.cells array into maze.solvingMaze array
            for (int xx = 0; xx < 11; xx++) {
                for (int yy = 0; yy < 11; yy++) {
                    maze.solvingMaze[xx][yy] = maze.cells[xx][yy];
                }
            }
            maze.path = counter;
            return maze.path;
        }

        //we calculated maze.maze.path shorter than this maze.maze.path
        if (check(counter)) {
            return maze.steps;
        }

//		
        // sign for availble maze.maze.path
        maze.cells[x][y] = '*';

        int numOfSteps = maze.steps;
        int testSteps = maze.steps;

        //Down-right
        testSteps = myPath(x + 1, y + 1, counter + 1);

        //Down-left
        testSteps = myPath(x + 1, y - 1, counter + 1);
        if (testSteps < numOfSteps) {
            numOfSteps = testSteps;
        }

        //Up-right
        testSteps = myPath(x - 1, y + 1, counter + 1);

        //Up-left
        testSteps = myPath(x - 1, y - 1, counter + 1);

        //Right
        testSteps = myPath(x, y + 1, counter + 1);

        //Left
        testSteps = myPath(x, y - 1, counter + 1);

        //Down
        testSteps = myPath(x + 1, y, counter + 1);

        //Up
        testSteps = myPath(x - 1, y, counter + 1);

        // to remove the sign (*)
        maze.cells[x][y] = '-';

        if (testSteps < maze.steps) {
            return testSteps;
        }

        return maze.steps;
    }

    public boolean check(int count) {
        return count >= maze.path;
    }

}
