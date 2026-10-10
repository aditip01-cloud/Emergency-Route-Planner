public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(6);

        // Adding emergency road connections
        graph.addUndirectedRoad(0, 1, 5);
        graph.addUndirectedRoad(0, 2, 3);
        graph.addUndirectedRoad(1, 3, 4);
        graph.addUndirectedRoad(2, 3, 2);
        graph.addUndirectedRoad(2, 4, 6);
        graph.addUndirectedRoad(3, 5, 3);
        graph.addUndirectedRoad(4, 5, 2);

        System.out.println("DISASTER EMERGENCY ROAD NETWORK");
        System.out.println("--------------------------------");

        graph.displayGraph();
        System.out.println("\nBefore blockage:");
graph.dijkstra(0, 5);

System.out.println("\nBlocking road 3 - 5:");
graph.blockRoad(3, 5);

System.out.println("\nAfter blockage:");
graph.dijkstra(0, 5);

graph.displayGraph();

        System.out.println("\nNeighbors of Location 2:");

        Node temp = graph.getNeighbors(2);

        while (temp != null) {

            System.out.println(
                "Location: " + temp.vertex +
                ", Distance: " + temp.weight
            );

            temp = temp.next;
        }
    }
}
