package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackPack {
    private int numberOfItems;
    private int capacity;
    private int[][] backPackTable;
    private int totalValue;
    private int[] weights;
    private int[] values;

    public BackPack(int numberOfItems, int capacity, int[] weights, int[] values) {
        super();
        this.numberOfItems = numberOfItems;
        this.capacity = capacity;
        this.weights = weights;
        this.values = values;
        this.backPackTable = new int[numberOfItems + 1][capacity + 1];
    }

    public void solve() {
        for (int i = 1; i < numberOfItems + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                int itemNotToTake = backPackTable[i - 1][j];
                int itemToTake = 0;
                if (weights[i] <= j) {
                    itemToTake = values[i] + backPackTable[i - 1][j - weights[i]];
                }
                backPackTable[i][j] = Math.max(itemNotToTake, itemToTake);
            }
        }
        totalValue = backPackTable[numberOfItems][capacity];
    }

    public void showResult() {
        System.out.println("Total value = " + totalValue);
        for (int n = numberOfItems, w = capacity; n > 0; n--) {
            if (backPackTable[n][w] != 0 && backPackTable[n][w] != backPackTable[n - 1][w]) {
                System.out.println("We take item : " + n);
                w -= weights[n];
            }
        }
    }
}
