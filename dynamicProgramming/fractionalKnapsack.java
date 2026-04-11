package codes.dynamicProgramming;

import java.util.*;

class Item {
    int value, weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

public class fractionalKnapsack {

    public static void getMaxProfit(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0.0;

        System.out.println("Selected Items (value, weight, fraction taken):");

        for (Item item : items) {
            if (capacity >= item.weight) {
                totalProfit += item.value;
                capacity -= item.weight;

                System.out.println(item.value + ", " + item.weight + ", 1.0");
            } else {
                double fraction = (double) capacity / item.weight;
                totalProfit += item.value * fraction;

                System.out.println(item.value + ", " + item.weight + ", " + fraction);
                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        int capacity = 50;

        getMaxProfit(items, capacity);
    }
}