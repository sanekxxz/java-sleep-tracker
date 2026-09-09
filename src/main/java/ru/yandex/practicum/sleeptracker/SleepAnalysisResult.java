package ru.yandex.practicum.sleeptracker;

public class SleepAnalysisResult {

    private final String AnalysisResult;
    private final Object value;

    public SleepAnalysisResult(final String result, final Object value) {
        this.AnalysisResult = result;
        this.value = value;
    }

    public String getAnalysisResult() {
        return AnalysisResult;
    }

    public Object getValue() {
        return value;
    }
}
