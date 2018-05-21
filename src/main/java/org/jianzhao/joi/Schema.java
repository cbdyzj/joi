package org.jianzhao.joi;

import java.util.Objects;

@FunctionalInterface
public interface Schema<T> {

    Result validate(T target);

    default Schema<T> compose(Schema<T> after) {
        return target -> {
            Result rb = this.validate(target);
            return rb.isInvalid() ? rb : after.validate(target);
        };
    }

    default Schema<T> invert(String message) {
        Objects.requireNonNull(message, "Message require NonNull!");
        return target -> this.validate(target).isInvalid() ? Result.valid() : Result.of(message);
    }

}
