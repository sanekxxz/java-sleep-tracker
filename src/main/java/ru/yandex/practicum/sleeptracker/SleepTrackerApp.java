package ru.yandex.practicum.sleeptracker;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SleepTrackerApp {

    public static void main(String[] args) {


        OpenFiles openAndCreateFiles = new OpenFiles();
        openAndCreateFiles.openFile("sleep_log.txt");
        List<SleepingSession> sleepingSessions = new ArrayList<>(openAndCreateFiles.getSleep());

        List<Function<List<SleepingSession>, SleepAnalysisResult>> functions = List.of(
                new SleepDurationFunction(),
                new MinSessionDuration(),
                new MaxSessionDuration(),
                new AverageSessionDuration(),
                new CountSessionSleep(),
                new SleeplessNight(),
                new ClassifyUser()
        );


        functions.stream()
                .map(function -> function.apply(sleepingSessions))
                .forEach(result -> System.out.println(result.getAnalysisResult() + ": " + result.getValue()));

    }
}