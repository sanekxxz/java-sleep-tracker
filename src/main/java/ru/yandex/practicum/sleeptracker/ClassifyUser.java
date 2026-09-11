package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClassifyUser implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        return new SleepAnalysisResult("Вы относитесь к", determineUserChronotype(sleepingSessions));
    }



    private Chronotype determineChronotype(SleepingSession session) {
        LocalTime start = session.getLocalDateStart().toLocalTime();
        LocalTime end = session.getLocalDateEnd().toLocalTime();

        if (start.isAfter(LocalTime.of(23, 0))
                && end.isAfter(LocalTime.of(9, 0))) {
            return Chronotype.OWL;
        }

        if (start.isBefore(LocalTime.of(22, 0))
                && end.isBefore(LocalTime.of(7, 0))) {
            return Chronotype.LARK;
        }

        return Chronotype.PIGEON;
    }

    public Chronotype determineUserChronotype(List<SleepingSession> sessions) {

        int owls = 0;
        int larks = 0;
        int pigeons = 0;

        Map<Chronotype, Long> counts = sessions.stream()
                .filter(this::isNightSleep)
                .map(this::determineChronotype)
                .collect(Collectors.groupingBy(
                        chronotype -> chronotype,
                        Collectors.counting()
                ));

        owls = counts.getOrDefault(Chronotype.OWL, 0L).intValue();
        larks = counts.getOrDefault(Chronotype.LARK, 0L).intValue();
        pigeons = counts.getOrDefault(Chronotype.PIGEON, 0L).intValue();

        if (owls > larks && owls > pigeons) {
            return Chronotype.OWL;
        }

        if (larks > owls && larks > pigeons) {
            return Chronotype.LARK;
        }

        return Chronotype.PIGEON;
    }

    private boolean isNightSleep(SleepingSession session) {
        LocalDateTime start = session.getLocalDateStart();
        LocalDateTime end = session.getLocalDateEnd();

        return !start.toLocalDate().equals(end.toLocalDate())
                || start.toLocalTime().isBefore(LocalTime.of(6, 0));
    }
}
