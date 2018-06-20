package noaland.TestCases;

import static java.lang.reflect.Array.newInstance;

public class TestCasesBuilder <T> {
    public TestCasesRunner <T> Using(TestCase[] testCases){
//        noinspection unchecked
        T[] outputs = (T[])newInstance(testCases[0].expected.getClass(), testCases.length);

        return new TestCasesRunner<>(testCases, outputs);
    }
}