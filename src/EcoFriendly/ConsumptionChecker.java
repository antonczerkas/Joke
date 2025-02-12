package EcoFriendly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsumptionChecker {
    private int consumption;

    public ConsumptionChecker(int consumption) {
        this.consumption = consumption;
    }

    public List<Consumer> ecoConsumers(List<Consumer> consumers) {
        List<Consumer> ecoConsumers = new ArrayList<>();
        for (Consumer consumer : consumers) {
            if (consumer.getWaterCountDay() + consumer.getWaterCountNight() < consumption &&
                    consumer.getElectroCountDay() + consumer.getElectroCountNight() < consumption &&
                    consumer.getGasCount() < consumption) {
                ecoConsumers.add(consumer);
            }
        }
        return ecoConsumers;
    }
}