import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    Stack s1 = new Stack();
    Stack s2 = new Stack();

    @Test
    public void pushTest() throws EmptyStackE {
        s1.push("Hamburger");

        assertEquals("Hamburger", s1.peek());

        s1.push("Fish");

        assertEquals("Fish", s1.peek());

    }

    @Test
    public void popTest() throws EmptyStackE {

        s1.push("Hamburger");
        s1.push("Fish");

        Object removed = s1.pop();

        assertEquals("Fish", removed);

        removed = s1.pop();

        assertEquals("Hamburger", removed);
    }
}
