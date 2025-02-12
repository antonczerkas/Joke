package EcoFriendly;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EcoFriendlyUsers {

    public static void main(String[] args) {
        Path path = Paths.get("D:\\data.csv");
        FileReader readFileCsv = new ReadFileCsv(path);
        List<Consumer> allConsumers = readFileCsv.read();

        ConsumptionChecker ecoFriendlyChecker = new ConsumptionChecker(400);
        List<Consumer> ecoConsumers = ecoFriendlyChecker.ecoConsumers(allConsumers);

        Path pathEco = path.getParent().resolve("data_eco.csv");
        FileWriter writeFileCsv = new WriteFileCsv(pathEco);
        writeFileCsv.write(ecoConsumers);
    }
}