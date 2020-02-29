import beans.BackPack;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of items");
        int numberOfItems = in.nextInt();
        System.out.println("Input capacity");
        int capacity = in.nextInt();

        int[] weights = new int[numberOfItems + 1];
        for (int i = 1; i < weights.length; i++) {
            weights[i] = (int) (Math.random() * 10);
            System.out.println("Item " + i + " weight = " + weights[i]);
        }

        System.out.println();

        int[] values = new int[weights.length];
        for (int j = 1; j < values.length; j++) {
            values[j] = (int) (Math.random() * 10);
            System.out.println("Item " + j + " value = " + values[j]);
        }
        System.out.println();

        BackPack backpack = new BackPack(numberOfItems, capacity, weights, values);
        backpack.solve();
        backpack.showResult();
    }
}
