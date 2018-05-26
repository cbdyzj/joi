package org.jianzhao.joi;

import org.jianzhao.joi.util.Schemas;

import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public abstract class AnySchema<T, S extends Schema<T>> implements Schema<T> {

    protected Schema<T> delegate = target -> Result.valid();

    private boolean isRequired = false;

    public Result validate(T target) {
        if (null == target && !this.isRequired) {
            return Result.valid();
        }
        return this.delegate.validate(target);
    }

    public Schema<T> compose(Schema<T> schema) {
        this.delegate = this.delegate.compose(schema);
        return this;
    }

    public S predicate(Predicate<T> predicate) {
        Schema<T> schema = Schemas.predicate(predicate);
        return (S) this.compose(schema);
    }

    public S required() {
        this.isRequired = true;
        return (S) this;
    }
}
