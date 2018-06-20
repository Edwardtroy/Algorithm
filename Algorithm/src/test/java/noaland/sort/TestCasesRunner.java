package noaland.sort;


import java.lang.reflect.Method;

import static org.junit.Assert.assertArrayEquals;

class TestCasesRunner {
    private final TestCase[] testCasesInUse;
    private final Object[] outputs;

    TestCasesRunner(TestCase[] testCasesInUse, Object[] outputs) {
        this.testCasesInUse = testCasesInUse;
        this.outputs = outputs;
    }

    TestCasesRunner Running(Class<?> testClass, String methodName, Class<?>... parameterTypes) throws Exception{
        Method method = testClass.getDeclaredMethod(methodName, parameterTypes);
        runMethodAndSetOutput(testClass, method);

        return this;
    }

    void DoAssert(){
        for(int i = 0; i < outputs.length; i++){
            TestCase testCase = testCasesInUse[i];
            assertArrayEquals(testCase.message, testCase.expected, testCase.expected.getClass().cast(outputs[i]));
        }
    }

    private void runMethodAndSetOutput(Class<?> testClass, Method method) throws Exception{
        for(int i = 0; i < testCasesInUse.length; i++){
            Object input = testCasesInUse[i].input;
            outputs[i] = method.invoke(testClass.newInstance(), input);
        }
    }
}