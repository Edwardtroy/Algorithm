package noaland.sort;


import static java.lang.System.arraycopy;

class MergeSort {
    private int[] sortList;
    private int[] mergeListInProgress;

    int[] sort(int inputArr[]) {
        this.sortList = inputArr;
        int length = inputArr.length;
        this.mergeListInProgress = new int[length];
        mergeSort(0, length - 1);

        return sortList;
    }

    private void mergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            mergeSort(lowerIndex, middle);
            mergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        int leftIndex = lowerIndex;
        int rightIndex = middle + 1;
        int sortingIndex = lowerIndex;

        arraycopy(sortList, lowerIndex, mergeListInProgress, lowerIndex, higherIndex + 1 - lowerIndex);

        while (leftIndex <= middle && rightIndex <= higherIndex) {
            if (mergeListInProgress[leftIndex] <= mergeListInProgress[rightIndex]) {
                sortList[sortingIndex] = mergeListInProgress[leftIndex];
                leftIndex++;
            } else {
                sortList[sortingIndex] = mergeListInProgress[rightIndex];
                rightIndex++;
            }
            sortingIndex++;
        }

        while (leftIndex <= middle) {
            sortList[sortingIndex] = mergeListInProgress[leftIndex];
            sortingIndex++;
            leftIndex++;
        }

        while(rightIndex <= higherIndex){
            sortList[sortingIndex] = mergeListInProgress[rightIndex];
            sortingIndex++;
            rightIndex++;
        }

    }
}
