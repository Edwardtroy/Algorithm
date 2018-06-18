package noaland.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTest {
    private int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    private TestCases[] testCases = new TestCases[]{
            new TestCases(new int[]{5, 3, 4, 7, 2, 8, 6, 9, 1}, expectedResult, "test case 1"),
            new TestCases(new int[]{5, 4, 8, 7, 6, 9, 3, 2, 1}, expectedResult, "test case 2"),
            new TestCases(new int[]{5, 4, 8, 7, 6, 9, 3, 2, 1}, expectedResult, "test case 3"),
    };

    @Test
    public void insertionSortCanSortListFromSmallToBig(){
        InsertionSort insertionSort = new InsertionSort();

        for(TestCases testCase : testCases){
            assertArrayEquals(testCase.message, testCase.expected, insertionSort.sort(testCase.input));
        }
    }
}

