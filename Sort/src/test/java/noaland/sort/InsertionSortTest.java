package noaland.sort;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {
    private TestCases[] testCases = new TestCases[]{
            new TestCases(new int[]{5, 3, 4, 7, 2, 8, 6, 9, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, "test case 1"),
            new TestCases(new int[]{5, 4, 8, 7, 6, 9, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, "test case 2"),
    };

    @Test
    public void canSortSuccessfullyForAList(){
        InsertionSort insertionSort = new InsertionSort();

        for(TestCases testCase : testCases){
            Assert.assertArrayEquals(testCase.message, testCase.expected, insertionSort.sort(testCase.input));
        }
    }
}

