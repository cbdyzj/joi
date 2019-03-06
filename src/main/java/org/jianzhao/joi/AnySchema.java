package org.jianzhao.joi;

import org.jianzhao.joi.util.Schemas;

import java.util.function.Predicate;

@SuppressWarnings({"unchecked", "WeakerAccess"})
public abstract class AnySchema<T, S extends AnySchema<T, S>> implements Schema<T> {

    protected Schema<T> delegate = target -> Result.valid();

    private boolean required = false;

    @Override
    public Result validate(T target) {
        if (null == target) {
            return this.required ? Result.invalid() : Result.valid();
        }
        return this.delegate.validate(target);
    }

    @Override
    public Schema<T> compose(Schema<T> schema) {
        this.delegate = this.delegate.compose(schema);
        return this;
    }

    public S predicate(Predicate<T> predicate) {
        Schema<T> schema = Schemas.predicate(predicate);
        return (S) this.compose(schema);
    }

    public S required() {
        this.required = true;
        return (S) this;
    }
}
