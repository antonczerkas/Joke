package module5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EcoFriendlyUsers {

    private static String firstLine;

    public static void main(String[] args) {
        String filePath = ("D:\\data.csv");
        int maxConsumption = 100;

        List<String> ecoFriendlyUsers = processFile(filePath, maxConsumption);
        writeEcoFriendlyUsersToFile(filePath, ecoFriendlyUsers, firstLine);
    }

    private static List<String> processFile(String filePath, int maxConsumption) {
        List<String> ecoFriendlyUsers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            firstLine = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split("\\|");
                if (isEcoFriendlyUser(userData, maxConsumption)) {
                    ecoFriendlyUsers.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла:" + e.getMessage());
        }
        return ecoFriendlyUsers;
    }

    private static boolean isEcoFriendlyUser(String[] values, int maxConsumption) {
        for (int i = 2; i < values.length; i++) {
            int consumption = Integer.parseInt(values[i]);
            if (consumption >= maxConsumption) {
                return false;
            }
        }
        return true;
    }

    private static void writeEcoFriendlyUsersToFile(String filePath, List<String> ecoFriendlyUsers, String firstLine) {
        String outputFilePath = filePath.replace(".csv", "_eco.csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            bw.write(firstLine+ "\n");
            for (String user : ecoFriendlyUsers) {
                bw.write(user + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл:" + e.getMessage());
        }
    }
}