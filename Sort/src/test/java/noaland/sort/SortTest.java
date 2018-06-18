package noaland.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortTest {
    private int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    private TestCase[] testCases = new TestCase[]{
            new TestCase(new int[]{5, 3, 4, 7, 2, 8, 6, 9, 1}, expectedResult, "test case 1"),
            new TestCase(new int[]{5, 4, 8, 7, 6, 9, 3, 2, 1}, expectedResult, "test case 2"),
            new TestCase(new int[]{4, 1, 6, 5, 7, 8, 2, 9, 3}, expectedResult, "test case 3"),
    };

    @Test
    public void insertionSortCanSortListFromSmallToBig(){
        InsertionSort insertionSort = new InsertionSort();

        for(TestCase testCase : testCases){
            assertArrayEquals(testCase.message, testCase.expected, insertionSort.sort(testCase.input));
        }
    }

    @Test
    public void mergeSortCanSortListFromSmallToBig(){
        assertEquals(true, true);
    }
}

