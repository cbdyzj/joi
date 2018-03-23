package org.jianzhao.joi;

import org.jianzhao.joi.schema.IntegerSchema;
import org.jianzhao.joi.schema.LongIntegerSchema;
import org.jianzhao.joi.schema.ObjectSchema;
import org.jianzhao.joi.schema.StringSchema;

public final class Joi {

    public static <T> Result validate(T target, Schema<T> schema) {
        return schema.validate(target);
    }

    public static <T> ObjectSchema<T> object() {
        return new ObjectSchema<T>();
    }

    public static StringSchema string() {
        return new StringSchema();
    }

    public static IntegerSchema integer() {
        return new IntegerSchema();
    }

    public static LongIntegerSchema longInteger() {
        return new LongIntegerSchema();
    }

}
