package org.jianzhao.joi.schema;

import org.jianzhao.joi.AnySchema;

public class ArraySchema extends AnySchema<Object[], ArraySchema> {

    public ArraySchema() {
        this.predicate(target -> target.getClass().isArray());
    }

    public ArraySchema length(int limit) {
        return this.predicate(target -> target.length == limit);
    }

    public ArraySchema min(int limit) {
        return this.predicate(target -> target.length >= limit);
    }

    public ArraySchema max(int limit) {
        return this.predicate(target -> target.length <= limit);
    }

    public ArraySchema empty() {
        return this.length(0);
    }

    public ArraySchema notEmpty() {
        return this.min(1);
    }
}
