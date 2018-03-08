package org.jianzhao.joi.schema;

import org.jianzhao.joi.Schema;

import java.util.ArrayList;
import java.util.List;

public abstract class SchemaWare<T extends SchemaWare> implements Schema {

    private List<Schema> schemas = new ArrayList<>();

    private boolean isRequired = false;

    @Override
    public boolean validate(Object target) {
        if (null == target) {
            return !this.isRequired;
        }
        return this.schemas.stream().allMatch(schema -> schema.validate(target));
    }

    public T required() {
        this.isRequired = true;
        // noinspection unchecked
        return (T) this;
    }

    void add(Schema schema) {
        this.schemas.add(schema);
    }
}
