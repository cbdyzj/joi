package org.jianzhao.joi.schema;

import org.jianzhao.joi.Schema;
import org.jianzhao.joi.SchemaContext;
import org.joor.Reflect;

import java.util.function.Function;

public class ObjectSchema<T> implements Schema<T> {

    private SchemaContext<T> ctx = new SchemaContext<>();

    @Override
    public boolean validate(T target) {
        return this.ctx.validate(target);
    }

    public ObjectSchema<T> type(Class<T> type) {
        this.ctx.add(type::isInstance);
        return this;
    }

    public ObjectSchema<T> required() {
        this.ctx.required();
        return this;
    }

    public <I> ObjectSchema<T> field(String field, Schema<I> schema) {
        this.ctx.add(target -> schema.validate(Reflect.on(target).get(field)));
        return this;
    }

    public <I> ObjectSchema<T> field(Function<T, I> getter, Schema<I> schema) {
        this.ctx.add(target -> schema.validate(getter.apply(target)));
        return this;
    }

}
