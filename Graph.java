
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Graph {

    // Represents a road connection
    static class Edge {
        int station;
        int distance;
        boolean blocked;

        Edge(int station, int distance) {
            this.station = station;
            this.distance = distance;
            this.blocked = false;
        }
    }

    // Stores station names
    private ArrayList<String> stations;

    // Adjacency list
    private ArrayList<ArrayList<Edge>> adj;

    // Constructor
    public Graph() {
        stations = new ArrayList<>();
        adj = new ArrayList<>();
    }

    // Find station index by name
    private int getStationIndex(String station) {
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).equalsIgnoreCase(station)) {
                return i;
            }
        }

        return -1;
    }

    // Add a station
    private void addStation(String station) {
        station = station.trim();

        if (station.isEmpty()) {
            System.out.println("Station name cannot be empty.");
            return;
        }

        if (getStationIndex(station) != -1) {
            System.out.println("Station already exists.");
            return;
        }

        stations.add(station);
        adj.add(new ArrayList<Edge>());

        System.out.println("Station added: " + station);
    }

    // Add an undirected road
    private void addUndirectedRoad(
            String source,
            String destination,
            int distance) {

        int sourceIndex = getStationIndex(source);
        int destinationIndex = getStationIndex(destination);

        if (sourceIndex == -1 || destinationIndex == -1) {
            System.out.println("Both stations must exist first.");
            return;
        }

        if (sourceIndex == destinationIndex) {
            System.out.println("A station cannot connect to itself.");
            return;
        }

        if (distance <= 0) {
            System.out.println("Distance must be positive.");
            return;
        }

        adj.get(sourceIndex).add(
            new Edge(destinationIndex, distance)
        );

        adj.get(destinationIndex).add(
            new Edge(sourceIndex, distance)
        );

        System.out.println("Road added successfully.");
    }

    // Create the graph
    public void createGraph(Scanner sc) {

        System.out.print("Enter number of stations: ");
        int numberOfStations = sc.nextInt();
        sc.nextLine();

        if (numberOfStations <= 0) {
            System.out.println("Number of stations must be positive.");
            return;
        }

        for (int i = 0; i < numberOfStations; i++) {
            System.out.print("Enter station " + (i + 1) + ": ");
            String station = sc.nextLine().trim();

            int oldSize = stations.size();

            addStation(station);

            if (stations.size() == oldSize) {
                System.out.println(
                    "Invalid or duplicate station. Restart the program."
                );
                return;
            }
        }

        System.out.print("Enter number of roads: ");
        int numberOfRoads = sc.nextInt();
        sc.nextLine();

        if (numberOfRoads < 0) {
            System.out.println("Number of roads cannot be negative.");
            return;
        }

        for (int i = 0; i < numberOfRoads; i++) {
            System.out.println("\nRoad " + (i + 1));

            System.out.print("Enter source station: ");
            String source = sc.nextLine().trim();

            System.out.print("Enter destination station: ");
            String destination = sc.nextLine().trim();

            System.out.print("Enter road distance: ");
            int distance = sc.nextInt();
            sc.nextLine();

            addUndirectedRoad(source, destination, distance);
        }

        displayGraph();
    }

    // Display adjacency list and blockage status
    public void displayGraph() {

        System.out.println("\n===== ROAD NETWORK =====");

        for (int i = 0; i < stations.size(); i++) {
            System.out.print(stations.get(i) + " -> ");

            ArrayList<Edge> edges = adj.get(i);

            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);

                System.out.print(
                    stations.get(edge.station)
                    + "(" + edge.distance + ")"
                );

                if (edge.blocked) {
                    System.out.print("[BLOCKED]");
                }

                System.out.print("  ");
            }

            System.out.println();
        }
    }

    // Find shortest emergency route using user input
    public void findShortestEmergencyRoute(Scanner sc) {

        System.out.print("Enter journey source station: ");
        String source = sc.nextLine().trim();

        System.out.print("Enter journey destination station: ");
        String destination = sc.nextLine().trim();

        dijkstra(source, destination);
    }

    // Mark a road as blocked in both directions
    public boolean blockRoad(String source, String destination) {

        int sourceIndex = getStationIndex(source);
        int destinationIndex = getStationIndex(destination);

        if (sourceIndex == -1 || destinationIndex == -1) {
            System.out.println("One or both stations do not exist.");
            return false;
        }

        if (sourceIndex == destinationIndex) {
            System.out.println(
                "A station cannot be connected to itself."
            );
            return false;
        }

        Edge forwardEdge = null;
        Edge reverseEdge = null;

        // Search for the road from source to destination
        ArrayList<Edge> sourceEdges = adj.get(sourceIndex);

        for (int i = 0; i < sourceEdges.size(); i++) {
            Edge edge = sourceEdges.get(i);

            if (edge.station == destinationIndex) {
                forwardEdge = edge;
                break;
            }
        }

        // Search for the reverse road
        ArrayList<Edge> destinationEdges = adj.get(destinationIndex);

        for (int i = 0; i < destinationEdges.size(); i++) {
            Edge edge = destinationEdges.get(i);

            if (edge.station == sourceIndex) {
                reverseEdge = edge;
                break;
            }
        }

        if (forwardEdge == null || reverseEdge == null) {
            System.out.println("This road does not exist.");
            return false;
        }

        if (forwardEdge.blocked) {
            System.out.println("This road is already blocked.");
            return false;
        }

        // Block both directions of the undirected road
        forwardEdge.blocked = true;
        reverseEdge.blocked = true;

        System.out.println(
            "Blocked road: " + stations.get(sourceIndex)
            + " <-> " + stations.get(destinationIndex)
        );

        return true;
    }

    // Dijkstra's algorithm, ignoring blocked roads
    private void dijkstra(String source, String destination) {

        int start = getStationIndex(source);
        int end = getStationIndex(destination);

        if (start == -1 || end == -1) {
            System.out.println(
                "Source or destination station not found."
            );
            return;
        }

        int n = stations.size();

        int[] distance = new int[n];
        int[] previous = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        distance[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentStation = current[0];
            int currentDistance = current[1];

            if (currentDistance != distance[currentStation]) {
                continue;
            }

            if (currentStation == end) {
                break;
            }

            ArrayList<Edge> edges = adj.get(currentStation);

            for (int i = 0; i < edges.size(); i++) {

                Edge edge = edges.get(i);

                // Ignore blocked roads
                if (edge.blocked) {
                    continue;
                }

                int neighbour = edge.station;
                int roadDistance = edge.distance;

                if (distance[currentStation] != Integer.MAX_VALUE
                        && (long) distance[currentStation] + roadDistance
                        < distance[neighbour]) {

                    distance[neighbour] =
                        distance[currentStation] + roadDistance;

                    previous[neighbour] = currentStation;

                    pq.offer(new int[]{
                        neighbour, distance[neighbour]
                    });
                }
            }
        }

        if (distance[end] == Integer.MAX_VALUE) {
            System.out.println(
                "No available route exists between these stations."
            );
            return;
        }

        // Reconstruct the shortest path
        ArrayList<String> path = new ArrayList<>();

        int current = end;

        while (current != -1) {
            path.add(stations.get(current));
            current = previous[current];
        }

        Collections.reverse(path);

        System.out.println("\n===== SHORTEST EMERGENCY ROUTE =====");

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));

            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println("\nTotal distance: " + distance[end]);
    }
}