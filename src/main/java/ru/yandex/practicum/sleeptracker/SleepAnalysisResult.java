package ru.yandex.practicum.sleeptracker;

public class SleepAnalysisResult {

    private final String analysisResult;
    private final Object value;

    public SleepAnalysisResult(final String result, final Object value) {
        this.analysisResult = result;
        this.value = value;
    }

    public String getAnalysisResult() {
        return analysisResult;
    }

    public Object getValue() {
        return value;
    }
}
