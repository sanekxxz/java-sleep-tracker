package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class AverageSessionDuration implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        double averageDuration = sleepingSessions.stream()
                .mapToLong(session -> Duration.between(session.getLocalDateStart(), session.getLocalDateEnd()).toMinutes())
                .average()
                .orElse(0);
        return new SleepAnalysisResult("Среднее время сна: ",  (int) averageDuration + " мин.");

    }
}
