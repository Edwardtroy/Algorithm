package noaland.sort;

public class InsertionSort {
    public int[] sort(int[] sortList) {
        for(int unsortIndex = 1; unsortIndex < sortList.length; unsortIndex++){
            int valueWaitToSort = sortList[unsortIndex];

            for(int sortedIndex = unsortIndex - 1; sortedIndex >= 0; sortedIndex--){
                boolean shouldChangePosition = valueWaitToSort < sortList[sortedIndex];

                if(shouldChangePosition){
                    sortList[sortedIndex + 1] = sortList[sortedIndex];
                    sortList[sortedIndex] = valueWaitToSort;
                }
            }
        }

        return sortList;
    }

}
