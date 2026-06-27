public class AirLinkDelayRanking {
    static class Flight {
        String id;
        int delay;

        Flight(String id, int delay) {
            this.id = id;
            this.delay = delay;
        }
    }

    public static void main(String[] args) {
        Flight[] flights = {
                new Flight("AI101", 45),
                new Flight("AI102", 10),
                new Flight("AI103", 30),
                new Flight("AI104", 5),
                new Flight("AI105", 20)
        };

        System.out.println("AIRLINK FLIGHT DELAY ANALYSIS\n");

        System.out.println("Original Delay Data (Minutes)\n");
        for (Flight f : flights) {
            System.out.println("Flight " + f.id + " = " + f.delay);
        }

        quickSort(flights, 0, flights.length - 1);

        System.out.println("\nSORTED DELAY RANKING\n");
        for (int i = 0; i < flights.length; i++) {
            System.out.println("Rank " + (i + 1) + " -> Flight " + flights[i].id + " = " + flights[i].delay + " min");
        }

        System.out.println("\nTOP 3 BEST PERFORMING FLIGHTS");
        for (int i = 0; i < 3; i++) {
            System.out.println(flights[i].id);
        }

        System.out.println("\nTime Complexity:");
        System.out.println("Average Case : O(n log n)");
        System.out.println("Worst Case   : O(n^2)");
    }

    static void quickSort(Flight[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Flight[] arr, int low, int high) {
        int pivot = arr[high].delay;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].delay <= pivot) {
                i++;
                Flight temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Flight temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}