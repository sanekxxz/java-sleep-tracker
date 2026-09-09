package ru.yandex.practicum.sleeptracker;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.function.Function;

public class SleeplessNight implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {

        long nightSessions = sleepingSessions.stream()
                .filter(session -> {
                    LocalDateTime start = session.getLocalDateStart();
                    LocalDateTime end = session.getLocalDateEnd();

                    return !start.toLocalDate().equals(end.toLocalDate()) || (start.toLocalTime().isAfter(LocalTime.MIDNIGHT)
                            && end.toLocalTime().isBefore(LocalTime.of(6, 0)));
                })
                .count();
        return new SleepAnalysisResult("Бессонных ночей ", nightSessions);
    }
}
