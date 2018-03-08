package org.jianzhao.joi.schema;

import org.jianzhao.joi.Schema;

import java.util.ArrayList;
import java.util.List;

public abstract class SchemaWare<S extends Schema<T>, T> implements Schema<T> {

    private List<Schema<T>> schemas = new ArrayList<>();

    private boolean isRequired = false;

    @Override
    public boolean validate(T target) {
        if (null == target) {
            return !this.isRequired;
        }
        return this.schemas.stream().allMatch(schema -> schema.validate(target));
    }

    @SuppressWarnings("unchecked")
    public S required() {
        this.isRequired = true;
        return (S) this;
    }

    @SuppressWarnings("unchecked")
    S add(Schema<T> schema) {
        this.schemas.add(schema);
        return (S) this;
    }
}
