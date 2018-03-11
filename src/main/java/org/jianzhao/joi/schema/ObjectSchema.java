package org.jianzhao.joi.schema;

import org.jianzhao.joi.AnySchema;
import org.jianzhao.joi.Schema;

import java.util.function.Function;

public class ObjectSchema<T> extends AnySchema<T, ObjectSchema<T>> {

    public ObjectSchema<T> type(Class<? extends T> type) {
        return this.predicate(type::isInstance);
    }

//    public <I> ObjectSchema<T> field(String field, Schema<I> schema) {
//        return this.schema(target -> schema.validate(Reflect.on(target).get(field)));
//    }

    public <I> ObjectSchema<T> field(Function<T, I> getter, Schema<I> schema) {
        return this.schema(target -> schema.validate(getter.apply(target)));
    }

}
