package noaland.TestCases;

public class TestCase<T, E>{
    T[] input;
//    Object[] input;
    E expected;
    String message;

    public TestCase(T[] input, E expected, String message){
        this.input = input;
        this.expected = expected;
        this.message = message;
    }

//    public TestCase(TestCaseInput input, E expected, String message){
//        this.input = input.getInputs();
//        this.expected = expected;
//        this.message = message;
//    }
}
