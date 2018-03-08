package org.jianzhao.joi.schema;

public class IntegerSchema extends SchemaWare<IntegerSchema> {

    public IntegerSchema() {
        this.add(target -> target instanceof Integer);
    }

    public IntegerSchema max(Integer value) {
        return this.add(target -> (Integer) target <= value);
    }

    public IntegerSchema min(Integer value) {
        return this.add(target -> (Integer) target >= value);
    }

    public IntegerSchema greater(Integer value) {
        return this.add(target -> (Integer) target > value);
    }

    public IntegerSchema less(Integer value) {
        return this.add(target -> (Integer) target < value);
    }

    public IntegerSchema positive(Integer value) {
        return this.add(target -> (Integer) target > 0);
    }

    public IntegerSchema negative(Integer value) {
        return this.add(target -> (Integer) target < 0);
    }

}
