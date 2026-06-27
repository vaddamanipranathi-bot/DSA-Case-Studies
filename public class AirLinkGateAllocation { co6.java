public class AirLinkGateAllocation {
    static class Flight {
        int id, start, end;

        Flight(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Flight[] flights = {
                new Flight(1, 1, 2),
                new Flight(2, 3, 4),
                new Flight(3, 0, 6),
                new Flight(4, 5, 7),
                new Flight(5, 8, 9),
                new Flight(6, 5, 9)
        };

        System.out.println("AIRLINK GATE ALLOCATION SYSTEM\n");

        System.out.println("Flight Schedule\n");
        for (Flight f : flights) {
            System.out.println("Flight " + f.id + " : Start=" + f.start + " End=" + f.end);
        }

        System.out.println("\nACTIVITY SELECTION PROCESS\n");

        int count = 0;
        int lastEnd = -1;
        int[] selected = new int[flights.length];

        for (Flight f : flights) {
            if (f.start >= lastEnd) {
                selected[count++] = f.id;
                lastEnd = f.end;
                System.out.println("Selected Flight " + f.id);
            }
        }

        System.out.println("\nFINAL GATE ALLOCATION\n");
        for (int i = 0; i < count; i++) {
            System.out.println("Gate Assigned -> Flight " + selected[i]);
        }

        System.out.println("\nMaximum Flights Allocated = " + count);

        System.out.println("\nTime Complexity:");
        System.out.println("Sorting   : O(n log n)");
        System.out.println("Selection : O(n)");
    }
}