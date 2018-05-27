package org.jianzhao.joi;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Result {

    private boolean valid = true;

    private final Set<String> messages = new HashSet<>();

    public static Result valid() {
        return new Result();
    }

    public static Result invalid() {
        Result result = new Result();
        result.valid = false;
        return result;
    }

    public static Result of(String message) {
        Result result = Result.invalid();
        result.messages.add(message);
        return result;
    }

    public static Result of(Set<String> messages) {
        Result result = Result.invalid();
        result.messages.addAll(messages);
        return result;
    }

    private Result() {
    }

    public Set<String> getMessages() {
        return this.messages;
    }

    public boolean isValid() {
        return this.valid;
    }

    public boolean isInvalid() {
        return !this.isValid();
    }

    public void assertValid() {
        if (this.isInvalid()) {
            throw new IllegalArgumentException(String.valueOf(this.getMessages()));
        }
    }

    public <E extends Exception> void assertValid(Function<String, E> f) throws E {
        if (this.isInvalid()) {
            throw f.apply(String.valueOf(this.getMessages()));
        }
    }

}
