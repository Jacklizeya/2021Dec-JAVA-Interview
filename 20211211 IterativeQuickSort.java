public int partition(int[] arr, int leftPointer, int rightPointer) {
  int pivot = arr[Math.floorDiv((leftPointer + rightPointer), 2)];
 
  while (leftPointer < rightPointer) {
    while (arr[leftPointer] < pivot) {
      leftPointer++;
    }
    while (arr[rightPointer] > pivot) {
      rightPointer--;
    }
    if (leftPointer < rightPointer) {
      swap(arr, leftPointer, rightPointer);
    }
  }
  return leftPointer;
}
