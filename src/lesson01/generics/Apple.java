package lesson01.generics;

public class Apple extends Fruit implements Comparable {
    float weight = 1f;

    public Apple(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                "type=" + getClass().getSimpleName() +
                '}';
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
