
import java.util.*;
public class Graph
    {

    Node[] head;
    int vertices;

    Graph(int vertices) {
        this.vertices = vertices;
        head = new Node[vertices];
    }

void dijkstra(int source, int destination) {

    if (source < 0 || source >= vertices ||
        destination < 0 || destination >= vertices) {
        System.out.println("Invalid station!");
        return;
    }

    int[] distance = new int[vertices];
    int[] previous = new int[vertices];

    Arrays.fill(distance, Integer.MAX_VALUE);
    Arrays.fill(previous, -1);

    PriorityQueue<int[]> pq = new PriorityQueue<>(
        Comparator.comparingInt(a -> a[1])
    );

    distance[source] = 0;
    pq.add(new int[]{source, 0});

    while (!pq.isEmpty()) {

        int[] current = pq.poll();
        int station = current[0];
        int currentDistance = current[1];

        if (currentDistance != distance[station]) {
            continue;
        }

        if (station == destination) {
            break;
        }

        Node temp = head[station];

        while (temp != null) {

            if (!temp.blocked) {

                int nextStation = temp.vertex;
                int newDistance = currentDistance + temp.weight;

                if (newDistance < distance[nextStation]) {
                    distance[nextStation] = newDistance;
                    previous[nextStation] = station;

                    pq.add(new int[]{
                        nextStation, newDistance
                    });
                }
            }

            temp = temp.next;
        }
    }

    if (distance[destination] == Integer.MAX_VALUE) {
        System.out.println("No available route!");
        return;
    }

    ArrayList<Integer> path = new ArrayList<>();

    int current = destination;

    while (current != -1) {
        path.add(current);
        current = previous[current];
    }

    Collections.reverse(path);

    System.out.println("Shortest route: " + path);
    System.out.println("Total distance: " + distance[destination]);
}
        
void blockRoad(int source, int destination) {

    if (source < 0 || source >= vertices ||
        destination < 0 || destination >= vertices) {
        System.out.println("Invalid station!");
        return;
    }

    boolean found = false;

    Node temp = head[source];

    while (temp != null) {
        if (temp.vertex == destination) {
            temp.blocked = true;
            found = true;
        }
        temp = temp.next;
    }

    temp = head[destination];

    while (temp != null) {
        if (temp.vertex == source) {
            temp.blocked = true;
            found = true;
        }
        temp = temp.next;
    }

    if (found) {
        System.out.println("Road blocked: "
            + source + " - " + destination);
    } else {
        System.out.println("Road not found!");
    }
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
    temp.vertex + "(" + temp.weight + ")"
    + (temp.blocked ? "[BLOCKED] " : " ")
);
                temp = temp.next;
            }

            System.out.println();
        }
    }
}
