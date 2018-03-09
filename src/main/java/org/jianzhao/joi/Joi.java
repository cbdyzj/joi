package org.jianzhao.joi;

import org.jianzhao.joi.schema.IntegerSchema;
import org.jianzhao.joi.schema.ObjectSchema;
import org.jianzhao.joi.schema.StringSchema;

import java.util.Optional;

public final class Joi {

    public static <T> Optional<String> validate(T target, Schema<T> schema) {
        return schema.validate(target);
    }

    public static StringSchema string() {
        return new StringSchema();
    }

    public static IntegerSchema integer() {
        return new IntegerSchema();
    }

    public static <T> ObjectSchema<T> object() {
        return new ObjectSchema<T>();
    }

}
