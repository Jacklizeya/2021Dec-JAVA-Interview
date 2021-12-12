// Partition will return the place left smaller and right bigger


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


public int[] quickSort(int[] arr, int start, int end) {
    if (end > start) {
    int partition = partition(arr, start, end);
    // recurse on left partition
      if (start < partition) {
      quickSort(arr, start, partition);
    }
    // recurse on right partition
    if (partition + 1 < end) {
      quickSort(arr, partition + 1, end);
    }
  }
  return arr;
}
 
