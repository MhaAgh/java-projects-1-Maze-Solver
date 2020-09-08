package mazeslover;

public class Maze {

    //variables:
    public char[][] cells = new char[12][12];
    char[][] solvingMaze = new char[12][12];
    int startX;
    int startY;
    int steps = 100;
    int path = 100;

    //constructar:
    public Maze() {

        //filling the array
        for (int i = 1; i < cells.length - 1; i++) {
            for (int j = 1; j < cells.length - 1; j++) {
                cells[i][j] = '-';
            }
        }
        //for the boarder      
        for (int z = 0; z < cells.length; z++) {
            cells[0][z] = ' ';
            cells[11][z] = ' ';
            cells[z][0] = ' ';
            cells[z][11] = ' ';
        }

    }

    public void init() {
        for (char[] cell : cells) {
            for (int j = 0; j < cells.length; j++) {
                if (cell[j] == 'O' || cell[j] == 'S' || cell[j] == 'F' || cell[j] == '*') {
                    cell[j] = '-';
                }
            }
        }
    }

    public boolean checkPosition(int col, int row) {
        if (cells[row + 1][col + 1] != '-' && cells[row + 1][col] != '-' && cells[row + 1][col - 1] != '-' && cells[row][col + 1] != '-' && cells[row][col - 1] != '-' && cells[row - 1][col + 1] != '-' && cells[row - 1][col] != '-' && cells[row - 1][col - 1] != '-') {
            System.out.println("There is no possible way to solve the maze, you need to remove an obstcale");
            return false;
        } else {
            return true;
        }
    }

    public boolean isThereStart() {
        boolean thereIsStart = false;
        for (char[] cell : cells) {
            for (int j = 0; j < cells.length; j++) {
                if (cell[j] == 'S') {
                    thereIsStart = true;
                }
            }
        }
        return thereIsStart;
    }

    public boolean isThereFinish() {
        boolean thereIsFinish = false;
        for (char[] cell : cells) {
            for (int j = 0; j < cells.length; j++) {
                if (cell[j] == 'F') {
                    thereIsFinish = true;
                }
            }
        }
        return thereIsFinish;
    }

    public boolean isTherePath() {
        boolean thereIsFinish = false;
        for (char[] cell : cells) {
            for (int j = 0; j < cells.length; j++) {
                if (cell[j] == '*') {
                    thereIsFinish = true;
                }
            }
        }
        return thereIsFinish;
    }

    public boolean isThereObstcale() {
        boolean thereIsObstcale = false;
        for (char[] cell : cells) {
            for (int j = 0; j < cells.length; j++) {
                if (cell[j] == 'O') {
                    thereIsObstcale = true;
                }
            }
        }
        return thereIsObstcale;
    }
}
