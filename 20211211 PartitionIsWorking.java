import java.util.Arrays;

public class QuickSort {

   public int[] quickSort(int[] arr) {
       if (arr.length <= 1) {
           return arr;
       }
       return quickSort(arr, 0, arr.length - 1);
   }

   public int[] quickSort(int[] arr, int start, int end) {
       if (end > start) {
           int partition = partition(arr, start, end);
           if (start < partition) {
               quickSort(arr, start, partition);
           }
           if (partition + 1< end) {
               quickSort(arr, partition + 1, end);
           }
       }
       return arr;
   }

   public int partition(int[] arr, int leftPointer, int rightPointer) {
       System.out.println("Partitioning the current subarray:");
       System.out.println(Arrays.toString(Arrays.copyOfRange(arr, leftPointer, rightPointer + 1)));

       int pivot = arr[Math.floorDiv((leftPointer + rightPointer), 2)];
       System.out.println("The pivot value is: " + pivot);

       while (leftPointer < rightPointer) {
        //    System.out.println("One round" + "leftPointer" +  leftPointer + "rightPointer" + rightPointer);
        //    System.out.println("One round" + "pivot" + pivot + "leftValue " + arr[leftPointer] + "rightValue" + arr[rightPointer] );
           while (arr[leftPointer] < pivot) {
               leftPointer++;
               System.out.println("Incrementing left pointer to " + arr[leftPointer]);
           }
           while (arr[rightPointer] > pivot) {
              System.out.println("Decrementing right pointer to ");
              rightPointer--;
              System.out.println("Decrementing right pointer to " + arr[rightPointer]);
           }
           if (leftPointer < rightPointer) {
               System.out.println("Swapping " + arr[leftPointer] + " and " + arr[rightPointer]);
               Swap.swap(arr, leftPointer, rightPointer);
           }
       }
       return leftPointer;
   }

   public static void main(String[] args) {
       QuickSort qs = new QuickSort();
       int[] unsorted = {39, 15, 24, 35, 76, 19, 21, 23, 35, 78, 90, 76, 45, 89, 39};
    //    System.out.println("Sorting the array " + Arrays.toString(unsorted));
    //    qs.quickSort(unsorted);
    //    System.out.println("After sorting: " + Arrays.toString(unsorted));
    qs.partition(unsorted, 0, unsorted.length  - 1);
    System.out.println(Arrays.toString(unsorted));
   }
}
