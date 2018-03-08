package org.jianzhao.joi.schema;

public class IntegerSchema extends SchemaWare<IntegerSchema, Integer> {

    public IntegerSchema() {
        this.add(Integer.class::isInstance);
    }

    public IntegerSchema max(Integer value) {
        return this.add(target -> target <= value);
    }

    public IntegerSchema min(Integer value) {
        return this.add(target -> target >= value);
    }

    public IntegerSchema greater(Integer value) {
        return this.add(target -> target > value);
    }

    public IntegerSchema less(Integer value) {
        return this.add(target -> target < value);
    }

    public IntegerSchema positive(Integer value) {
        return this.add(target -> target > 0);
    }

    public IntegerSchema negative(Integer value) {
        return this.add(target -> target < 0);
    }

}
