package noaland.TestCases;

public class TestCase<T>{
    T input;
    T expected;
    String message;

    public TestCase(T input, T expected, String message){
        this.input = input;
        this.expected = expected;
        this.message = message;
    }
}
