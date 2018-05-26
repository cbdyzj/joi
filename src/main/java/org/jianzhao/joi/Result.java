package org.jianzhao.joi;

import java.util.function.Function;

public class Result {

    private static final Result VALID = Result.of(null);
    private static final Result INVALID = Result.of("Invalid!");

    private String message;

    public static Result valid() {
        return Result.VALID;
    }

    public static Result invalid() {
        return Result.INVALID;
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
        return null == this.message;
    }

    public boolean isInvalid() {
        return !this.isValid();
    }

    public void assertValid() {
        if (this.isInvalid()) {
            throw new IllegalArgumentException(this.message);
        }
    }

    public <E extends Exception> void assertValid(Function<String, E> f) throws E {
        if (this.isInvalid()) {
            throw f.apply(this.message);
        }
    }

    @Override
    public String toString() {
        return null == this.message
                ? "Result: Valid"
                : String.format("Result: [%s]", this.message);
    }
}
