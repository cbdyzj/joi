package org.jianzhao.joi.schema;

import org.jianzhao.joi.Schema;
import org.joor.Reflect;

public class ObjectSchema<T> extends SchemaWare<ObjectSchema<T>, T> {

    public ObjectSchema<T> type(Class<T> type) {
        return this.add(type::isInstance);
    }

    public <I> ObjectSchema<T> field(String field, Schema<I> schema) {
        return this.add(target -> schema.validate(Reflect.on(target).get(field)));
    }
}
