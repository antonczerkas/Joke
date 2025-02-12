package EcoFriendly;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class WriteFileCsv implements FileWriter {
    private Path path;

    public WriteFileCsv(Path path) {
        this.path = path;
    }

    @Override
    public void write(List<Consumer> consumers) {
        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(String.valueOf(path)))) {
            bw.write("id|name|waterCountDay|waterCountNight|gasCount|electroCountDay|electroCountNight\n");
            for (Consumer consumer : consumers) {
                bw.write(consumer.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл:" + e.getMessage());
        }
    }
}