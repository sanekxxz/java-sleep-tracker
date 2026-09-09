package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class CountSessionSleep implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        long count = sleepingSessions.stream()
                .filter(session -> session.getAnalysis() == Analysis.BAD)
                .count();
        return new SleepAnalysisResult("Количество плохого сна ", count);
    }
}
