package org.example;

public final class Result<T> {
    private final boolean ok;
    private final T value;
    private final String userMessage;
    private final String technicalMessage;

    private Result(boolean ok, T value, String userMessage, String technicalMessage) {
        this.ok = ok;
        this.value = value;
        this.userMessage = userMessage;
        this.technicalMessage = technicalMessage;
    }

    public static <T> Result<T> ok(T value) {
        return new Result<T>(true, value, null, null);
    }

    public static <T> Result<T> fail(String userMessage, String technicalMessage) {
        return new Result<T>(false, null, userMessage, technicalMessage);
    }

    public boolean isOk() {
        return ok;
    }

    public T getValue() {
        return value;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }
}
