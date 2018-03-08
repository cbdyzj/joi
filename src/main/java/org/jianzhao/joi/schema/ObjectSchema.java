package org.jianzhao.joi.schema;

import org.jianzhao.joi.Schema;
import org.joor.Reflect;

public class ObjectSchema extends SchemaWare<ObjectSchema> {

    public ObjectSchema type(Class<?> type) {
        this.add(type::isInstance);
        return this;
    }

    public ObjectSchema field(String field, Schema schema) {
        this.add(target -> schema.validate(Reflect.on(target).get(field)));
        return this;
    }
}
