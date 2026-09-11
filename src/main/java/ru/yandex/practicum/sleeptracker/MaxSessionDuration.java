package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MaxSessionDuration implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        long maxDuration = sleepingSessions.stream()
                .mapToLong(session -> Duration.between(session.getLocalDateStart(), session.getLocalDateEnd()).toMinutes())
                .max()
                .orElse(0);
        return new SleepAnalysisResult("Мах время сна", maxDuration + " мин.");
    }
}
