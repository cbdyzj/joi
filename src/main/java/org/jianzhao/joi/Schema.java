package org.jianzhao.joi;

public interface Schema<T> {

    Result validate(T target);

    default Schema<T> compose(Schema<T> after) {
        return target -> {
            Result rb = this.validate(target);
            return rb.isInvalid() ? rb : after.validate(target);
        };
    }
}
