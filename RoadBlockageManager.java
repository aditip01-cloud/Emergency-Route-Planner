
import java.util.Scanner;

public class RoadBlockageManager {

    public void reportRoadBlockage(Scanner sc, Graph graph) {

        System.out.println("\n===== REPORT ROAD BLOCKAGE =====");

        System.out.print("Enter first station of blocked road: ");
        String source = sc.nextLine().trim();

        System.out.print("Enter second station of blocked road: ");
        String destination = sc.nextLine().trim();

        RoadBlockage blockage =
            new RoadBlockage(source, destination);

        boolean blocked = graph.blockRoad(
            blockage.getSource(),
            blockage.getDestination()
        );

        if (!blocked) {
            System.out.println(
                "Could not block the road. Please check the station names and road connection."
            );
            return;
        }

        System.out.println("Road successfully marked as blocked.");

        System.out.println(
            "\nNow find an alternative route for your journey."
        );

        graph.findShortestEmergencyRoute(sc);
    }
}
