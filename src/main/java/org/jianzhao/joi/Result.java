package org.jianzhao.joi;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Result {

    private static final Result VALID = new Result(null);

    private String message;

    public static Result valid() {
        return VALID;
    }

    public static Result of(String message) {
        return new Result(message);
    }

    private Result(String message) {
        this.message = message;
    }

    public String message() {
        if (Objects.isNull(this.message)) {
            throw new NoSuchElementException("No error message");
        }
        return this.message;
    }

    public boolean isValid() {
        return Objects.isNull(this.message);
    }

    @Override
    public String toString() {
        return Objects.isNull(this.message)
                ? "Result: Valid"
                : String.format("Result: [%s]", this.message);
    }
}
