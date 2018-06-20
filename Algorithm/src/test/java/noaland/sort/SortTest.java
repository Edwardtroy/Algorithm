package noaland.sort;

import noaland.TestCases.TestCase;
import noaland.TestCases.TestCasesBuilder;
import org.junit.Test;

public class SortTest {
    private Integer[] expectedResult = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    private TestCase[] testCases = new TestCase[]{
            new TestCase<>(new Integer[]{5, 3, 4, 7, 2, 8, 6, 9, 1}, expectedResult, "test case 1"),
            new TestCase<>(new Integer[]{5, 4, 8, 7, 6, 9, 3, 2, 1}, expectedResult, "test case 2"),
            new TestCase<>(new Integer[]{4, 1, 6, 5, 7, 8, 2, 9, 3}, expectedResult, "test case 3"),
    };

    @Test
    public void insertionSortCanSortListFromSmallToBig() throws Exception{
        String testMethodName = "sort";

        new TestCasesBuilder()
                .Using(testCases)
                .Running(
                    InsertionSort.class, testMethodName, Integer[].class
                )
                .DoAssert();
    }

    @Test
    public void mergeSortCanSortListFromSmallToBig() throws Exception {
        String testMethodName = "sort";

         new TestCasesBuilder()
                .Using(testCases)
                .Running(
                    MergeSort.class, testMethodName, Integer[].class
                )
                .DoAssert();
    }
}