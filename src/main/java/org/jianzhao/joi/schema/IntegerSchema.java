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

}
