import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Feel free to reuse from HW1

public class MazeSolver {
    static char[][] maze;
    static int m, n; // dimensions of the maze

    /*
    TODO: setMaze - sets up the board
    This method will take in a String, file, which is the path of the file we want to look at.
    Using BufferedReader and FileReader, write this method so that it sets the rows, m, and columns, n,
    to the first line of input. Then it fills the maze with the maze from the file.
     */
    public static void setMaze(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine(); //reads first line with dimensions
        m = (int) line.charAt(0);
        n = (int) line.charAt(2);

        maze = new char[m][n];
        int row = 0; //temp number to check rows

        line = reader.readLine(); //read next line

        try {

            while (line != null) { //while line isn't empty

                for (int i = 0; i < line.length(); i++) { //goes through each character in a line
                    if (line.charAt(i) == 'S') {
                        maze[row][i] = 'S';
                    }
                    else if (line.charAt(i) == 'G') {
                        maze[row][i] = 'G';
                    }
                    else if (line.charAt(i) == '#') {
                        maze[row][i] = '#';
                    }
                    else if (line.charAt(i) == '.') {
                        maze[row][i] = '.';
                    }
                }
                row++; //row increases
                line = reader.readLine(); //reads next line
            }
            reader.close();

        }catch(IOException e){
            e.printStackTrace();

        }
    }

    /*
    TODO: isValid - checks if a position on the board has not been visited and is within bounds
     */
    public static boolean isValid(int x, int y) {
        if (x < 0 || y < 0) {
            return false; //negative number
        }
        else if (x >= m || y >= n) {
            return false; //out of bounds
        }
        else {
            return true; //valid, can go
        }
    }


    /*
    TODO: Using a stack, solve the maze WITHOUT recursion.
    Pseudo:
    1) Push start position onto Stack.
    2) While it's not empty;
        3) Pop from the stack to get the current considered location
        4) If it's already explored ignore
        5) If it's the goal, return true
        6) If it's not the goal, then explore it.
        7) You will need to compute all the possible neighbors. Then push those on the stack
    8) Return false
     */

    //MAKE SURE TO SET IT AS NULL ONCE WHEN YOU'RE ON THE THING
    public static boolean solveMazeStack(int x, int y)  throws EmptyStackE {

        //temporary variables to search

        Stack<Coord> stackMaze = new Stack<Coord>();

        stackMaze.push(new Coord(x, y));

        while (stackMaze.size() != 0) { //while not empty
            Coord current = stackMaze.pop(); //pops out current cords

            char temp = maze[current.getX()][current.getY()];

            if (temp == 'G') {
                return true;
            }

            if (temp == '#') {
                continue;
            }

            if (isValid(current.getX()-1, current.getY())) { //if west is valid
                stackMaze.push(new Coord(current.getX() - 1, current.getY()));
            }
            if (isValid(current.getX(), current.getY()+1)) { //if north is valid
                stackMaze.push(new Coord(current.getX(), current.getY() + 1));
            }
            if (isValid(current.getX() + 1, current.getY())) { //if east is valid
                stackMaze.push(new Coord(current.getX() + 1, current.getY()));
            }
            if (isValid(current.getX(), current.getY()-1)) { //if south is valid
                stackMaze.push(new Coord(current.getX() , current.getY() - 1));
            }
        }
        return false;

    }

    // TODO: Using a queue, solve the maze. Be sure to explain your algorithm for full points.
    public static boolean solveMazeQueue(int x, int y) throws EmptyQueueE{

        //I GOT IT (I THINK)
        //1. set temporary variables for x and y to maneuver maze
        //2. set starting position as a char and use the x and y to find north, south, east, and west
        //3. use the isValid to see if it's # or not
        //4. if isValid is true, then put the value into the queue AND
        //      - increment/decrement x and y
        //      - rely on the while loop to do it again and again
        //5. UNTIL goal is hit, then return true (FIRST IF CASE)
        //6. when queue is empty and there's nothing left, return false

        int tempX = x;
        int tempY = y;
        //temporary variables to search

        Queue<Character> queueMaze = new Queue<Character>();

        queueMaze.enqueue(maze[x][y]);

        while (queueMaze.size() != 0) { //while not empty
            char temp = queueMaze.dequeue();

            if (temp == 'G') {
                return true;
            }
            if (isValid(tempX-1, tempY)) { //if west is valid
                queueMaze.enqueue(maze[--tempX][tempY]);
            }
            if (isValid(tempX, tempY+1)) { //if north is valid
                queueMaze.enqueue(maze[tempX][++tempY]);
            }
            if (isValid(tempX+1, tempY)) { //if east is valid
                queueMaze.enqueue(maze[++tempX][tempY]);
            }
            if (isValid(tempX, tempY-1)) { //if south is valid
                queueMaze.enqueue(maze[tempX][--tempY]);
            }
        }
        return false;
    }

    // TODO: Solve the board. Mode 1 = stack solving. Mode 2 = queue solving.
    // 1: stack
    // 2: queue
    public static boolean solve(String file, int mode) throws IOException, EmptyStackE, EmptyQueueE {
        // find starting point
        // check if the maze can be solved

        boolean solved = false;
        int x = 0;
        int y = 0;

        setMaze(file); //set maze up

        //find starting position
        for (int i = 0 ; i < maze.length; i++) {
            if (maze[x][i] == 'S') {
                y = i;
            }
        }

        if (mode == 1) {
            solved = solveMazeStack(x, y);
        }
        else if (mode == 2) {
            solved = solveMazeQueue(x, y);
        }
        else {
            System.out.println("Unable to identify mode");
        }

        System.out.println("Maze can be solved: " + solved);
        return solved;
    }


}