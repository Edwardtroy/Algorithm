package noaland.TestCases;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

//TODO: Not urgent && not that important: Learn customize annotation and JUnit4 Parameterized.java and create a customized annotation for test
public class WAITING_TestCasesRunner extends Runner {
    private Class testClass;
    public WAITING_TestCasesRunner(Class testClass) {
        super();
        this.testClass = testClass;
    }

    @Override
    public Description getDescription() {
        return Description
                .createTestDescription(testClass, "My runner description");
    }

    @Override
    public void run(RunNotifier notifier) {
        System.out.println("running the tests from MyRunner: " + testClass);
        try {
            Object testObject = testClass.newInstance();
            for (Method method : testClass.getMethods()) {
                if (method.isAnnotationPresent(Test.class) && !method.isAnnotationPresent(UsingTestCases.class)) {
                    notifier.fireTestStarted(Description
                            .createTestDescription(testClass, method.getName()));
                    method.invoke(testObject);
                    notifier.fireTestFinished(Description
                            .createTestDescription(testClass, method.getName()));
                }

                if(method.isAnnotationPresent(Test.class) && method.isAnnotationPresent(UsingTestCases.class)){
                    System.out.println("test name: " + method.getAnnotation(UsingTestCases.class).name());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface TestCases{
        String name() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface UsingTestCases{
        String name() default "";
    }
}
