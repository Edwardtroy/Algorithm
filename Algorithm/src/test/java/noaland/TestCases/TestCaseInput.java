package noaland.TestCases;

public class TestCaseInput{
    private Object[] inputs;

    //TODO: Need to figure out how to solve array problem. array will enter one by one, because of using Object...
    public TestCaseInput(Object... inputs){
        this.inputs = inputs;
    }

    public Object[] getInputs() {
        return inputs;
    }
}
