import java.util.Scanner;

public class SalesSegmentTree {

    static int[] tree;

    static void build(int[] sales, int node, int start, int end) {
        if (start == end) {
            tree[node] = sales[start];
        } else {
            int mid = (start + end) / 2;

            build(sales, 2 * node, start, mid);
            build(sales, 2 * node + 1, mid + 1, end);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    static int query(int node, int start, int end, int left, int right) {

        if (right < start || left > end)
            return 0;

        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;

        return query(2 * node, start, mid, left, right)
                + query(2 * node + 1, mid + 1, end, left, right);
    }

    static void printTree(int node, int start, int end) {

        if (start == end) {
            System.out.println("Month " + (start + 1) +
                    " Sales = " + tree[node]);
            return;
        }

        int mid = (start + end) / 2;

        System.out.println("Range [" + (start + 1) + "-" + (end + 1) +
                "] = " + tree[node]);

        printTree(2 * node, start, mid);
        printTree(2 * node + 1, mid + 1, end);
    }

    public static void main(String[] args) {

        int[] sales = {1000, 1500, 2000, 1200, 1800, 2500};

        int n = sales.length;

        tree = new int[4 * n];

        build(sales, 1, 0, n - 1);

        System.out.println("Segment Tree Structure:");
        printTree(1, 0, n - 1);

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Starting Month (1-6): ");
        int startMonth = sc.nextInt();

        System.out.print("Enter Ending Month (1-6): ");
        int endMonth = sc.nextInt();

        int totalSales = query(1, 0, n - 1,
                startMonth - 1, endMonth - 1);

        System.out.println("\nTotal Sales from Month "
                + startMonth + " to Month "
                + endMonth + " = " + totalSales);

        sc.close();
    }
}