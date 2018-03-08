package org.jianzhao.joi.schema;

public class IntegerSchema extends SchemaWare<IntegerSchema> {

    public IntegerSchema() {
        this.add(target -> target instanceof Integer);
    }

    public IntegerSchema max(Integer value) {
        this.add(target -> (Integer) target <= value);
        return this;
    }

    public IntegerSchema min(Integer value) {
        this.add(target -> (Integer) target >= value);
        return this;
    }

}
