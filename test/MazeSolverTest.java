import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MazeSolverTest {

String file1 = "C:\\Users\\Elizabeth\\Documents\\C343Labs\\HW3\\maze1.txt";
String file2 = "C:\\Users\\Elizabeth\\Documents\\C343Labs\\HW3\\maze2.txt";
String file3 = "C:\\Users\\Elizabeth\\Documents\\C343Labs\\HW3\\maze3.txt";

@Test
public void solveMaze() throws IOException, EmptyStackE, EmptyQueueE {
    //boolean answer;

    //answer = MazeSolver.solve(file1, 1);

    //assertEquals(true, answer);

    assertTrue(MazeSolver.solve(file1, 1));
}
}
