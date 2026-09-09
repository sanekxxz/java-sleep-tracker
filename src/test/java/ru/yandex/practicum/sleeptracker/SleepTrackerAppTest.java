package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

public class SleepTrackerAppTest {

    @Test
    public void sleepDurationFunctionThree() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:15;02.10.25 07:30;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 06:40;GOOD"),
                new SleepingSession("03.10.25 23:00;04.10.25 07:00;BAD")
        );

        SleepDurationFunction function = new SleepDurationFunction();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);

        Assertions.assertEquals("Количество сна ", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(3, sleepAnalysisResult.getValue());

    }

    @Test
    public void sleepDurationFunctionZero() {
        List<SleepingSession> sessions = new ArrayList<>();

        SleepDurationFunction function = new SleepDurationFunction();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);

        Assertions.assertEquals("Количество сна ", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(0, sleepAnalysisResult.getValue());

    }

    @Test
    public void minSessionDuration410Min() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:15;02.10.25 07:30;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 06:40;GOOD"),
                new SleepingSession("03.10.25 23:00;04.10.25 07:00;BAD")
        );

        MinSessionDuration function = new MinSessionDuration();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);

        Assertions.assertEquals("Минимальное время сна", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(410 + " мин.", sleepAnalysisResult.getValue());
    }

    @Test
    public void minSessionDuration90Min() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:15;02.10.25 07:30;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 06:40;GOOD"),
                new SleepingSession("10.10.25 13:00;10.10.25 14:30;NORMAL"),

                new SleepingSession("06.10.25 22:30;07.10.25 05:50;GOOD"),
                new SleepingSession("11.10.25 23:10;12.10.25 07:00;BAD"),
                new SleepingSession("03.10.25 23:00;04.10.25 07:00;BAD")
        );

        MinSessionDuration function = new MinSessionDuration();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);

        Assertions.assertEquals("Минимальное время сна", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(90 + " мин.", sleepAnalysisResult.getValue());
    }

    @Test
    public void maxSessionDuration495Max() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:15;02.10.25 07:30;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 06:40;GOOD"),
                new SleepingSession("03.10.25 23:00;04.10.25 07:00;BAD")
        );

        MaxSessionDuration function = new MaxSessionDuration();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);

        Assertions.assertEquals("Мах время сна", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(495 + " мин.", sleepAnalysisResult.getValue());
    }

    @Test
    public void maxSessionDuration660Max() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:15;02.10.25 07:30;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 06:40;GOOD"),
                new SleepingSession("10.10.25 13:00;10.10.25 14:30;NORMAL"),

                new SleepingSession("06.10.25 22:30;07.10.25 05:50;GOOD"),
                new SleepingSession("11.10.25 23:10;12.10.25 07:00;BAD"),
                new SleepingSession("03.10.25 20:00;04.10.25 07:00;BAD")
        );

        MaxSessionDuration function = new MaxSessionDuration();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);

        Assertions.assertEquals("Мах время сна", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(660 + " мин.", sleepAnalysisResult.getValue());
    }

    @Test
    public void averageSessionDuration427min() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:15;02.10.25 07:30;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 06:40;GOOD"),
                new SleepingSession("10.10.25 13:00;10.10.25 14:30;NORMAL"),

                new SleepingSession("06.10.25 22:30;07.10.25 05:50;GOOD"),
                new SleepingSession("11.10.25 23:10;12.10.25 07:00;BAD"),
                new SleepingSession("03.10.25 20:00;04.10.25 07:00;BAD")
        );

        AverageSessionDuration function = new AverageSessionDuration();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);
        Assertions.assertEquals("Среднее время сна: ", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(427 + " мин.", sleepAnalysisResult.getValue());
    }

    @Test
    public void averageSessionDuration0min() {
        List<SleepingSession> sessions = new ArrayList<>();

        AverageSessionDuration function = new AverageSessionDuration();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);
        Assertions.assertEquals("Среднее время сна: ", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(0 + " мин.", sleepAnalysisResult.getValue());
    }

    @Test
    public void countSessionSleepBadThree() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:15;02.10.25 07:30;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 06:40;GOOD"),
                new SleepingSession("10.10.25 13:00;10.10.25 14:30;NORMAL"),

                new SleepingSession("06.10.25 22:30;07.10.25 05:50;GOOD"),
                new SleepingSession("11.10.25 23:10;12.10.25 07:00;BAD"),
                new SleepingSession("03.10.25 20:00;04.10.25 07:00;BAD")
        );

        CountSessionSleep function = new CountSessionSleep();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);
        Assertions.assertEquals("Количество плохого сна ", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(3L, sleepAnalysisResult.getValue());
    }

    @Test
    public void countSessionSleepBadZero() {
        List<SleepingSession> sessions = new ArrayList<>();
        CountSessionSleep function = new CountSessionSleep();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);
        Assertions.assertEquals("Количество плохого сна ", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(0L, sleepAnalysisResult.getValue());
    }

    @Test
    public void sleeplessNightFive() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:15;02.10.25 07:30;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 06:40;GOOD"),
                new SleepingSession("10.10.25 13:00;10.10.25 14:30;NORMAL"),

                new SleepingSession("06.10.25 22:30;07.10.25 05:50;GOOD"),
                new SleepingSession("11.10.25 23:10;12.10.25 07:00;BAD"),
                new SleepingSession("03.10.25 20:00;04.10.25 07:00;BAD")
        );

        SleeplessNight function = new SleeplessNight();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);
        Assertions.assertEquals("Бессонных ночей ", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(5L, sleepAnalysisResult.getValue());
    }

    @Test
    public void sleeplessNightZero() {
        List<SleepingSession> sessions = new ArrayList<>();
        SleeplessNight function = new SleeplessNight();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);
        Assertions.assertEquals("Бессонных ночей ", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals(0L, sleepAnalysisResult.getValue());
    }

    @Test
    public void classifyUserPigeon() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:15;02.10.25 07:30;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 06:40;GOOD"),
                new SleepingSession("10.10.25 13:00;10.10.25 14:30;NORMAL"),

                new SleepingSession("06.10.25 22:30;07.10.25 05:50;GOOD"),
                new SleepingSession("11.10.25 23:10;12.10.25 07:00;BAD"),
                new SleepingSession("03.10.25 20:00;04.10.25 07:00;BAD")
        );

        ClassifyUser function = new ClassifyUser();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);
        Assertions.assertEquals("Вы относитесь к", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals("Голубь", sleepAnalysisResult.getValue().toString());
    }

    @Test
    public void classifyUserOwl() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 23:30;02.10.25 09:30;GOOD"),
                new SleepingSession("02.10.25 23:45;03.10.25 10:00;GOOD"),
                new SleepingSession("03.10.25 23:20;04.10.25 09:40;GOOD")
        );

        ClassifyUser function = new ClassifyUser();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);
        Assertions.assertEquals("Вы относитесь к", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals("Сова", sleepAnalysisResult.getValue().toString());
    }

    @Test
    public void classifyUserLark() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession("01.10.25 21:00;02.10.25 06:00;GOOD"),
                new SleepingSession("02.10.25 20:30;03.10.25 05:50;GOOD"),
                new SleepingSession("03.10.25 21:30;04.10.25 06:30;GOOD")
        );

        ClassifyUser function = new ClassifyUser();
        SleepAnalysisResult sleepAnalysisResult = function.apply(sessions);
        Assertions.assertEquals("Вы относитесь к", sleepAnalysisResult.getAnalysisResult());
        Assertions.assertEquals("Жаворонок", sleepAnalysisResult.getValue().toString());
    }
}