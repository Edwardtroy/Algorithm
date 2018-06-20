package noaland.sort;

class TestCasesBuilder {
    TestCasesRunner Using(TestCase[] testCases) {
        Object[] outputs;
        outputs = new Object[testCases.length];

        return new TestCasesRunner(testCases, outputs);
    }
}