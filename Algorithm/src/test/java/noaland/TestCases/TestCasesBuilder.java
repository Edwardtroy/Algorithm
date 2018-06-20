package noaland.TestCases;

public class TestCasesBuilder {
    public TestCasesRunner Using(TestCase[] testCases) {
        Object[] outputs;
        outputs = new Object[testCases.length];

        return new TestCasesRunner(testCases, outputs);
    }
}