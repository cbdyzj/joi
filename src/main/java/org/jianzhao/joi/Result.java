package org.jianzhao.joi;

import java.util.Objects;
import java.util.function.Supplier;

public class Result {

    private static final Result VALID = Result.of(null);

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
        return this.message;
    }

    public boolean isValid() {
        return Objects.isNull(this.message);
    }

    public void assertValid() {
        if (!this.isValid()) {
            throw new RuntimeException(this.message);
        }
    }

    public <E extends Exception> void assertValid(Supplier<E> es) throws E {
        if (!this.isValid()) {
            throw es.get();
        }
    }

    @Override
    public String toString() {
        return Objects.isNull(this.message)
                ? "Result: Valid"
                : String.format("Result: [%s]", this.message);
    }
}
