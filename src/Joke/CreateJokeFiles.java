package Joke;

import java.nio.file.*;
import java.io.IOException;

public class CreateJokeFiles {

    public static void main(String[] args) {
        Path path = Paths.get("D:\\1\\2\\3\\4");
        recursiveFolderTraverse(path);
    }

    private static void recursiveFolderTraverse(Path path) {
        if (path == null) {
            return;
        }
        createJokeJavaFile(path);
        path = path.getParent();
        if (path != null && !path.equals(path.getRoot())) {
            recursiveFolderTraverse(path);
        }
    }

    private static void createJokeJavaFile(Path folder) {
        Path jokeFilePath = folder.resolve("joke.java"); // Создаем путь к файлу joke.java
        String jokeCode = "public class joke {\n" +
                "	public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello, World!\");\n" +
                "    }\n" +
                "}\n";
        try {
            if (!Files.exists(folder)) {
                Files.createDirectories(folder);
            }
            Files.write(jokeFilePath, jokeCode.getBytes());
            System.out.println("Создан: " + jokeFilePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}