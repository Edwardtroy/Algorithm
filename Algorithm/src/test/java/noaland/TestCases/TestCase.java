package noaland.TestCases;

public class TestCase{
    int[] input;
    int[] expected;
    String message;

    public TestCase(int[] input, int[] expected, String message){
        this.input = input;
        this.expected = expected;
        this.message = message;
    }
}
