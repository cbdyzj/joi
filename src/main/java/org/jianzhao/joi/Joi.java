package org.jianzhao.joi;

import org.jianzhao.joi.schema.IntegerSchema;
import org.jianzhao.joi.schema.ObjectSchema;
import org.jianzhao.joi.schema.StringSchema;

public final class Joi {

    public static <T> void validate(T target, Schema<T> schema) {
        if (!schema.validate(target)) {
            throw new JoiException("Validate failed");
        }
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
