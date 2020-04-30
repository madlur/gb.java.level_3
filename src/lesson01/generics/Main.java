package lesson01.generics;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        //задание №1
        String[] string = {"str1", "str2", "str3", "str4", "str5"};
        Object[] objects = new Object[5];
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object();
        }
        changePlace(string);
        changePlace(objects);

        //Задание 2
//        changeArr(string);
//        changeArr(objects);

        //Задание 3
//    Apple apple = new Apple(1.5f);
//    Apple apple2 = new Apple(1.7f);
//    Apple apple3 = new Apple(2.3f);
//
//    Orange orange = new Orange(0.8f);
//    Orange orange2 = new Orange(3.3f);
//    Orange orange3 = new Orange(3.1f);
//
//    Box<Apple> box = new Box<>();
//    Box<Orange> box2 = new Box<>();
//    Box<Apple> box3 = new Box<>();
//
//    box.putInBox(apple);
//    box.putInBox(apple2);
//    box.putInBox(apple3);
//
//    box3.putInBox(apple);
//    box3.putInBox(apple2);
//    box3.putInBox(apple3);
//
//box.showBox();
//box2.putInBox(orange);
//box2.putInBox(orange2);
//box2.putInBox(orange3);
//box2.showBox();
//
//System.out.println(box.getWeight(box.getArrlist()));
//System.out.println(box2.getWeight(box2.getArrlist()));

//        System.out.println("Сравнение коробки " + box.getClass().getSimpleName() + " весом " +
//                box.getWeight(box.getArrlist()) + " и коробки " + box2.getClass().getSimpleName()+
//                " весом " + box.getWeight(box.getArrlist()) + " дает результат = " + box.compare(box2));
//
//box.add(box3.getArrlist());
//box.showBox();
//box3.showBox();
//box.showBox();
}

    public static <T> void changePlace(T[] items) {
        if (items.length == 1) System.out.println("Nothing to change");
        for (int i = 0; i <items.length ; i++) {
            if (i>=items.length-2) break;
            else{
                T temp = items[i];
                i++;
                items[i-1] = items[i];
                items[i] = temp;}
        }
    }
//код поправлен после просмотра разбора от преподавателя
    private <T> ArrayList<T> changeArr(T[] items) {
        return new ArrayList<>(Arrays.asList(items));
//        ArrayList<?> list = new ArrayList<>(Arrays.asList(items));
//        System.out.println(list);
    }

    }



