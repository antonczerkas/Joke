package EcoFriendly;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCsv implements FileReader {
    private Path path;

    public ReadFileCsv(Path path) {
        this.path = path;
    }

    @Override
    public List<Consumer> read() {
        List<Consumer> consumers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(String.valueOf(path)))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Consumer consumer = getConsumer(line);
                consumers.add(consumer);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла:" + e.getMessage());
        }
        return consumers;
    }

    private Consumer getConsumer(String line) {
        String[] consumerDataArray = line.split("\\|");
        Consumer consumer = new Consumer();
        consumer.setId(Integer.parseInt(consumerDataArray[0]));
        consumer.setName(consumerDataArray[1]);
        consumer.setWaterCountDay(Integer.parseInt(consumerDataArray[2]));
        consumer.setWaterCountNight(Integer.parseInt(consumerDataArray[3]));
        consumer.setGasCount(Integer.parseInt(consumerDataArray[4]));
        consumer.setElectroCountDay(Integer.parseInt(consumerDataArray[5]));
        consumer.setElectroCountNight(Integer.parseInt(consumerDataArray[6]));
        return consumer;
    }
}