package org.jianzhao.joi;

import org.jianzhao.joi.util.SchemaUtils;

@FunctionalInterface
public interface Schema<T> {

    Result validate(T target);

    default Schema<T> compose(Schema<T> after) {
        return target -> SchemaUtils.mergeResult(this.validate(target), after.validate(target));
    }

    default Schema<T> message(String message) {
        return target -> {
            Result result = this.validate(target);
            if (result.isInvalid()) {
                result = SchemaUtils.mergeResult(result, Result.of(message));
            }
            return result;
        };
    }
}
