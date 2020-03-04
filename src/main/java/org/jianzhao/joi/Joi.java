package org.jianzhao.joi;

import org.jianzhao.joi.schema.*;

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

    public static ArraySchema array() {
        return new ArraySchema();
    }

    public static <T> ListSchema<T> list() {
        return new ListSchema<>();
    }

    public static <K, V> MapSchema<K, V> map() {
        return new MapSchema<>();
    }


}
