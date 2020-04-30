package lesson01.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <A extends Fruit> {

//                      ******** teacher`s realization  ********

    private ArrayList<A> fruits;

    public Box(A... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));

    }

    public Box() {
        this.fruits = new ArrayList<>();
    }

    private void addFruit(A fruit) {
        this.fruits.add(fruit);
    }

    private float getWeight(){
        float sum = 0f;
        for (A fruits : fruits) {
            sum += fruits.getWeight();
        }
        return sum;
    }

    private boolean compare (Box another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.00001;
    }
        private void moveTo (Box<A> another) {
            if (another != null) {
                System.out.println("Another box is null");
            }
            if (another.fruits.isEmpty()) {
                System.out.println("Another box is empty");
            }
            if (this.equals(another)) {
                System.out.println("Another box is equals to current");
            }
           this.fruits.addAll(another.fruits);
            another.fruits.clear();
        }

    }

    /*
    public Box(ArrayList<A> arrlist) {
        this.arrlist = arrlist;
    }



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

    //добавлено в параметры метода <?> вместо просто (Box o) после просмотра видео с разбором ДЗ
    public float compare(Box<?> o) {
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

*/

