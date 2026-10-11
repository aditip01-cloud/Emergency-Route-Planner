import java.util.List;

public class EmergencyRecord {
    private final int requestId;
    private final String source;
    private final String destination;
    private final List<String> routeTaken;   // empty if no route was available
    private final int totalDistance;         // -1 if no route was available
    private final String outcome;            // e.g. "COMPLETED", "NO ROUTE"

    public EmergencyRecord(int requestId, String source, String destination,
                           List<String> routeTaken, int totalDistance, String outcome) {
        this.requestId = requestId;
        this.source = source;
        this.destination = destination;
        this.routeTaken = routeTaken;
        this.totalDistance = totalDistance;
        this.outcome = outcome;
    }

    public int getRequestId()           { return requestId; }
    public String getSource()           { return source; }
    public String getDestination()      { return destination; }
    public List<String> getRouteTaken() { return routeTaken; }
    public int getTotalDistance()       { return totalDistance; }
    public String getOutcome()          { return outcome; }

    @Override
    public String toString() {
        String route = routeTaken.isEmpty() ? "N/A" : String.join(" -> ", routeTaken);
        String dist = totalDistance < 0 ? "N/A" : totalDistance + " km";
        return "Request #" + requestId + " | " + source + " to " + destination
             + " | Route: " + route + " | Distance: " + dist + " | Outcome: " + outcome;
    }
}
