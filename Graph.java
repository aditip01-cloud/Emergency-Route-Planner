public class Graph {

    Node[] head;
    int vertices;

    Graph(int vertices) {
        this.vertices = vertices;
        head = new Node[vertices];
    }

    void addRoad(int source, int destination, int weight) {

        Node newNode = new Node(destination, weight);

        newNode.next = head[source];
        head[source] = newNode;
    }

    void addUndirectedRoad(int source, int destination, int weight) {

        addRoad(source, destination, weight);
        addRoad(destination, source, weight);
    }

    Node getNeighbors(int vertex) {
        return head[vertex];
    }

    void displayGraph() {

        for (int i = 0; i < vertices; i++) {

            System.out.print(i + " -> ");

            Node temp = head[i];

            while (temp != null) {

                System.out.print(
                    temp.vertex + "(" + temp.weight + ") "
                );

                temp = temp.next;
            }

            System.out.println();
        }
    }
}
