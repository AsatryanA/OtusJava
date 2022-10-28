import org.example.TestRunner;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        TestRunner testRunner = new TestRunner(MyArrayTest.class);
    }
}
