import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    DoublyLinkedList<String> DLL1;
    DoublyLinkedList<String> DLL2;

    @Test
    public void insertMethod() {
        DLL1 = new DoublyLinkedList<String>();
        DLL2 = new DoublyLinkedList<String>();

        DLL1.insertAtHead("Food");
        assertEquals("Food", DLL1.get(0));

        DLL1.insertAtHead("Hamburger");
        assertEquals("Hamburger", DLL1.get(0));
        assertEquals("Food", DLL1.get(1));

        DLL1.insertAtHead("Spaghetti");
        assertEquals("Spaghetti", DLL1.get(0));
        assertEquals("Hamburger", DLL1.get(1));
        assertEquals("Food", DLL1.get(2));

        DLL1.insertAtTail("Pickle");
        assertEquals("Pickle",DLL1.get(3));

        DLL1.insertAtTail("Fish");
        assertEquals("Spaghetti", DLL1.get(0));
        assertEquals("Hamburger", DLL1.get(1));
        assertEquals("Food", DLL1.get(2));
        assertEquals("Pickle", DLL1.get(3));
        assertEquals("Fish", DLL1.get(4));

        //how to throw an exception?

        /*try {
            DLL2.insertAtHead("Something");
            fail();
        } catch(IndexOutOfBoundsException e) {
            assertEquals("Index is unreachable.", DLL2.get(1));
        }
        */


    }
    @Test
    public void deleteMethod() throws EmptyListE {
        DLL1 = new DoublyLinkedList<String>();
        DLL2 = new DoublyLinkedList<String>();

        DLL1.insertAtHead("Food");
        DLL1.insertAtHead("Hamburger");
        DLL1.insertAtHead("Spaghetti");
        DLL1.insertAtTail("Pickle");
        DLL1.insertAtTail("Fish");

        String answer = DLL1.deleteAtHead();

        assertEquals("Spaghetti", answer);

        answer = DLL1.deleteAtTail();

        assertEquals("Fish", answer);

        //after deleting the two, check to see if they're in the same placement
        assertEquals("Hamburger", DLL1.get(0));

        assertEquals("Pickle", DLL1.get(2));

    }
    @Test
    public void searchMethod() {
        DLL1 = new DoublyLinkedList<String>();
        DLL2 = new DoublyLinkedList<String>();

        DLL1.insertAtHead("Food");
        DLL1.insertAtHead("Hamburger");
        DLL1.insertAtHead("Spaghetti");
        DLL1.insertAtTail("Pickle");
        DLL1.insertAtTail("Fish");

        int pos = DLL1.search("Food");
        assertEquals(2, pos);

        pos = DLL1.search("Hamburger");
        assertEquals(1, pos);

        pos = DLL1.search("Spaghetti");
        assertEquals(0, pos);

        pos = DLL1.search("Pickle");
        assertEquals(3, pos);

        pos = DLL1.search("Fish");
        assertEquals(4, pos);

        pos = DLL1.search("a;slkjf;aklsd");
        assertEquals(-1, pos);
    }

    @Test
    public void equalsTest() {
        DLL1 = new DoublyLinkedList<String>();
        DLL2 = new DoublyLinkedList<String>();
        DoublyLinkedList<Integer> DLL3 = new DoublyLinkedList<Integer>();

        boolean answer = DLL1.equals(DLL2);

        assertEquals(true, answer);

        //answer = DLL1.equals(DLL3);

        //assertEquals(false, answer);

        //WORK ON EQUALS LATER
    }
}
