package com.op._misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LargeFileSplitLogic {

    public static void splitTextFiles(Path bigFile, int maxRows) throws IOException {
        int i = 1;
        try (BufferedReader reader = Files.newBufferedReader(bigFile, StandardCharsets.UTF_8)) {
            String line = null;
            int lineNum = 1;

            Path splitFile = Paths.get(i + "split.txt");
            BufferedWriter writer = Files.newBufferedWriter(splitFile, StandardCharsets.UTF_8, StandardOpenOption.CREATE);

            while ((line = reader.readLine()) != null) {

                if (lineNum > maxRows) {
                    writer.close();
                    lineNum = 1;
                    i++;
                    splitFile = Paths.get(i + "split.txt");
                    writer = Files.newBufferedWriter(splitFile, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
                }

                writer.append(line);
                writer.newLine();
                lineNum++;
            }

            writer.close();
        }
    }

}
