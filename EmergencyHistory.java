public class EmergencyHistory {

    private static class Node {
        EmergencyRecord data;
        Node next;
        Node(EmergencyRecord data) { this.data = data; }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addRecord(EmergencyRecord record) {
        Node node = new Node(record);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No emergency records yet.");
            return;
        }
        System.out.println("=== Emergency History (" + size + " records) ===");
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.data);
        }
    }

    public EmergencyRecord searchById(int requestId) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data.getRequestId() == requestId) return cur.data;
        }
        return null;
    }

    public int searchByOutcome(String outcome) {
        int found = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data.getOutcome().equalsIgnoreCase(outcome)) {
                System.out.println(cur.data);
                found++;
            }
        }
        return found;
    }

    public int searchByDestination(String destination) {
        int found = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data.getDestination().equalsIgnoreCase(destination)) {
                System.out.println(cur.data);
                found++;
            }
        }
        return found;
    }

    public int size()        { return size; }
    public boolean isEmpty() { return head == null; }
}
