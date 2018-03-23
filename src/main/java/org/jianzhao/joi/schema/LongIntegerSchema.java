package org.jianzhao.joi.schema;

import org.jianzhao.joi.AnySchema;

public class LongIntegerSchema extends AnySchema<Long, LongIntegerSchema> {

    public LongIntegerSchema() {
        this.predicate(Long.class::isInstance);
    }

    public LongIntegerSchema max(long value) {
        return this.predicate(target -> target <= value);
    }

    public LongIntegerSchema min(long value) {
        return this.predicate(target -> target >= value);
    }

    public LongIntegerSchema greater(long value) {
        return this.predicate(target -> target > value);
    }

    public LongIntegerSchema less(long value) {
        return this.predicate(target -> target < value);
    }

    public LongIntegerSchema positive(long value) {
        return this.predicate(target -> target > 0);
    }

    public LongIntegerSchema negative(long value) {
        return this.predicate(target -> target < 0);
    }

}
