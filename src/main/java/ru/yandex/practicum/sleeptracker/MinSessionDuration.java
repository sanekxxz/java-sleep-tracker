package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MinSessionDuration implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        long minDuration = sleepingSessions.stream()
                .mapToLong(session -> Duration.between(session.getLocalDateStart(), session.getLocalDateEnd()).toMinutes())
                .min()
                .orElse(0);
        return new SleepAnalysisResult("Минимальное время сна", + minDuration + " мин.");
    }
}
