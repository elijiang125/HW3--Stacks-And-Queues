import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    Queue q1 = new Queue();
    Queue q2 = new Queue();

    @Test
    public void enqueueTest() {
        q1.enqueue("Hamburger");

        assertEquals("Hamburger", q1.peek());

        q1.enqueue("Fish");

        assertEquals("Hamburger", q1.peek());

    }

    @Test
    public void deQueueTest() throws EmptyQueueE {

        q1.enqueue("Hamburger");
        q1.enqueue("Fish");

        Object removed = q1.dequeue();

        assertEquals("Fish", removed);

        removed = q1.dequeue();

        assertEquals("Hamburger", removed);
    }
}


