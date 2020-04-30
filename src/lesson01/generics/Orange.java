package lesson01.generics;

public class Orange extends Fruit implements Comparable {
    float weight = 1.5f;

    @Override
    public float getWeight() {
        return weight;
    }

    public Orange(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                "type=" + getClass().getSimpleName() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
