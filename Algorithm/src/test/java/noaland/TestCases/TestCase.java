package noaland.TestCases;

public class TestCase<E>{
    Object[] input;
    E expected;
    String message;

    public TestCase(TestCaseInput input, E expected, String message){
        this.input = input.getInputs();
        this.expected = expected;
        this.message = message;
    }
}
