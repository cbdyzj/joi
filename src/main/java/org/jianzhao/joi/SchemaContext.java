package org.jianzhao.joi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SchemaContext<T> {

    private List<Schema<T>> schemas = new ArrayList<>();

    private boolean required = false;

    public boolean validate(T target) {
        if (Objects.isNull(target)) {
            return !this.required;
        }
        return this.schemas.stream().allMatch(schema -> schema.validate(target));
    }

    public void required() {
        this.required = true;
    }

    public void add(Schema<T> schema) {
        this.schemas.add(schema);
    }
}
