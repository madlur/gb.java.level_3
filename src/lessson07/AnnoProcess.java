package lessson07;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class AnnoProcess {
    public static void main(String[] args) {

        start(TestClass1.class);
        start(TestClass2.class);
    }

    static void start(Class<?> testClass) {
        Map<Integer, Method> map = new TreeMap<>();
        boolean beforesuitflag = false;
        boolean aftersuitflag = false;
        int MAX_PRIORITY = 0;
        if (!testClass.isAnnotationPresent(TestClass.class)) {
            throw new RuntimeException("This Class do not ready for tests");
        }

        Method[] methods = testClass.getDeclaredMethods();

        //        получаем максимальное значение prioroty для того, чтобы потом правильно воткнуть AfterSuite
        for (Method priority : methods) {
            if (priority.isAnnotationPresent(Test.class)) {
                priority.setAccessible(true);
                if (priority.getAnnotation(Test.class).priority() > MAX_PRIORITY) {
                    MAX_PRIORITY = priority.getAnnotation(Test.class).priority();
                }
            }
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuit.class)) {
                if (!beforesuitflag) {
                    method.setAccessible(true);
                    map.put(0, method);
                    beforesuitflag = true;
                } else {
                    throw new RuntimeException("Before  suite is already presents in test at class "
                            + testClass.getSimpleName());
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (!aftersuitflag) {
                    method.setAccessible(true);
                    map.put(MAX_PRIORITY, method);
                    aftersuitflag = true;
                } else {
                    throw new RuntimeException("After suite is already presents in test");
                }
            }
            if (method.isAnnotationPresent(Test.class)) {
                method.setAccessible(true);
                int testplace = method.getAnnotation(Test.class).priority();
                map.put(testplace, method);

            }

        }
        try {
            Object extract = testClass.newInstance();
            for (Integer value : map.keySet()) {
                map.get(value).invoke(extract);
            }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
