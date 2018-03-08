package org.jianzhao.joi;

import org.jianzhao.joi.schema.IntegerSchema;
import org.jianzhao.joi.schema.ObjectSchema;
import org.jianzhao.joi.schema.StringSchema;

public final class Joi {

    public static void validate(Object target, Schema schema) {
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

    public static ObjectSchema object() {
        return new ObjectSchema();
    }

}
