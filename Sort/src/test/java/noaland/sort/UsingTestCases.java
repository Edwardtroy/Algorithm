package noaland.sort;

import java.lang.reflect.Method;

import static org.junit.Assert.assertArrayEquals;

class UsingTestCases {
    private static TestCase[] testCasesInUse;
    private Object[] outputs;

    UsingTestCases Using(TestCase[] testCases) {
        testCasesInUse = testCases;
        outputs = new Object[testCasesInUse.length];

        return this;
    }

    UsingTestCases Running(Class<?> testClass, String methodName, Class<?>... parameterTypes) throws Exception{
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
