package lessson07;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class AnnoProcess {
    public static void main(String[] args) {

        start(TestClass1.class);
        start(TestClass2.class);
    }

    static void start(Class<?> testClass) {
        Map<Integer, List<Method>> map = new TreeMap<>(Collections.reverseOrder());
        boolean beforesuitflag = false;
        boolean aftersuitflag = false;
        int BEFORE_SUIT_PLACE = 0;
        int DEFAULT_ELEMENT=0;

        if (!testClass.isAnnotationPresent(TestClass.class)) {
            throw new RuntimeException("This Class do not ready for tests");
        }

        Method[] methods = testClass.getDeclaredMethods();

        //        получаем максимальное значение priority для того, чтобы потом правильно воткнуть BeforeSuite
        //        из-за того, что мапа перевернута, первая аннотация BEFORE_SUIT_PLACE является последним значением мапы
        for (Method priority : methods) {
            if (priority.isAnnotationPresent(Test.class)) {
                priority.setAccessible(true);
                if (priority.getAnnotation(Test.class).priority() > BEFORE_SUIT_PLACE) {
                    BEFORE_SUIT_PLACE = priority.getAnnotation(Test.class).priority();
                }
            }
        }

        for (Method method : methods) {
//            если находим BeforeSuit вставляем его в нулевой элемент мапы
            if (method.isAnnotationPresent(BeforeSuit.class)) {
                if (!beforesuitflag) {
                    method.setAccessible(true);
                    List <Method> list  = new ArrayList<>();
                    list.add(method);
                    map.put(BEFORE_SUIT_PLACE, list);
                    beforesuitflag = true;
                } else {
                    throw new RuntimeException("Before  suite is already presents in test at class "
                            + testClass.getSimpleName());
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (!aftersuitflag) {
                    method.setAccessible(true);
                    List <Method> list  = new ArrayList<>();
                    list.add(method);
//                    вставляем AfterSuite дефолтным элементом (DEFAULT_ELEMENT = 0. помни про reversed map
                    map.put(DEFAULT_ELEMENT, list);
                    aftersuitflag = true;
                } else {
                    throw new RuntimeException("After suite is already presents in test");
                }
            }
            if(method.isAnnotationPresent(Test.class)) {
                method.setAccessible(true);
                method.getAnnotation(Test.class).priority();
                int value = method.getAnnotation(Test.class).priority();
                if(!map.containsKey(value)) {
                    List <Method> list  = new ArrayList<>();
                    list.add(method);
                    map.put(value, list);
                       } else {
                    map.get(value).add(method);
                }
            }
        }

        try {
            Object extract = testClass.newInstance();
            for (Integer value : map.keySet()) {
                for (int i = 0; i <map.get(value).size() ; i++) {
                    map.get(value).get(i).invoke(extract);
                }
                       }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}