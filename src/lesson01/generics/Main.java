package lesson01.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        chageArr(string);
        chageArr(objects);
//        chageArr(arr);


        //Задание 3


    }

    public static <T extends Object> void changePlace(T[] items) {
        if (items.length == 1) System.out.println("Nothing to change");
        else {
            T temp = items[0];
            items[0] = items[1];
            items[1] = temp;
        }
    }

    public static <T> void chageArr(T[] items) {
        ArrayList<?> list = new ArrayList<>(Arrays.asList(items));
        System.out.println(list);

    }

}



