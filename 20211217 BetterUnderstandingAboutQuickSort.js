const swap = (array, i, j) => {
    let temporary = array[i]
    array[i] = array[j]
    array[j] = temporary
}

const quicksort = (array, leftBound = 0, rightBound = array.length - 1) => {
  if (leftBound < rightBound) {
    const pivotIndex = partition(array, leftBound, rightBound);
    quicksort(array, leftBound, pivotIndex - 1);
    quicksort(array, pivotIndex, rightBound);
  }
  return array;
}

const partition = (array, leftIndex, rightIndex) => {
  console.log("*******************************partition", leftIndex, rightIndex)
  const pivot = array[Math.floor((rightIndex + leftIndex) / 2)];
  while (leftIndex <= rightIndex) {
    while (array[leftIndex] < pivot) {
      leftIndex++;
    }
    while (array[rightIndex] > pivot) {
      rightIndex--;
    }
    console.log("line 26, ready to swap", leftIndex, rightIndex)
    if (leftIndex <= rightIndex) {
      console.log("one round of pivot", pivot, leftIndex, rightIndex)
      swap(array, leftIndex, rightIndex);
      leftIndex++;
      rightIndex--;
      console.log("after swapping", array, leftIndex, rightIndex)
    }
  }
  return leftIndex;
}

quicksort([4, 6, -5, 4, -2, -1, 13, 0, 15, 6, -12, -10, -9, -8, -2])
