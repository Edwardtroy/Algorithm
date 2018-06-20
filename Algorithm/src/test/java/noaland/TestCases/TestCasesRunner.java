package noaland.TestCases;


import java.lang.reflect.Method;

import static org.junit.Assert.assertArrayEquals;

public class TestCasesRunner<T> {
    private final TestCase[] testCasesInUse;
    private final T[] outputs;

    TestCasesRunner(TestCase[] testCasesInUse, T[] outputs) {
        this.testCasesInUse = testCasesInUse;
        this.outputs = outputs;
    }

    public TestCasesRunner Running(Class<?> testClass, String methodName, Class<?>... parameterTypes) throws Exception{
        Method method = testClass.getDeclaredMethod(methodName, parameterTypes);
        runMethodAndSetOutput(testClass, method);

        return this;
    }

    //TODO: assertArrayEquals need to be change to another way.
    public void DoAssert(){
        for(int i = 0; i < outputs.length; i++){
            TestCase testCase = testCasesInUse[i];
            assertArrayEquals(testCase.message, new Object[]{testCase.expected}, new Object[]{testCase.expected.getClass().cast(outputs[i])});
        }
    }

    private void runMethodAndSetOutput(Class<?> testClass, Method method) throws Exception{
        for(int i = 0; i < testCasesInUse.length; i++){
            Object input = testCasesInUse[i].input;
            outputs[i] = (T) method.invoke(testClass.newInstance(), input);
        }
    }
}