public class NodeDL<E> {
    E data;
    NodeDL<E> prev;
    NodeDL<E> next;

    public NodeDL(E elem) {
        this.data = elem;
        this.prev = null;
        this.next = null;
    }

    public String toString() {
        return "" + this.data;
    }

    // TODO: Return whether the other has same type and same pointers
    //NOTE: FINISHED
    public boolean equals(Object o){
        if (o instanceof NodeDL) {
            return true;
        }
        else {
            return false;
        }
    }
}
