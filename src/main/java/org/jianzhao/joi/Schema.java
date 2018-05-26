package org.jianzhao.joi;

@FunctionalInterface
public interface Schema<T> {

    Result validate(T target);

    default Schema<T> compose(Schema<T> after) {
        return target -> {
            Result rb = this.validate(target);
            return rb.isValid() ? after.validate(target) : rb;
        };
    }

    default Schema<T> message(String message) {
        return target -> this.validate(target).isValid() ? Result.valid() : Result.of(message);
    }
}
