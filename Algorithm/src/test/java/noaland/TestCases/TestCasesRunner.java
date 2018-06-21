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

    public TestCasesRunner running(Class<?> testClass, String methodName, Class<?>... parameterTypeList) throws Exception{
        Object[] input = testCasesInUse[0].input;
        Class<?>[] parameterTypes = new Class[input.length];

        if(parameterTypeList.length > 0){
            parameterTypes = parameterTypeList;
        }else{
            for(int i = 0; i < input.length; i++){
                parameterTypes[i] = input[i].getClass();
            }
        }

        Method method = testClass.getDeclaredMethod(methodName, (Class[]) parameterTypes);
        runMethodAndSetOutput(testClass, method);

        return this;
    }

    //TODO: assertArrayEquals need to be change to another way.
    public void doAssert(){
        for(int i = 0; i < outputs.length; i++){
            TestCase testCase = testCasesInUse[i];
            assertArrayEquals(testCase.message, new Object[]{testCase.expected}, new Object[]{testCase.expected.getClass().cast(outputs[i])});
        }
    }

    private void runMethodAndSetOutput(Class<?> testClass, Method method) throws Exception{
        for(int i = 0; i < testCasesInUse.length; i++){
            Object[] input = testCasesInUse[i].input;
            outputs[i] = (T) method.invoke(testClass.newInstance(), input);
        }
    }
}