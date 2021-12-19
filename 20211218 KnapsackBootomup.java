public class Knapsack {

    static int knapSack(int weightCap, int weights[], int values[], int i)
    {
        int index, weight;
        int matrix[][] = new int[i + 1][weightCap + 1];

        for (index = 0; index <= i; index++) {
            for (weight = 0; weight <= weightCap; weight++) {
            // add code here
                int value1 = 0;
                int value2 = 0;
                if (index == 0 || weight == 0) {matrix[index][weight] = 0;}
            // Notes: matrix's index equal to weights and value's index - 1
                else if (weights[index - 1] <= weight) {
                        value1 = matrix[index - 1][weight - weights[index - 1]] + values[index - 1];
                        value2 = matrix[index-1][weight];
                        matrix[index][weight] = Math.max(value1, value2);
                    }
                else {
                        matrix[index][weight] = matrix[index-1][weight];
                }
               }
            }
        return matrix[i][weightCap];
    }


    public static void main(String[] args) {
        int values[] = new int[] { 70, 20, 39, 37, 7, 5, 10 };
        int weights[] = new int[] { 31, 10, 20, 19, 4, 3, 6 };
        int weightCap = 50;
        int i = values.length;
        Knapsack myNapsack = new Knapsack();
        System.out.println(myNapsack.knapSack(weightCap, weights, values, i));
    }
}
