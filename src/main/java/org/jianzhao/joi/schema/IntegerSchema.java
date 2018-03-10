package org.jianzhao.joi.schema;

import org.jianzhao.joi.AnySchema;

public class IntegerSchema extends AnySchema<Integer, IntegerSchema> {

    public IntegerSchema() {
        this.predicate(Integer.class::isInstance);
    }

    public IntegerSchema max(Integer value) {
        return this.predicate(target -> target <= value);
    }

    public IntegerSchema min(Integer value) {
        return this.predicate(target -> target >= value);
    }

    public IntegerSchema greater(Integer value) {
        return this.predicate(target -> target > value);
    }

    public IntegerSchema less(Integer value) {
        return this.predicate(target -> target < value);
    }

    public IntegerSchema positive(Integer value) {
        return this.predicate(target -> target > 0);
    }

    public IntegerSchema negative(Integer value) {
        return this.predicate(target -> target < 0);
    }

}
