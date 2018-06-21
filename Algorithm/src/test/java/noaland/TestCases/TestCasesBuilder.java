package noaland.TestCases;

import static java.lang.reflect.Array.newInstance;

public class TestCasesBuilder <T> {
    public TestCasesRunner <T> using(TestCase[] testCases){
        T[] outputs = (T[])newInstance(testCases[0].expected.getClass(), testCases.length);

        return new TestCasesRunner<>(testCases, outputs);
    }
}