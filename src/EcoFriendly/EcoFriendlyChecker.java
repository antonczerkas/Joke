package EcoFriendly;

import java.util.ArrayList;
import java.util.List;

public class EcoFriendlyChecker implements ConsumptionChecker {
    private int consumption;

    public EcoFriendlyChecker(int consumption) {
        this.consumption = consumption;
    }

    public List<Consumer> check(List<Consumer> consumers) {
        List<Consumer> ecoConsumers = new ArrayList<>();
        for (Consumer consumer : consumers) {
            if ((consumer.getWaterCountDay() + consumer.getWaterCountNight()) < consumption &&
                    (consumer.getElectroCountDay() + consumer.getElectroCountNight()) < consumption &&
                    (consumer.getGasCount()) < consumption) {
                ecoConsumers.add(consumer);
            }
        }
        return ecoConsumers;
    }
}