package org.example;

import org.example.annotation.After;
import org.example.annotation.Before;
import org.example.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestRunner {

    public TestRunner(Class<?> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        launch(clazz);
    }

    private void launch(Class<?> classTest) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int success = 0;
        int failed = 0;
        int count = 0;
        List<Method> beforeMethods;
        List<Method> afterMethods;
        Method[] methods = classTest.getDeclaredMethods();
        beforeMethods = Arrays.stream(methods).filter(method -> method.isAnnotationPresent(Before.class)).peek(method -> method.setAccessible(true)).collect(Collectors.toList());
        afterMethods = Arrays.stream(methods).filter(method -> method.isAnnotationPresent(After.class)).peek(method -> method.setAccessible(true)).collect(Collectors.toList());
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                method.setAccessible(true);
                count++;
                Object obj = classTest.getDeclaredConstructor().newInstance();
                for (Method beforeMethod : beforeMethods) {

                    beforeMethod.invoke(obj);
                }
                try {
                    method.invoke(obj);
                    System.out.printf("Test %s is succeeded %n", count);
                    success++;
                } catch (RuntimeException e) {
                    failed++;
                    System.out.printf("Test %s is failed %n", count);
                }
                for (Method afterMethod : afterMethods) {
                    afterMethod.invoke(obj);
                }
            }
        }
        System.out.printf("Test %s / %s succeeded %n", count, success);
        System.out.printf("Test %s / %s failed", count, failed);
    }
}
