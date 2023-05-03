package net.zhongli.random;

/*
Create a map which takes in a <Object, Double> weight and returns a random object based on the weight.
 */
import java.util.*;

public class WeightedChooser<T> {
    private Map<T, Double> map;
    private Random random;

    public WeightedChooser() {
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public void add(T object, double weight) {
        this.map.put(object, weight);
    }

    public T choose() {
        double totalWeight = 0;
        for (double weight : this.map.values()) {
            totalWeight += weight;
        }

        double randomWeight = this.random.nextDouble() * totalWeight;
        double currentWeight = 0;
        for (Map.Entry<T, Double> entry : this.map.entrySet()) {
            currentWeight += entry.getValue();
            if (currentWeight >= randomWeight) {
                return entry.getKey();
            }
        }

        return null;
    }

}
