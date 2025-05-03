import java.util.*;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {
    private static Comparator<Item> comparator = new Comparator<Item>() {
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        }
    };

    public static double fractionalKnapsack(int W, Item[] items) {
        Arrays.sort(items, comparator);
        int curWeight = 0;
        double finalValue = 0.0;

        for (Item item : items) {
            if (curWeight + item.weight <= W) {
                curWeight += item.weight;
                finalValue += item.value;
            } else {
                int remain = W - curWeight;
                finalValue += item.value * ((double) remain / item.weight);
                break;
            }
        }
        return finalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + ": ");
            int value = scanner.nextInt();
            int weight = scanner.nextInt();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter the maximum capacity of the knapsack: ");
        int W = scanner.nextInt();
        System.out.printf("Maximum value in Knapsack = %.2f\n", fractionalKnapsack(W, items));
        scanner.close();
    }
}

/*
 * Enter the number of items: 4
 * Enter value and weight for item 1: 60 10
 * Enter value and weight for item 2: 100 20
 * Enter value and weight for item 3: 120 30
 * Enter value and weight for item 4: 80 40
 * Enter the maximum capacity of the knapsack: 50
 * Maximum value in Knapsack = 240.00
 */