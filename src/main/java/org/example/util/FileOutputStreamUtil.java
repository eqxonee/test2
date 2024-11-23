package org.example.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamUtil {

    public static void fileOutputStream(String logMessage) {

        File file = new File("/Users/airm1/IdeaProjects/test2/src/main/resources/log.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)) {
            fileOutputStream.write((logMessage).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
