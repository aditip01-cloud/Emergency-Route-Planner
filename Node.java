
public class Node {

    int vertex;
    int weight;
    Node next;
    boolean blocked;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
        this.next = null;
        this.blocked = false;
    }
}
