package lesson01.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<A extends Fruit> implements Comparable<Box> {

    private ArrayList<A> arrlist = new ArrayList<>();

    public void putInBox(A obj) {
        arrlist.add(obj);
    }


    public float getWeight(ArrayList<? extends Fruit> elements) {
        float result = 0f;
        for (Fruit fruit : elements) {
            result += fruit.getWeight();
        }

        return result;
    }

    public void showBox() {
        System.out.println(Arrays.toString(arrlist.toArray()));

    }

    public ArrayList<A> getArrlist() {
        return arrlist;
    }

    public float compare(Box o) {
        return (this.getWeight(this.getArrlist()) - o.getWeight(o.getArrlist()));
    }

    public void add(ArrayList<A> elements) {
        for (A list : elements) {
            this.arrlist.add(list);
        }
        elements.clear();

    }


    @Override
    public int compareTo(Box o) {
        return 0;
    }


}
