package org.jianzhao.joi.schema;

import org.jianzhao.joi.Schema;
import org.joor.Reflect;

public class ObjectSchema extends SchemaWare<ObjectSchema> {

    public ObjectSchema type(Class<?> type) {
        return this.add(type::isInstance);
    }

    public ObjectSchema field(String field, Schema schema) {
        return this.add(target -> schema.validate(Reflect.on(target).get(field)));
    }
}
