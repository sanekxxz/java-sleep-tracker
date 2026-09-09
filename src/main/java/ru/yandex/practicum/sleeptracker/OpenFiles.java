package ru.yandex.practicum.sleeptracker;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OpenFiles {
    private final Path sleepLog = Paths.get("sleep_log.txt");
    private List<SleepingSession> sleep = new ArrayList<>();

    public List<SleepingSession> getSleep() {
        return sleep;
    }

    public void openFile(final String fileName) {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {

            assert inputStream != null;

            try (BufferedReader bufferedReader = new BufferedReader(
                         new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                sleep = bufferedReader.lines()
                        .map(SleepingSession::new)
                        .collect(Collectors.toList());

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
