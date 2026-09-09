package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SleepingSession {

    private final Analysis analysis;

    private final LocalDateTime localDateStart;
    private final LocalDateTime localDateEnd;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");


    public SleepingSession(final String line) {
        String[] data = line.split(";");

        localDateStart = LocalDateTime.parse(data[0],dateTimeFormatter);
        localDateEnd = LocalDateTime.parse(data[1], dateTimeFormatter);
        this.analysis = Analysis.valueOf(data[2]);
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public LocalDateTime getLocalDateEnd() {
        return localDateEnd;
    }

    public LocalDateTime getLocalDateStart() {
        return localDateStart;
    }
}
