package org.jianzhao.joi;

@FunctionalInterface
public interface Schema<T> {

    Result validate(T target);

    /**
     * Compose Schema
     *
     * @since 0.2.0
     */
    default Schema<T> compose(Schema<T> after) {
        return target -> {
            Result rb = this.validate(target);
            return rb.isInvalid() ? rb : after.validate(target);
        };
    }

    /**
     * Invert Schema
     * Experimental feature
     *
     * @since 0.2.1
     */
    default Schema<T> invert(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message require non-null!");
        }
        return target -> this.validate(target).isInvalid() ? Result.valid() : Result.of(message);
    }

}
