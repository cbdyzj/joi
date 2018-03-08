package org.jianzhao.joi.schema;

public class StringSchema extends SchemaWare<StringSchema> {

    public StringSchema() {
        this.add(target -> target instanceof String);
    }

    public StringSchema regex(String pattern) {
        this.add(target -> ((String) target).matches(pattern));
        return this;
    }

    public StringSchema alphanum() {
        this.add(target -> ((String) target).matches("^[a-zA-Z0-9]+$"));
        return this;
    }
}
