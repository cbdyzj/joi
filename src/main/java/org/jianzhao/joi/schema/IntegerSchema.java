package org.jianzhao.joi.schema;

import org.jianzhao.joi.Schema;
import org.jianzhao.joi.SchemaContext;

import java.util.Optional;

public class IntegerSchema implements Schema<Integer> {

    private SchemaContext<Integer> ctx = new SchemaContext<>();

    public IntegerSchema() {
        this.ctx.addPredicate(Integer.class::isInstance);
    }

    @Override
    public Optional<String> validate(Integer target) {
        return this.ctx.validate(target);
    }

    public IntegerSchema message(String message) {
        this.ctx.message(message);
        return this;
    }

    public IntegerSchema required() {
        this.ctx.required();
        return this;
    }

    public IntegerSchema max(Integer value) {
        this.ctx.addPredicate(target -> target <= value);
        return this;
    }

    public IntegerSchema min(Integer value) {
        this.ctx.addPredicate(target -> target >= value);
        return this;
    }

    public IntegerSchema greater(Integer value) {
        this.ctx.addPredicate(target -> target > value);
        return this;
    }

    public IntegerSchema less(Integer value) {
        this.ctx.addPredicate(target -> target < value);
        return this;
    }

    public IntegerSchema positive(Integer value) {
        this.ctx.addPredicate(target -> target > 0);
        return this;
    }

    public IntegerSchema negative(Integer value) {
        this.ctx.addPredicate(target -> target < 0);
        return this;
    }

}
